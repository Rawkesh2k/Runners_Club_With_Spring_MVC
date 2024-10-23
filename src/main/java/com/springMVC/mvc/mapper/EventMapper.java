package com.springMVC.mvc.mapper;

import com.springMVC.mvc.dto.EventDTO;
import com.springMVC.mvc.models.Event;

public class EventMapper {

    public static Event mapToEvent(EventDTO eventDTO) {
        return Event.builder()
                .id(eventDTO.getId())
                .name(eventDTO.getName())
                .photoUrl(eventDTO.getPhotoUrl())
                .type(eventDTO.getType())
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .createdOn(eventDTO.getCreatedOn())
                .updatedOn(eventDTO.getUpdatedOn())
                .club(eventDTO.getClub())
                .build();
    }

    public static EventDTO mapToEventDto(Event event) {
        return EventDTO.builder()
                .id(event.getId())
                .name(event.getName())
                .photoUrl(event.getPhotoUrl())
                .type(event.getType())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .club(event.getClub())
                .build();
    }
}
