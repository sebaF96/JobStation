package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Company;
import ar.edu.um.jobs.model.Job;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.JobRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService extends GenericServiceImpl<Job> {

    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public JobService(JobRepository jobRepository, ApplicationRepository applicationRepository, UserRepository userRepository) {
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }

    @Override
    JpaRepository<Job, Long> getRepository() {
        return jobRepository;
    }

    public List<Application> getApplications(Long jobId) {
        List<Application> applications = new ArrayList<>();

        if (this.get(jobId).isPresent()) {
            applications = applicationRepository.findByJob(this.get(jobId).get());
        }

        return applications.stream().sorted((x, y) -> y.getPriority().compareTo(x.getPriority())).collect(Collectors.toList());

    }

    public List<Job> getAvailableJobs() {
        return this.getAll()
                .stream()
                .filter(j -> j.getAvailable_slots() >= 1)
                .collect(Collectors.toList());
    }

    public Company getCurrentCompany() {
        return (Company) userRepository.findById(userRepository.getCurrentUser().get().getId()).get();
    }


}