package com.javatechassignment.javatechassignment.Domain;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name="Reserva")
@Entity
@Getter
@Setter
public class Reserva implements Serializable{
  
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name="fecha_ingreso")
  private LocalDate fechaIngreso;
  
  @Column(name="fecha_salida")
  private LocalDate fechaSalida;
  
  @Column(name="total_dias")
  private int totalDias;
  
  @Column(name="numero_personas")
  private int numeroPersonas;
  
  @Column(name="titular_reserva")
  private String titularReserva;
  
  @Column(name="numero_habitaciones")
  private int numeroHabitaciones;
  
  @Column(name="numero_menores")
  private int numeroMenores;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(LocalDate fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  public LocalDate getFechaSalida() {
    return fechaSalida;
  }

  public void setFechaSalida(LocalDate fechaSalida) {
    this.fechaSalida = fechaSalida;
  }

  public int getTotalDias() {
    return totalDias;
  }

  public void setTotalDias(int totalDias) {
    this.totalDias = totalDias;
  }

  public int getNumeroPersonas() {
    return numeroPersonas;
  }

  public void setNumeroPersonas(int numeroPersonas) {
    this.numeroPersonas = numeroPersonas;
  }

  public String getTitularReserva() {
    return titularReserva;
  }

  public void setTitularReserva(String titularReserva) {
    this.titularReserva = titularReserva;
  }

  public int getNumeroHabitaciones() {
    return numeroHabitaciones;
  }

  public void setNumeroHabitaciones(int numeroHabitaciones) {
    this.numeroHabitaciones = numeroHabitaciones;
  }

  public int getNumeroMenores() {
    return numeroMenores;
  }

  public void setNumeroMenores(int numeroMenores) {
    this.numeroMenores = numeroMenores;
  }

  @Override
  public String toString() {
    return "Reserva [fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", id=" + id
        + ", numeroHabitaciones=" + numeroHabitaciones + ", numeroMenores=" + numeroMenores + ", numeroPersonas="
        + numeroPersonas + ", titularReserva=" + titularReserva + ", totalDias=" + totalDias + "]";
  }
}
