package ar.edu.um.jobs.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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
    private Application application_id;
    private LocalDate date;
    @OneToOne
    private Developer developer_id;
    private String description;


}
