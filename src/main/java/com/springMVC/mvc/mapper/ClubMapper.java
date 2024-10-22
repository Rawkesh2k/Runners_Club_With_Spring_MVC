package com.springMVC.mvc.mapper;

import com.springMVC.mvc.dto.ClubDTO;
import com.springMVC.mvc.models.Club;

import java.util.stream.Collectors;

import static com.springMVC.mvc.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club mapToClub(ClubDTO club) {
        Club clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;
    }


    public static ClubDTO mapToClubDto(Club club) {
        ClubDTO clubDTO = ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents()
                        .stream()
                        .map((event) -> mapToEventDto(event))
                        .collect(Collectors.toList()))
                .build();
        return clubDTO;
    }
}
