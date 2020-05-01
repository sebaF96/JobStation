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
        return "register-job";
    }

    @PostMapping("/c/create")
    public String createJobPost(@Valid Job job) {

        job.setCompany(jobService.getCurrentCompany());
        jobService.create(job);

        return "register-job";

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
        model.addAttribute("action", "/job/c/edit");
        return "register-job";
    }

    @PostMapping("/c/edit")
    public String editPost(Job job) {
        System.out.println(job);
        jobService.update(job);
        return "redirect:/job/c/myjobs";
    }

}
