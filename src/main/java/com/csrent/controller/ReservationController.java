package com.csrent.controller;

import com.csrent.dto.ReservationDTO;
import com.csrent.model.Reservation;
import com.csrent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<?> items = reservationService.getAll();
        if(items == null || items.isEmpty()){
            return ResponseEntity.ok("No hay reservaciones registrados");
        } else {
            return ResponseEntity.ok(reservationService.getAll());
        }
    }

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation created = reservationService.add(reservationDTO);
        if (created == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear la reservacion");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
