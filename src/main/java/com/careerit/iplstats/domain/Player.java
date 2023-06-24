package com.careerit.iplstats.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player")
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name="role")
    private String role;
    @Column(name="team")
    private String team;
    @Column(name="country")
    private String country;
    @Column(name="amount")
    private double amount;
}
