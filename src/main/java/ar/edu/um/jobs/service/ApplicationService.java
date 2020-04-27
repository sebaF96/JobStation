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
    JpaRepository<Application, Long> getRepository() {
        return applicationRepository;
    }
}
