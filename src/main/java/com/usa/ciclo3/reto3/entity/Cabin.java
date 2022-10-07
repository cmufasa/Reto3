package com.usa.ciclo3.reto3.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CABIN")
public class Cabin implements Serializable  {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "BRAND", nullable = false, length = 45)
    private String brand;
    @Column(name = "NAME", nullable = false, length = 45)
    private String name;
    @Column(name = "ROOMS", nullable = false)
    private Integer rooms;
    @ManyToOne
    private Category category;
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    @OneToMany
    private Set<Message> messages;
    @OneToMany
    private Set<Reservation> reservations;
    
}
