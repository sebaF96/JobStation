package ar.edu.um.jobs.model;

import ar.edu.um.jobs.service.Identificable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Job implements Serializable, Identificable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_id;
    @ManyToOne
    private Company company;
    private String job_title;
    private Double salary;
    @Enumerated(EnumType.STRING)
    private JobType job_type;
    private Integer available_slots;
    private String description;
    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean active = true;


    @Override
    public Long getId() {
        return this.job_id;
    }
}
