package com.hexaware.cricteam.service;


import com.hexaware.cricteam.dto.PlayerDTO;
import com.hexaware.cricteam.dto.PlayerNameAndRoleDTO;
import com.hexaware.cricteam.entity.Player;
import com.hexaware.cricteam.exception.PlayerNotFoundException;
import com.hexaware.cricteam.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerImpl implements IPlayer {

    @Autowired
    private PlayerRepo repo;

    @Override
    public PlayerDTO createPlayer(PlayerDTO dto) {
        Player p=new Player();
        p.setPlayerName(dto.getPlayerName());
        p.setJerseyNumber(dto.getJerseyNumber());
        p.setRole(dto.getRole());
        p.setTotalMatches(dto.getTotalMatches());
        p.setTeamName(dto.getTeamName());
        p.setCountryName(dto.getCountryName());
        p.setDescription(dto.getDescription());

        Player d=repo.save(p);
        PlayerDTO r=new PlayerDTO();
        r.setPlayerId(d.getPlayerId());
        r.setPlayerName(d.getPlayerName());
        r.setJerseyNumber(d.getJerseyNumber());
        r.setRole(d.getRole());
        r.setTotalMatches(d.getTotalMatches());
        r.setTeamName(d.getTeamName());
        r.setCountryName(d.getCountryName());
        r.setDescription(d.getDescription());

        return r;
    }

    @Override
    public PlayerDTO updatePlayer(Long id,PlayerDTO dto)  {
        Player p=repo.findById(id).orElseThrow(()-> new PlayerNotFoundException("ID not exist"));
        p.setPlayerName(dto.getPlayerName());
        p.setJerseyNumber(dto.getJerseyNumber());
        p.setRole(dto.getRole());
        p.setTotalMatches(dto.getTotalMatches());
        p.setTeamName(dto.getTeamName());
        p.setCountryName(dto.getCountryName());
        p.setDescription(dto.getDescription());

        Player d=repo.save(p);
        PlayerDTO r=new PlayerDTO();
        r.setPlayerId(d.getPlayerId());
        r.setPlayerName(d.getPlayerName());
        r.setJerseyNumber(d.getJerseyNumber());
        r.setRole(d.getRole());
        r.setTotalMatches(d.getTotalMatches());
        r.setTeamName(d.getTeamName());
        r.setCountryName(d.getCountryName());
        r.setDescription(d.getDescription());

        return r;


    }

    @Override
    public PlayerDTO getPlayerById(Long id)  {
        Player d=repo.findById(id).orElseThrow(()-> new PlayerNotFoundException("ID not exist"));
        PlayerDTO r=new PlayerDTO();
        r.setPlayerId(d.getPlayerId());
        r.setPlayerName(d.getPlayerName());
        r.setJerseyNumber(d.getJerseyNumber());
        r.setRole(d.getRole());
        r.setTotalMatches(d.getTotalMatches());
        r.setTeamName(d.getTeamName());
        r.setCountryName(d.getCountryName());
        r.setDescription(d.getDescription());

        return r;

    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> p=repo.findAll();
        List<PlayerDTO> list=new ArrayList<>();
        for(Player d:p)
        {
            PlayerDTO r=new PlayerDTO();
            r.setPlayerId(d.getPlayerId());
            r.setPlayerName(d.getPlayerName());
            r.setJerseyNumber(d.getJerseyNumber());
            r.setRole(d.getRole());
            r.setTotalMatches(d.getTotalMatches());
            r.setTeamName(d.getTeamName());
            r.setCountryName(d.getCountryName());
            r.setDescription(d.getDescription());
            list.add(r);

        }
        return list;
    }

    @Override
    public void deletePlayer(Long id)  {
        Player p=repo.findById(id).orElseThrow(()-> new PlayerNotFoundException("ID not exist"));
        repo.deleteById(id);


    }

    @Override
    public List<PlayerNameAndRoleDTO> getPlayerNameAndRole(String teamName) {
        List<Player> r=repo.findByTeamName(teamName);
        List<PlayerNameAndRoleDTO> res=new ArrayList<>();
        for(Player p :r)
        {
            res.add(new PlayerNameAndRoleDTO(p.getPlayerName(), p.getRole()));
        }
        return res;
    }

}

