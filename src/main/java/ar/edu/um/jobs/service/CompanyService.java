package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.JobRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService extends GenericServImpl<User> {
    @Autowired
    private final UserRepository companyRepository;
    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private final InterviewRepository interviewRepository;

    public CompanyService(UserRepository companyRepository, ApplicationRepository applicationRepository, JobRepository jobRepository, InterviewRepository interviewRepository) {
        this.companyRepository = companyRepository;
        this.applicationRepository = applicationRepository;
        this.jobRepository = jobRepository;
        this.interviewRepository = interviewRepository;
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

    public List<Interview> listInterviews(Long companyId) {
        if (companyRepository.findById(companyId).isPresent()) {
            return interviewRepository.findAll()
                    .stream()
                    .filter(interview -> interview.getApplication().getJob().getCompany().getId().equals(companyId))
                    .filter(interview -> interview.getDate().isAfter(LocalDateTime.now()))
                    .sorted()
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }


}



