package ar.edu.um.jobs.repository;

import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.security.MyUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

     default Optional<User> getCurrentUser() {
        return this.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
