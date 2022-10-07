package com.usa.ciclo3.reto3.entity;

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
@Table(name = "SCORE")
public class Score implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "VALUE_SCORE", nullable = false)
    private Integer valueScore;
    @Column(name = "MSGTEXT", nullable = false, length = 250)
    private String msgText;
    @Column(name = "ID_BOOKING", nullable = false)
    private String idBooking;
        
}
