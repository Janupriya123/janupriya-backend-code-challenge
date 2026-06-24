package com.hexaware.cricteam.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PlayerNameAndRoleDTO {

    @NotBlank
    @Size(min=2,max=50)
    @Pattern(regexp="^[A-Za-z ]+$",message="Player name should contain only letters")
    private String playerName;
    @NotBlank(message="Role is required")
    @Pattern(regexp="^(Batsman|Bowler|Keeper|All Rounder)$",message="Role must be Batsman, Bowler, Keeper, or All Rounder")
    private String role;

    public PlayerNameAndRoleDTO(String playerName,String role) {
        this.playerName=playerName;
        this.role = role;
    }

    public  String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getRole()
    {
        return  role;
    }
    public void setRole(String role)
    {
        this.role=role;
    }
}
