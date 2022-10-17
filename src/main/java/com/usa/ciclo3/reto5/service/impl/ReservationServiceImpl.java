package com.usa.ciclo3.reto5.service.impl;

import com.nimbusds.jose.shaded.json.parser.ParseException;
import com.usa.ciclo3.reto5.custom.CountClient;
import com.usa.ciclo3.reto5.custom.DescriptionAmount;
import com.usa.ciclo3.reto5.entity.Reservation;
import com.usa.ciclo3.reto5.service.ReservationService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl {

    @Autowired
    private ReservationService reservationService;

    public List<CountClient> getTopClients() {
        return reservationService.getTopClients();
    }

    public DescriptionAmount getStatusReports() {
        List<Reservation> completed = reservationService.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationService.getReservationsByStatus("cancelled");
        
        DescriptionAmount descriptionAmount = new DescriptionAmount(completed.size(),cancelled.size());
        return descriptionAmount;
    }

    public List<Reservation> getReservationPeriod(String dI, String dO) throws java.text.ParseException {
        
        SimpleDateFormat parserDate = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateIn = new Date();
        Date dateOut = new Date();
        
        dateIn = parserDate.parse(dI);
        dateOut = parserDate.parse(dO);
        
        if (dateIn.before(dateOut)) {
            return reservationService.getReservationsPeriod(dateIn, dateOut);
        }else{
            return new ArrayList<>();
        }
    }
}
