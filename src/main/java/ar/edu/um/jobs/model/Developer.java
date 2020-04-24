package ar.edu.um.jobs.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Developer extends User implements Serializable {

    private String name;
    private LocalDate dob;
    private String address;
    private Integer phone_number;
    @OneToMany(mappedBy = "job_id")
    private List<Job> jobs_id;
}
