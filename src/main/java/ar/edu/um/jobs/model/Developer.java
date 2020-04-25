package ar.edu.um.jobs.model;

import ar.edu.um.jobs.service.Identificable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Developer extends User implements Serializable, Identificable {

    private String name;
    private LocalDate dob;
    private String address;
    private String biography;
    private Integer phone_number;

    @Override
    public Long getId() {
        return super.getUser_id();
    }
}
