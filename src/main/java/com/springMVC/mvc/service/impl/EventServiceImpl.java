package com.springMVC.mvc.service.impl;

import com.springMVC.mvc.dto.EventDTO;
import com.springMVC.mvc.repository.ClubRepository;
import com.springMVC.mvc.repository.EventRepository;
import com.springMVC.mvc.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDTO eventDTO) {

    }
}
