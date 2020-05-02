package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.service.InterviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/interview")
public class InterviewController {
    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping("/c/create/{id}")
    public String createInterview(@PathVariable Long id, Model model){
        Interview interview = new Interview();
        model.addAttribute("interview",interview);

        return "/ruta";
    }
    @PostMapping("/c/create/{id}")
    public String postCreateInterview(@PathVariable Long id, @Valid Interview interview){
        interview.setApplication(interviewService.getApplicationById(id));
        interview.setDeveloper(interviewService.getApplicationById(id).getDeveloper());
        System.out.println(interview);
        interviewService.create(interview);
        return "/ vista";

    }
    @GetMapping("/c/futureInterviews")
    public String getInterview(){

    }




}
