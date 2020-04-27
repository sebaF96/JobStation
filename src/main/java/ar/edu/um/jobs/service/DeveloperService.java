package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeveloperService extends GenericServImpl<User> {
    @Autowired
    private final UserRepository developerRepository;
    private final InterviewRepository interviewRepository;

    public DeveloperService(UserRepository developerRepository, InterviewRepository interviewRepository) {
        this.developerRepository = developerRepository;
        this.interviewRepository = interviewRepository;
    }

    @Override
    JpaRepository<User, Long> getRepository() {
        return developerRepository;
    }

    public List<Interview> listInterviews(Long developerId) {
        if (developerRepository.findById(developerId).isPresent()) {
            return interviewRepository.findByDeveloper(developerRepository.findById(developerId).get());
        } else {
            return null;
        }
    }
}
