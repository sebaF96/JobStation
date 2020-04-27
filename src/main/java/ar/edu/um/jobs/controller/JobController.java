package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/job")
public class JobController {


    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/get/{id}")
    public String getJob(@PathVariable Long id, Model model) {
        System.out.println(jobService.get(id));
        return "probe";
    }

}
