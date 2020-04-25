package ar.edu.um.jobs.model;

import ar.edu.um.jobs.service.Identificable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Company extends User implements Serializable, Identificable {

    private String name;
    private String location;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @Override
    public  Long getId() {
        return super.getUser_id();
    }
}
