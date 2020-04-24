package ar.edu.um.jobs.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class User {

    private Long user_id;
    private String email;
    private String password;


}
