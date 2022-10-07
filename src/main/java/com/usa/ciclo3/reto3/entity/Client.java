package com.usa.ciclo3.reto3.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false, length = 250)
    private String name;
    @Column(name = "MAIL", nullable = false, length = 45)
    private String email;
    @Column(name = "AGE", nullable = false)
    private Integer age;
    @Column(name = "PASSWORD", nullable = false, length = 45)
    private String password;
    @OneToMany
    private Set<Message> messages;
    @OneToMany
    private Set<Reservation> reservations;
    
}
