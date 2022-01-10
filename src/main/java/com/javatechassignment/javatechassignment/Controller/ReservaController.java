package com.javatechassignment.javatechassignment.Controller;

import com.javatechassignment.javatechassignment.Domain.Reserva;
import com.javatechassignment.javatechassignment.Services.ReservaService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReservaController {
  
  @Autowired
  private ReservaService reservaService;

  @GetMapping("/consultar-reserva")
  public ResponseEntity<List<Reserva>> consultarAllReservas() {
    return new ResponseEntity<>(reservaService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/consultar-reserva/{id}")
  public ResponseEntity<Reserva> consultarReservaId(@PathVariable("id") String id) {
    return new ResponseEntity<>(reservaService.findById(UUID.fromString(id)), HttpStatus.OK);
  }

  @PostMapping("/registrar-reserva")
  public ResponseEntity<Object> registraReserva(@RequestBody Reserva reserva) {
    if (reservaService.registrarReserva(reserva)){
      return ResponseEntity.ok("Reserva registrada con éxito");
    } else {
      return ResponseEntity.status(500).body("Error*");
    }
  }
}
