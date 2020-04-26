package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.model.*;
import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.JobRepository;
import ar.edu.um.jobs.repository.UserRepository;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("")
public class test {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;
    private final InterviewRepository interviewRepository;

    public test(UserRepository userRepository, JobRepository jobRepository, ApplicationRepository applicationRepository, InterviewRepository interviewRepository) {
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
        this.interviewRepository = interviewRepository;
    }

    @GetMapping("/test")
    public String asd() {
        Developer dev = new Developer();

        dev.setAddress("um 20");
        dev.setDob(LocalDate.now());
        dev.setName("ruben");
        dev.setPhone_number(2828930);
        dev.setEmail("ruben@fisica.com");
        dev.setPassword("fluidos");
        dev.setRoles("ROLE_DEVELOPER");

        userRepository.save(dev);

        Company company = new Company();

        company.setLocation("Silicon Valley");
        company.setName("Google");
        company.setEmail("google@gmail.com");
        company.setPassword("12346");
        company.setRoles("ROLE_COMPANY");

        userRepository.save(company);


        Job job = new Job();

        job.setCompany(company);
        job.setAvailable_slots(2);
        job.setJob_type(JobType.FULL_TIME);
        job.setJob_title("Engineer");
        job.setSalary(5000.0);

        jobRepository.save(job);

        Application ap = new Application();

        ap.setJob(job);
        ap.setDeveloper(dev);
        ap.setSeniority(Seniority.JUNIOR);
        ap.setSpeaks_english(Boolean.TRUE);
        ap.setYears_xp(2);

        applicationRepository.save(ap);


        Interview in = new Interview();

        in.setApplication(ap);
        in.setDate(LocalDateTime.now());
        in.setDeveloper(dev);
        in.setDescription("mmmmm");

        interviewRepository.save(in);

        return "yes";
    }
}
