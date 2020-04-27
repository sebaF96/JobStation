package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.JobRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService extends GenericServImpl<User> {
    @Autowired
    private final UserRepository companyRepository;
    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;


    public CompanyService(UserRepository companyRepository, ApplicationRepository applicationRepository, JobRepository jobRepository) {
        this.companyRepository = companyRepository;
        this.applicationRepository = applicationRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    JpaRepository<User, Long> getRepository() {
        return companyRepository;
    }

    public List<Application> listApplications(Long jobId) {
        if (jobRepository.findById(jobId).isPresent()) {
            return applicationRepository.findByJob(jobRepository.findById(jobId).get());
        } else {
            return null;
        }
    }
}



