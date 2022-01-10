package com.javatechassignment.javatechassignment.Repository;

import java.util.UUID;
import com.javatechassignment.javatechassignment.Domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("Reserva")
public interface ReservaRepository extends JpaRepository<Reserva, UUID> {}
