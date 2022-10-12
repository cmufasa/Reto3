package com.usa.ciclo3.reto4.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ADMIN")
public class Admin implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false, length = 250)
    private String name;
    @Column(name = "MAIL", nullable = false, length = 45)
    private String mail;
    @Column(name = "PASSWORD", nullable = false, length = 45)
    private String password;
    
}
