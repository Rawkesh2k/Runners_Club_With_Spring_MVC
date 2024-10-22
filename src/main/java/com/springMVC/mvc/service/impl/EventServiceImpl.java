package com.springMVC.mvc.service.impl;

import com.springMVC.mvc.dto.EventDTO;
import com.springMVC.mvc.models.Club;
import com.springMVC.mvc.models.Event;
import com.springMVC.mvc.repository.ClubRepository;
import com.springMVC.mvc.repository.EventRepository;
import com.springMVC.mvc.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.springMVC.mvc.mapper.EventMapper.mapToEvent;
import static com.springMVC.mvc.mapper.EventMapper.mapToEventDto;


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

    @Override
    public List<EventDTO> findAllEvents() {
        List<Event> events = eventRepository.findAll();

        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }


}
