package com.springMVC.mvc.service;

import com.springMVC.mvc.dto.EventDTO;

public interface EventService {
    void createEvent(Long clubId, EventDTO eventDTO);
}
