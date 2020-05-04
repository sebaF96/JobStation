package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.Developer;
import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperService extends GenericServiceImpl<User> {

    private final UserRepository developerRepository;
    private final InterviewRepository interviewRepository;
    private final ApplicationRepository applicationRepository;

    public DeveloperService(UserRepository developerRepository, InterviewRepository interviewRepository, ApplicationRepository applicationRepository, UserRepository userRepository) {
        this.developerRepository = developerRepository;
        this.interviewRepository = interviewRepository;
        this.applicationRepository = applicationRepository;

    }

    @Override
    JpaRepository<User, Long> getRepository() {
        return developerRepository;
    }

    public Page<Interview> listInterviews(Integer currentPage,Integer pageSize) {

        Long developerId = developerRepository.getCurrentUser().get().getId();

        return interviewRepository.findByDeveloperOrderByDate(PageRequest.of(currentPage-1,pageSize),this.get(developerId).get());

    }


    public Page<Application> listApplications(Integer currentPage, Integer pageSize) {

        Long developerId = developerRepository.getCurrentUser().get().getId();

        return applicationRepository.findByDeveloper(PageRequest.of(currentPage-1,pageSize),this.get(developerId).get());
    }

    public Developer getCurrentDeveloper() {
        return (Developer) developerRepository.getCurrentUser().get();
    }
}
