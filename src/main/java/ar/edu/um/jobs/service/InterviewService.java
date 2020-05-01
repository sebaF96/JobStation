package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InterviewService extends GenericServiceImpl<Interview> {

    private final InterviewRepository interviewRepository;
    private final UserRepository userRepository;

    public InterviewService(InterviewRepository interviewRepository, UserRepository userRepository) {
        this.interviewRepository = interviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    JpaRepository<Interview, Long> getRepository() {
        return interviewRepository;
    }

    Optional<User> getCurrentUser() {
        return userRepository.getCurrentUser();
    }
}
