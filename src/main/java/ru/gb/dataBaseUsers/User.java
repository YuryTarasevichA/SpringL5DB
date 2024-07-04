package ru.gb.dataBaseUsers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PROFESSION")
    private String profession;

    public User(Long id, String name, String email, String profession) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profession = profession;
    }
}