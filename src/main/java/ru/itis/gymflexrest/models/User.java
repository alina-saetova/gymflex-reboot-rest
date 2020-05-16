package ru.itis.gymflexrest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sport_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String photo;
    private String password;
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private  String confirmCode;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Commentary> commentaries = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL)
    private List<UserTraining> userTrainings = new ArrayList<>();
}
