package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Company;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService  {
    @Autowired
    private final UserRepository companyRepository;

    public CompanyService(UserRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void createCompany(Company company) {
        if (company.getUser_id() == null && !validateCompany(company.getUser_id())) {
            companyRepository.save(company);
        }
    }

    public void removeCompany(Long id) {
        if (validateCompany(id)) {
            companyRepository.delete((companyRepository.findById(id).get()));
        }

    }


    public boolean validateCompany(Long id) {
        boolean validator;
        Optional<User> company = companyRepository.findById(id);
        validator = company.isPresent();
        return validator;
    }


}



