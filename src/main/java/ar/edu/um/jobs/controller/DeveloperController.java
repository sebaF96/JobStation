package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.model.Developer;
import ar.edu.um.jobs.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("dev")
@Controller
public class DeveloperController {
    @Autowired
    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping(value = "/register")
    public String registerDevGet(Model model) {
        model.addAttribute("developer", new Developer());
        return "register-developer";
    }

    @PostMapping(value = "/register")
    public String registerPost(@Valid Developer developer) {
        developer.setRoles("ROLE_DEVELOPER");
        developerService.create(developer);
        return "register-developer";
    }

    @GetMapping("/myinterviews")
    public String devInterviews(Model model) {
        model.addAttribute("interviews", developerService.listInterviews());
        model.addAttribute("name", developerService.getCurrentDeveloper().getName());

        return "developer-interviews";
    }

    @GetMapping("/myapplications")
    public String devApplications(Model model) {
        model.addAttribute("applications", developerService.listApplications());
        model.addAttribute("name", developerService.getCurrentDeveloper().getName());

        return "developer-applications";
    }
}

