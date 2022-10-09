package com.usa.ciclo3.reto3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "RESERVATION")
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "START_DATE", nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "DEVOLUTION_DATE", nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date devolutionDate;
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties("reservations")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "cabinId")
    @JsonIgnoreProperties("reservations")
    private Cabin cabin;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "scoreId", referencedColumnName = "id")
    private Score score;
}
