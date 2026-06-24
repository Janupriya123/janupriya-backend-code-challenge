package com.hexaware.cricteam.controller;


import com.hexaware.cricteam.dto.PlayerDTO;
import com.hexaware.cricteam.dto.PlayerNameAndRoleDTO;
import com.hexaware.cricteam.service.IPlayer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CricController {

    @Autowired
    private IPlayer service;

    @GetMapping("/players")
    public List<PlayerDTO> getAllPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/players/{playerId}")
    public PlayerDTO getPlayerById(@PathVariable Long playerId) {
        return service.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public PlayerDTO addPlayer(@Valid @RequestBody PlayerDTO dto) {
        return service.createPlayer(dto);
    }

    @PutMapping("/players/{playerId}")
    public PlayerDTO updatePlayer(@PathVariable Long playerId,@Valid @RequestBody PlayerDTO dto) {
        return service.updatePlayer(playerId, dto);
    }

    @DeleteMapping("/players/{playerId}")
    public String deletePlayer(@PathVariable Long playerId) {
        service.deletePlayer(playerId);
        return "Player deleted successfully";
    }
    @GetMapping("/players/getNameAndRole/{teamName}")
    public List<PlayerNameAndRoleDTO> getPlayerNameAndRole(@PathVariable String teamName)
    {
        return service.getPlayerNameAndRole(teamName);
    }
}

