package ar.edu.um.jobs.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Company extends User {

    private Long id;
    private String name;
    private String location;

    private List<Job> jobs;

}
