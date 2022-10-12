package com.usa.ciclo3.reto4.service;

import com.usa.ciclo3.reto4.entity.Reservation;
import com.usa.ciclo3.reto4.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getList() {
        return reservationRepository.findAll();
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id).get();
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationId = reservationRepository.findById(reservation.getIdReservation());

            if (!reservationId.isEmpty()) {
                Reservation reservationBd = reservationId.get();

                reservationBd.setStartDate(reservation.getStartDate());
                reservationBd.setDevolutionDate(reservation.getDevolutionDate());
                reservationBd.setStatus(reservation.getStatus());
                reservationBd.setScore(reservation.getScore());
                reservationBd.setCabin(reservation.getCabin());
                reservationBd.setClient(reservation.getClient());

                return reservationRepository.save(reservationBd);

            } else {

                return reservation;
            }
        }
        return reservation;
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

}
