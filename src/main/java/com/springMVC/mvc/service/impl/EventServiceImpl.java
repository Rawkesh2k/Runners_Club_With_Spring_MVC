package com.springMVC.mvc.service.impl;

import com.springMVC.mvc.dto.EventDTO;
import com.springMVC.mvc.models.Club;
import com.springMVC.mvc.models.Event;
import com.springMVC.mvc.repository.ClubRepository;
import com.springMVC.mvc.repository.EventRepository;
import com.springMVC.mvc.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
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
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDTO);
        event.setClub(club);
        eventRepository.save(event);
    }

    public Event mapToEvent(EventDTO eventDTO) {
        return Event.builder()
                .id(eventDTO.getId())
                .name(eventDTO.getName())
                .photoUrl(eventDTO.getPhotoUrl())
                .type(eventDTO.getType())
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .createdOn(eventDTO.getCreatedOn())
                .updatedOn(eventDTO.getUpdatedOn())
                .build();
    }
}
