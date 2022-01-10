package com.javatechassignment.javatechassignment.Services;

import java.util.List;
import java.util.UUID;

import com.javatechassignment.javatechassignment.Domain.Reserva;
import com.javatechassignment.javatechassignment.Repository.ReservaRepository;
import com.javatechassignment.javatechassignment.config.RabbitConfiguration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReservaService {
  
  @Autowired
  private ReservaRepository reservaRepository;

  @Autowired
  ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);

  
  @Autowired
  AmqpTemplate template = context.getBean(AmqpTemplate.class);

  public List<Reserva> findAll(){
    return reservaRepository.findAll();
  }

  public Reserva findById (UUID uuid){
    // return reservaRepository.findById(uuid).orElseThrow(() -> new RuntimeException(String.format("No se encontró una reserva con el id '%uuid'", uuid)));
    return reservaRepository.findById(uuid).orElseThrow(() -> new NullPointerException("No existe una reserva con este id"));
  }

  public boolean registrarReserva (Reserva reserva){
    try{
      reservaRepository.save(reserva);
      template.convertSendAndReceive("javatech.exchange.assignment",null,"Subido exitosamente");
      return true;
    } catch (Exception e) {
      // e.printStackTrace();
      return false;
    }
  }
}
