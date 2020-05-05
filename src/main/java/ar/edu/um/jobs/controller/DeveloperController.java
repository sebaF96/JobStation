package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Developer;
import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.service.DeveloperService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("dev")
@Controller
public class DeveloperController {

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
    public String registerPost(@Valid Developer developer, RedirectAttributes redirectAttributes) {
        developer.setRoles("ROLE_DEVELOPER");

        if (developerService.create(developer) == null) {
            redirectAttributes.addFlashAttribute("flash", "There's an account with this email already!");
            return "redirect:/dev/register";
        }

        return "redirect:/login";
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

