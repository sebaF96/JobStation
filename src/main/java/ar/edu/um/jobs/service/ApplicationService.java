package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService extends GenericServiceImpl<Application> {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public ApplicationService(ApplicationRepository applicationRepository, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
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

    Optional<User> getCurrentUser() {
        return userRepository.getCurrentUser();
    }
}
