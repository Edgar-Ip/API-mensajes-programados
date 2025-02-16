package com.generadormensajes.generadorMensajes.controller;

import com.generadormensajes.generadorMensajes.model.ScheduledMessage;
import com.generadormensajes.generadorMensajes.repository.ScheduledMessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {
    private final ScheduledMessageRepository messageRepository;

    public WebController(ScheduledMessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model){
        List<ScheduledMessage> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "dashboard";
    }
}
