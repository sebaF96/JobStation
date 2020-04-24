package ar.edu.um.jobs.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Job {

    private Long job_id;
    private Company company;
    private String job_title;
    private Double salary;
    private JobType job_type;
    private Integer available_slots;


}
