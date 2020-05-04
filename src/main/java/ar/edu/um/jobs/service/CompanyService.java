package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.*;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.JobRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService extends GenericServiceImpl<User> {

    private final UserRepository companyRepository;
    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private  final InterviewRepository interviewRepository;


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

    public List<Job> listJobs() {
        Long companyId = companyRepository.getCurrentUser().get().getId();


        return jobRepository.findByCompany((Company) this.get(companyId).get());
    }

    public List<Application> listApplicationsbyCompany() {
        List<Application> applications;
        Long companyId = companyRepository.getCurrentUser().get().getId();

        applications = applicationRepository.findAll()
                .stream()
                .filter(a -> a.getJob().getCompany().getId().equals(companyId))
                .collect(Collectors.toList());


        return applications.stream().sorted((x, y) -> y.getPriority().compareTo(x.getPriority())).collect(Collectors.toList());
    }

    public List<Interview> listInterviews() {
        Long companyId = companyRepository.getCurrentUser().get().getId();

        return interviewRepository.findAll()
                 .stream()
                 .filter(interview -> interview.getApplication().getJob().getCompany().getId().equals(companyId))
                 .filter(interview -> interview.getDate().isAfter(LocalDate.now()))
                 .sorted(Comparator.comparing(Interview::getDate))
                 .collect(Collectors.toList());


    }



}



