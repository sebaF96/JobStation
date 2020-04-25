package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Job;
import ar.edu.um.jobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService  {

    @Autowired
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void create(Job job) {
        if (job.getJob_id() == null && !validateJob(job.getJob_id())) {
            jobRepository.save(job);
        }
    }

    public void remove(Long id) {
        if (validateJob(id)) {
            jobRepository.delete(jobRepository.findById(id).get());
        }
    }

    public boolean validateJob(Long id) {
        boolean validate;
        Optional<Job> job = jobRepository.findById(id);
        validate = job.isPresent();
        return validate;
    }

    public Job get(Long id) {
        return (!validateJob(id)) ? new Job() : jobRepository.findById(id).get();
    }


    public void update(Job job) {
        if (validateJob(job.getJob_id())) {
            jobRepository.save(job);
        }
    }


}