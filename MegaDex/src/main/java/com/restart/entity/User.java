package com.restart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User
{
	//Id della classe user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Nome dell'utente 
    @Column(nullable=false)
    private String name;

    //Email dell'utente
    @Column(nullable=false, unique=true)
    private String email;

    //Password dell'utente
    @JsonIgnore
    @Column(nullable=false)
    private String password;
    
    //Lista di deck legati all'utente
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Deck> decks;

    //Lista delle carte della collezione privata dell'utente
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sleeve> Sleeves;

    //Lista di ruoli associati all'utente
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();

    @Column(nullable=false)
    private Date dob;
    private String phone;

}