package com.hexaware.cricteam.service;

import com.hexaware.cricteam.dto.PlayerDTO;
import com.hexaware.cricteam.dto.PlayerNameAndRoleDTO;

import java.util.List;

public interface IPlayer {
    public PlayerDTO  createPlayer(PlayerDTO dto);
    public PlayerDTO updatePlayer(Long id, PlayerDTO dto) ;
    public PlayerDTO getPlayerById(Long id) ;
    public List<PlayerDTO> getAllPlayers();
    public void deletePlayer(Long id) ;
    public List<PlayerNameAndRoleDTO> getPlayerNameAndRole(String teamName);
}
