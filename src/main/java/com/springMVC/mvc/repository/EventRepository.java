package com.springMVC.mvc.repository;

import com.springMVC.mvc.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
