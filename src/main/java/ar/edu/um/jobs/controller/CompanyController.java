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

@RequestMapping("/company")
@Controller
public class CompanyController {
    @Autowired
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/register")
    public String registerGet(Model model){
        model.addAttribute("company",new Company());
        return "register-company";
    }

    @PostMapping(value = "/register")
    public String registerPost(@Valid Company company,Model model){
        companyService.create(company);
        return "register-company";
    }
}
