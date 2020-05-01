package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.repository.InterviewRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InterviewService extends GenericServiceImpl<Interview> {

    private final InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    @Override
    JpaRepository<Interview, Long> getRepository() {
        return interviewRepository;
    }
}
