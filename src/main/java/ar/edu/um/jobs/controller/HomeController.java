package ar.edu.um.jobs.controller;


import ar.edu.um.jobs.model.Developer;
import ar.edu.um.jobs.model.User;
import ar.edu.um.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        Optional<User> currentUser = userRepository.getCurrentUser();

        String msg = currentUser.map(usr -> "<h1> Welcome " + usr.getId() + "</h1>")
                .orElse("<h1> Welcome deslogueado </h1>");

        return msg;
    }

    @GetMapping("/user")
    public String user() {
        Optional<User> currentUser = userRepository.getCurrentUser();

        if (currentUser.get().getClass() == Developer.class) {
            return "Welcome developer!! " + currentUser.get().getRoles();
        } else {
            return "Welcome company!! " + currentUser.get().getRoles();

        }


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
        return ("<h1>Pagina que solo deberian ver las company</h1>");
    }
}

