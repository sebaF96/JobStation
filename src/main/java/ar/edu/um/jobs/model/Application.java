package ar.edu.um.jobs.model;

import ar.edu.um.jobs.service.Identificable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Application implements Serializable, Identificable {

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

    @Override
    public Long getId() {
        return this.application_id;
    }

    @Override
    public String toString() {
        return "Application{" +
                "application_id=" + application_id +
                ", job=" + job +
                ", developer=" + developer +
                ", seniority=" + seniority +
                ", years_xp=" + years_xp +
                ", speaks_english=" + speaks_english +
                ", priority=" + priority +
                '}';
    }
}
