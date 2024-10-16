package com.restart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role
{
	//Id dell'oggetto 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Nome del ruolo
    @Column(nullable=false, unique=true)
    private String name;

    //Lista degli user associati allo stesso ruolo
    @ManyToMany(mappedBy="roles")
    private List<User> users;
}