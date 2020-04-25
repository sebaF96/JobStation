package ar.edu.um.jobs.service;

import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class DeveloperService extends GenericServImpl<User> {
    @Autowired
    private final UserRepository developerRepository;

    public DeveloperService(UserRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    JpaRepository<User, Long> getRepository() {
        return developerRepository;
    }
}
