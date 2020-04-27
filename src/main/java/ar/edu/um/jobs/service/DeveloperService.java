package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.ApplicationRepository;
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
    private final ApplicationRepository applicationRepository;

    public DeveloperService(UserRepository developerRepository, InterviewRepository interviewRepository, ApplicationRepository applicationRepository) {
        this.developerRepository = developerRepository;
        this.interviewRepository = interviewRepository;
        this.applicationRepository = applicationRepository;
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

    public List<Application> listApplications(Long developerId) {
        if (developerRepository.findById(developerId).isPresent()) {
            return applicationRepository.findByDeveloper(developerRepository.findById(developerId).get());
        }
        return null;
    }
}
