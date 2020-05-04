package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.model.Job;
import ar.edu.um.jobs.model.JobType;
import ar.edu.um.jobs.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/job")
public class JobController {


    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("/{id}")
    public String getJob(@PathVariable Long id, Model model) {
        Job job = jobService.get(id).get();
        model.addAttribute("job", job);

        return "particular-job";
    }

    @GetMapping("/c/create")
    public String createJob(Model model) {
        model.addAttribute("job", new Job());
        model.addAttribute("jobtypes", JobType.values());
        model.addAttribute("action", "/job/c/create");
        model.addAttribute("title", "Create job");
        return "register-job";
    }

    @PostMapping("/c/create")
    public String createJobPost(@Valid Job job, RedirectAttributes redirectAttributes) {

        job.setCompany(jobService.getCurrentCompany());
        jobService.create(job);
        redirectAttributes.addFlashAttribute("flash", "Job successfully created!");

        return "redirect:/job/c/myjobs";

    }

    @GetMapping("/c/myjobs")
    public String listJobs(Model model) {
        model.addAttribute("jobs", jobService.getMyJobs(jobService.getCurrentCompany().getId()));
        return "company-jobs";
    }

    @GetMapping("/c/edit/{id}")
    public String editGet(@PathVariable Long id, Model model) {
        model.addAttribute("jobtypes", JobType.values());
        model.addAttribute("job", jobService.get(id).get());
        model.addAttribute("action", "/job/c/edit/" + id);
        model.addAttribute("title", "Update job");
        return "register-job";
    }

    @PostMapping("/c/edit/{id}")
    public String editPost(Job updated_job, @PathVariable Long id, RedirectAttributes redirectAttributes) {

        jobService.update(updated_job, id);
        redirectAttributes.addFlashAttribute("flash", "Job successfully edited!");
        return "redirect:/job/c/myjobs";
    }

    @GetMapping("/c/delete/{id}")
    public String deleteJob(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        jobService.remove(id);
        redirectAttributes.addFlashAttribute("flash", "Job successfully deleted!");

        return "redirect:/job/c/myjobs";
    }

}
