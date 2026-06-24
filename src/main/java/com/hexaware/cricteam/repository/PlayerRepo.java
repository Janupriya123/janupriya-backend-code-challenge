package com.hexaware.cricteam.repository;

import com.hexaware.cricteam.dto.PlayerDTO;
import com.hexaware.cricteam.dto.PlayerNameAndRoleDTO;
import com.hexaware.cricteam.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {
    List<Player> findByTeamName(String teamName);
}
