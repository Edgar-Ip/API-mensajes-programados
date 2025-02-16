package com.generadormensajes.generadorMensajes.controller;

import com.generadormensajes.generadorMensajes.model.ScheduledMessage;
import com.generadormensajes.generadorMensajes.repository.ScheduledMessageRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
@Tag(name = "Mensajes", description = "API para gestionar mensajes programados en Discord")
public class MessageController {

    private final ScheduledMessageRepository messageRepository;

    public MessageController(ScheduledMessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    //Endpoint para almacenar los mensajes programados
    @PostMapping
    @Operation(summary = "Crear un nuevo mensaje", description = "Almacena un nuevo mensaje programado en la base de datos.")
    public ResponseEntity<ScheduledMessage>createMessage(@RequestBody ScheduledMessage message){
       if(message.getText() == null || message.getScheduledTime() == null){
           return ResponseEntity.badRequest().build();
       }
        ScheduledMessage savedMessage = messageRepository.save(message);
        return ResponseEntity.ok(savedMessage);
    }

    //Endpoint para obtener lista de los mensajes programados

    @GetMapping
    @Operation(summary = "Obtener todos los mensajes", description = "Recupera la lista de todos los mensajes programados.")
    public ResponseEntity<List<ScheduledMessage>>getAllMessages(){
        List<ScheduledMessage> messages = messageRepository.findAll();
        return ResponseEntity.ok(messages);

    }


    //Endpoint para borrar un mensaje programado por ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un mensaje", description = "Elimina un mensaje programado por su ID.")
    public ResponseEntity<Void>deleteMessage(@Parameter(description = "ID del mensaje a eliminar",
            required = true) @PathVariable Long id){
        Optional<ScheduledMessage> message = messageRepository.findById(id);
        if(message.isPresent()){
            messageRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}
