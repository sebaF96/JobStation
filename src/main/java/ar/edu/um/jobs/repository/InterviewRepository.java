package ar.edu.um.jobs.repository;


import ar.edu.um.jobs.model.Interview;
import ar.edu.um.jobs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

    List<Interview> findByDeveloper(User developer);

}
