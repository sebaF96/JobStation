package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.model.Company;
import ar.edu.um.jobs.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/comp")
@Controller
public class CompanyController {
    @Autowired
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/register")
    public String registerGet(Model model) {
        model.addAttribute("company", new Company());
        return "register-company";
    }

    @PostMapping(value = "/register")
    public String registerPost(@Valid Company company, Model model) {
        company.setRoles("ROLE_COMPANY");
        companyService.create(company);
        return "register-company";
    }

    @GetMapping("/myapplications")
    public String companyApplications(Model model) {
        model.addAttribute("applications", companyService.listApplicationsbyCompany());
        return "vistaaplications de la company";
    }

    @GetMapping("/myinterviews")
    public String companyInterviews(Model model) {
        model.addAttribute("interviews", companyService.listInterviews());
        return "table-interviews";
    }
}
