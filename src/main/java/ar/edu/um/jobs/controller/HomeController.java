package ar.edu.um.jobs.controller;


import ar.edu.um.jobs.model.Job;
import ar.edu.um.jobs.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    private final JobService jobService;

    public HomeController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping({"/", ""})
    public String home(Model model) {

        List<Job> availableJobs = jobService.getAvailableJobs();
        Collections.reverse(availableJobs);
        model.addAttribute("jobs",availableJobs);
        return "index";
    }

    @GetMapping("/filter")
    public String getFilter(Model model, @RequestParam String q){
        model.addAttribute("jobs",jobService.filter(q));
        return "index";
    }
}

