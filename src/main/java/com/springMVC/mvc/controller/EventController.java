package com.springMVC.mvc.controller;

import com.springMVC.mvc.dto.ClubDTO;
import com.springMVC.mvc.dto.EventDTO;
import com.springMVC.mvc.models.Event;
import com.springMVC.mvc.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "events-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, @ModelAttribute("event") EventDTO eventDTO,
                              Model model, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("event", eventDTO);
            return "clubs-create";
        }
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

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId, Model model) {
        EventDTO event = eventService.findByEventId(eventId);
        model.addAttribute("event", event);
        return "events-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String updatedEvent(@PathVariable("eventId") Long eventId,
                               @Valid @ModelAttribute("event") EventDTO event,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", event);
            return "events-edit";
        }
        EventDTO eventDTO = eventService.findByEventId(eventId);
        event.setId(eventId);
        event.setClub(eventDTO.getClub());
        eventService.updateEvent(event);
        return "redirect:/events";
    }
}
