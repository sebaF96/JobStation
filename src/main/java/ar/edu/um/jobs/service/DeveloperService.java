package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperService extends GenericServiceImpl<User> {

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
        List<Interview> interviews = new ArrayList<>();

        if (this.get(developerId).isPresent()) {
            interviews = interviewRepository.findByDeveloper(this.get(developerId).get());
        }
        return interviews;
    }


    public List<Application> listApplications(Long developerId) {
        List<Application> applications = new ArrayList<>();
        if (this.get(developerId).isPresent()) {
            applications = applicationRepository.findByDeveloper(this.get(developerId).get());
        }
        return applications;
    }
}
