package ar.edu.um.jobs.controller;


import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome HOME</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/company/2")
    public String com2() {
        return ("<h1>Welcome COMPANY 2</h1>");
    }


    @GetMapping("/developer")
    public String dev() {
        return ("<h1>Welcome Developer</h1>");
    }

    @GetMapping("/company")
    public String company() {
        return ("<h1>Welcome Company</h1>");
    }
}

