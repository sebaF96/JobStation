package ar.edu.um.jobs.model;

import ar.edu.um.jobs.service.Identificable;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Developer extends User implements Serializable, Identificable {

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private String address;
    private String biography;
    private String phone_number;

    @Override
    public Long getId() {
        return super.getUser_id();
    }
}
