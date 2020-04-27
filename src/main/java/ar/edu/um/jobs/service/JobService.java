package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Job;
import ar.edu.um.jobs.repository.JobRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService extends GenericServiceImpl<Job> {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    JpaRepository<Job, Long> getRepository() {
        return jobRepository;
    }


}