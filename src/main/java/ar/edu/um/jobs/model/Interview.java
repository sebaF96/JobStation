package ar.edu.um.jobs.model;


import ar.edu.um.jobs.service.Identificable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Interview implements Identificable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interview_id;
    @OneToOne
    private Application application;
    private LocalDateTime date;
    @OneToOne
    private Developer developer;
    private String description;


    @Override
    public Long getId() {
        return this.interview_id;
    }
}
