package ar.edu.um.jobs.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long application_id;
    @OneToOne
    private Job job;
    @OneToOne
    private Developer developer;
    @Enumerated(EnumType.STRING)
    private Seniority seniority;
    private Integer years_xp;
    private Boolean speaks_english;
    private Integer priority;

}
