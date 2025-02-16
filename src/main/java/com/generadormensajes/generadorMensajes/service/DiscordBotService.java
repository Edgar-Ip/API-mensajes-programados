package com.generadormensajes.generadorMensajes.service;

import jakarta.annotation.PostConstruct;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class DiscordBotService {

    @Value("${discord.bot.token}")
    private String botToken;

    @Value("${discord.channel.id}")
    private String channelId;

    private net.dv8tion.jda.api.JDA jda;

    @PostConstruct
    public void init() {
        try {
            jda = JDABuilder.createDefault(botToken).build().awaitReady();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToDiscord(String message) {
        TextChannel channel = jda.getTextChannelById(channelId);
        if (channel != null) {
            channel.sendMessage(message).queue();
        } else {
            System.out.println("No se encontró el canal de Discord");
        }
    }
}
