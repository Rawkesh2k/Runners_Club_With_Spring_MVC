package com.springMVC.mvc.service;

import com.springMVC.mvc.dto.ClubDTO;
import com.springMVC.mvc.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();

    Club saveClub(ClubDTO clubDTO);

    ClubDTO findClubById(long clubId);

    void updateClub(ClubDTO club);

    void deleteClub(Long clubId);

    List<ClubDTO> searchClubs(String query);
}
