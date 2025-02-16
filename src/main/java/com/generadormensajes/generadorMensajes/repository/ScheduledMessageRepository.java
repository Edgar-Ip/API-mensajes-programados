package com.generadormensajes.generadorMensajes.repository;

import com.generadormensajes.generadorMensajes.model.ScheduledMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduledMessageRepository extends JpaRepository<ScheduledMessage, Long> {
    List<ScheduledMessage> findByScheduledTimeBefore(LocalDateTime now);
}
