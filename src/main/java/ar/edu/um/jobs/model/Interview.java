package ar.edu.um.jobs.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interview_id;
    @OneToOne
    private Application application;
    private LocalDateTime date;
    @OneToOne
    private Developer developer;
    private String description;


}
