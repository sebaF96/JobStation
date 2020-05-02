package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Developer;
import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService extends GenericServiceImpl<Interview> {

    private final InterviewRepository interviewRepository;
    private final UserRepository userRepository;
    private  final ApplicationRepository applicationRepository;

    public InterviewService(InterviewRepository interviewRepository, UserRepository userRepository, ApplicationRepository applicationRepository) {
        this.interviewRepository = interviewRepository;
        this.userRepository = userRepository;
        this.applicationRepository = applicationRepository;
    }

    @Override
    JpaRepository<Interview, Long> getRepository() {
        return interviewRepository;
    }

    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).get();
    }





}
