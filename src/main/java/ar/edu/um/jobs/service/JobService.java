package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Job;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.JobRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService extends GenericServiceImpl<Job> {

    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;

    public JobService(JobRepository jobRepository, ApplicationRepository applicationRepository) {
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
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


}