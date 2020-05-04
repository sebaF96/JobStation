package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Developer;
import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public String devInterviews(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        Integer currentPage = 1;
        Integer pageSize = 5;
        int totalPages;

        Page<Interview> dataPage;
        if (!page.isPresent() && !size.isPresent()) {
            dataPage = developerService.listInterviews(currentPage, pageSize);
        } else {
            dataPage = developerService.listInterviews(page.get(), size.get());
        }

        totalPages = dataPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("interviews", dataPage);
        model.addAttribute("name", developerService.getCurrentDeveloper().getName());

        return "developer-interviews";
    }

    @GetMapping("/myapplications")
    public String devApplications(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        Integer currentPage = 1;
        Integer pageSize = 5;
        int totalPages;

        Page<Application> dataPage;
        if (!page.isPresent() && !size.isPresent()) {
            dataPage = developerService.listApplications(currentPage, pageSize);
        } else {
            dataPage = developerService.listApplications(page.get(), size.get());
        }

        totalPages = dataPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("applications", dataPage);
        model.addAttribute("name", developerService.getCurrentDeveloper().getName());

        return "developer-applications";
    }
}

