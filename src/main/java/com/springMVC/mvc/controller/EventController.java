package com.springMVC.mvc.controller;

import com.springMVC.mvc.dto.EventDTO;
import com.springMVC.mvc.models.Event;
import com.springMVC.mvc.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events/{clubId}/new")
    public String createEventFrom(@PathVariable("clubId") Long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "events-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, @ModelAttribute("event") EventDTO eventDTO, Model model) {
        eventService.createEvent(clubId, eventDTO);
        return "redirect:/clubs/" + clubId;
    }

    @GetMapping("/events")
    public String eventList(Model model) {
        List<EventDTO> eventDTOList = eventService.findAllEvents();
        model.addAttribute("events", eventDTOList);
        return "events-list";
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventID, Model model) {
        EventDTO eventDTO = eventService.findByEventId(eventID);
        model.addAttribute("event", eventDTO);
        return "events-detail";
    }
}
