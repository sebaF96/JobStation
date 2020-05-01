package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.Application;
import ar.edu.um.jobs.repository.ApplicationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService extends GenericServiceImpl<Application> {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
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
}
