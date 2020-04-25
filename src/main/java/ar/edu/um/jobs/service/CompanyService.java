package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends GenericServImpl<User>{
    @Autowired
    private final UserRepository companyRepository;

    public CompanyService(UserRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    JpaRepository<User, Long> getRepository() {
        return companyRepository;
    }
}



