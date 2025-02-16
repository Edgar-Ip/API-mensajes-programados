package com.generadormensajes.generadorMensajes.scheduler;

import com.generadormensajes.generadorMensajes.model.ScheduledMessage;
import com.generadormensajes.generadorMensajes.repository.ScheduledMessageRepository;
import com.generadormensajes.generadorMensajes.service.DiscordBotService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageScheduler {
    private final ScheduledMessageRepository messageRepository;

    private final DiscordBotService discordBotService;

    public MessageScheduler(ScheduledMessageRepository messageRepository, DiscordBotService discordBotService) {
        this.messageRepository = messageRepository;
        this.discordBotService = discordBotService;
    }

    @Scheduled(fixedRate = 60000) //60,000 ms = 1 minuto
    public void processScheduledMessages() {
        LocalDateTime now = LocalDateTime.now();
        List<ScheduledMessage> messagesToSend = messageRepository.findByScheduledTimeBefore(now);

        for (ScheduledMessage message : messagesToSend) {
            discordBotService.sendMessageToDiscord("\uD83D\uDCE2" + message.getText());
            messageRepository.delete(message); // Eliminar después de enviarlo

        }
    }

}





