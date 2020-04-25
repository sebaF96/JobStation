package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class InterviewService extends GenericServImpl<Interview> {

    @Autowired
    private final InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    @Override
    JpaRepository<Interview, Long> getRepository() {
        return interviewRepository;
    }
}
