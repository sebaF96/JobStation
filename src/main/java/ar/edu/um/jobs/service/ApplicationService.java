package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.*;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.JobRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationService extends GenericServiceImpl<Application> {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final InterviewRepository interviewRepository;

    public ApplicationService(ApplicationRepository applicationRepository, UserRepository userRepository, JobRepository jobRepository, InterviewRepository interviewRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.interviewRepository = interviewRepository;
    }

    @Override
    public Application create(Application application) {
        Integer priority = 0;
        priority += application.getYears_xp();
        priority += application.getSpeaks_english() ? 4 : 0;
        priority += application.getSeniority().getPriority();
        application.setPriority(priority);

        return applicationRepository.save(application);
    }

    @Override
    JpaRepository<Application, Long> getRepository() {
        return applicationRepository;
    }

    public Developer getCurrentDeveloper() {
        return (Developer) userRepository.findById(userRepository.getCurrentUser().get().getId()).get();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).get();
    }

    public List<Application> getAppsByJob(Long id) {

        return applicationRepository.findAll()
                .stream()
                .filter(a -> a.getJob().getJob_id().equals(id))
                .sorted((x, y) -> y.getPriority().compareTo(x.getPriority()))
                .collect(Collectors.toList());
    }

    public boolean hasInterview(Long id) {
        return interviewRepository.findAll()
                .stream()
                .filter(i -> i.getApplication().getApplication_id().equals(id))
                .count() >= 1;
    }
}
