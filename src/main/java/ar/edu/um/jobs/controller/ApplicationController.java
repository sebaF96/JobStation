package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Job;
import ar.edu.um.jobs.model.Seniority;
import ar.edu.um.jobs.service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/application")
@Controller
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/d/create/{id}")
    public String createAppGet(@PathVariable Long id, Model model) {
        Application application = new Application();
        model.addAttribute("application", application);
        model.addAttribute("seniorities", Seniority.values());
        model.addAttribute("action", "/application/d/create/" + id);
        return "register-application";
    }

    @PostMapping("/d/create/{id}")
    public String createAppPost(@PathVariable Long id, @Valid Application application, RedirectAttributes redirectAttributes) {
        application.setJob(applicationService.getJobById(id));
        application.setDeveloper(applicationService.getCurrentDeveloper());
        applicationService.create(application);
        redirectAttributes.addFlashAttribute("flash", "Application successfully sent!");

        return "redirect:/dev/myapplications";
    }

    @GetMapping("/{id}")
    public String getApplication(@PathVariable Long id, Model model) {
        model.addAttribute("seniorities", Seniority.values());
        model.addAttribute("app", applicationService.get(id).get());
        model.addAttribute("hasinterview", applicationService.hasInterview(id));

        return "particular-application";
    }

    @GetMapping("/c/job/{id}")
    public String getApplicationsByJob(@PathVariable Long id, Model model) {

        model.addAttribute("applications", applicationService.getAppsByJob(id));
        model.addAttribute("job", applicationService.getJobById(id).getJob_title());

        return "table-applications";

    }

    @GetMapping("/c/delete/{id}")
    public String deleteApplication(@PathVariable Long id) {

        applicationService.remove(id);

        return "redirect:/comp/myapplications";
    }
}
