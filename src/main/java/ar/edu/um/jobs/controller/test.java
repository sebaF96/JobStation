package ar.edu.um.jobs.controller;

import ar.edu.um.jobs.repository.ApplicationRepository;
import ar.edu.um.jobs.repository.InterviewRepository;
import ar.edu.um.jobs.repository.JobRepository;
import ar.edu.um.jobs.repository.UserRepository;
import ar.edu.um.jobs.service.CompanyService;
import ar.edu.um.jobs.service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class test {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;
    private final InterviewRepository interviewRepository;
    private final CompanyService companyService;
    private final DeveloperService developerService;
    public test(UserRepository userRepository, JobRepository jobRepository, ApplicationRepository applicationRepository, InterviewRepository interviewRepository, CompanyService companyService, DeveloperService developerService) {
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
        this.interviewRepository = interviewRepository;
        this.companyService = companyService;
        this.developerService = developerService;
    }

    @GetMapping("/test")
    public String asd() {
        /*
        Developer dev = new Developer();

        dev.setAddress("um 20");
        dev.setDob(LocalDate.now());
        dev.setName("ruben");
        dev.setPhone_number(2828930);
        dev.setEmail("ruben@fisica.com");
        dev.setPassword("fluidos");

        userRepository.save(dev);

        Developer dev2 = new Developer();

        dev2.setAddress("ALver 2020");
        dev2.setDob(LocalDate.now());
        dev2.setName("Jose");
        dev2.setPhone_number(123123124);
        dev2.setEmail("jose@fiawdawd.com");
        dev2.setPassword("password");


        userRepository.save(dev2);

        Company company = new Company();

        company.setLocation("Silicon Valley");
        company.setName("Googlee");
        company.setEmail("google@gmail.com");
        company.setPassword("12346");

        userRepository.save(company);


        Job job = new Job();

        job.setCompany(company);
        job.setAvailable_slots(2);
        job.setJob_type(JobType.FULL_TIME);
        job.setJob_title("Engineer");
        job.setSalary(50000.0);

        jobRepository.save(job);

        Application ap = new Application();

        ap.setJob(job);
        ap.setDeveloper(dev);
        ap.setPriority(3);
        ap.setSeniority(Seniority.JUNIOR);
        ap.setSpeaks_english(Boolean.TRUE);
        ap.setYears_xp(2);
        applicationRepository.save(ap);

        Application ap2 = new Application();

        ap2.setJob(job);
        ap2.setDeveloper(dev2);
        ap2.setPriority(5);
        ap2.setSeniority(Seniority.SENIOR);
        ap2.setSpeaks_english(Boolean.TRUE);
        ap2.setYears_xp(2);

        applicationRepository.save(ap2);

        Interview in = new Interview();

        in.setApplication(ap);
        in.setDate(LocalDateTime.now());
        in.setDeveloper(dev);
        in.setDescription("mmmmm");

        interviewRepository.save(in);*/
        System.out.println(companyService.listApplications((long) 5));
        System.out.println(developerService.listInterviews((long) 12));
        System.out.println(developerService.listApplications((long)12));
        System.out.println(developerService.get((long)12));
        System.out.println(companyService.get((long)14));
        return "probe";
    }
}
