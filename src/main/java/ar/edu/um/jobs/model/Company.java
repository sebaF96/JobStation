package ar.edu.um.jobs.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Company extends User implements Serializable {

    private String name;
    private String location;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

}
