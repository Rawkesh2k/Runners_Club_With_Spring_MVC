package com.springMVC.mvc.service;

import com.springMVC.mvc.dto.EventDTO;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDTO eventDTO);
    List<EventDTO> findAllEvents();

    EventDTO findByEventId(Long eventID);

    void updateEvent(EventDTO eventDTO);

    void deleteEvent(Long eventId);
}
