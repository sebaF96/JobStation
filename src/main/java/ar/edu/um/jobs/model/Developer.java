package ar.edu.um.jobs.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Developer extends User {

    private Long id;
    private String name;
    private LocalDate dob;
    private String address;
    private Integer phone_number;
    private List<Job> jobs_id;
}
