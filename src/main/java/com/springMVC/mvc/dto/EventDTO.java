package com.springMVC.mvc.dto;


import com.springMVC.mvc.models.Club;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long id;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String type;

    private String photoUrl;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

}
