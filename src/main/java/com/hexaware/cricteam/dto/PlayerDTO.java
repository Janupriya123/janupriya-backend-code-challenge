package com.hexaware.cricteam.dto;
import jakarta.validation.constraints.*;

public class PlayerDTO {
    private Long playerId;
    @NotBlank
    @Size(min=2,max=50)
    @Pattern(regexp="^[A-Za-z ]+$",message="Player name should contain only letters")
    private String playerName;
    @NotNull
    @Min(1)
    @Max(999)
    private Integer jerseyNumber;
    @NotBlank(message="Role is required")
    @Pattern(regexp="^(Batsman|Bowler|Keeper|All Rounder)$",message="Role must be Batsman, Bowler, Keeper, or All Rounder")
    private String role;
    @NotNull
    @Min(0)
    private Integer totalMatches;
    @NotBlank
    @Pattern(regexp="^[A-Za-z ]+$",message="Country name should contain only letters")
    private String teamName;
    @NotBlank(message="Country name is required")
    @Pattern(regexp="^[A-Za-z ]+$",message="Country name should contain only letters")
    private String countryName;
    @NotBlank
    @Size(max=500)
    private String description;

    public PlayerDTO()
    {

    }

    public PlayerDTO(Long playerId, String playerName, Integer jerseyNumber, String role, Integer totalMatches, String teamName, String countryName, String description) {
        super();
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.totalMatches = totalMatches;
        this.teamName = teamName;
        this.countryName = countryName;
        this.description = description;
    }
    public PlayerDTO(String playerName, String role) {
        this.playerName = playerName;
        this.role = role;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(Integer totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Player [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
                + ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName
                + ", countryName=" + countryName + ", description=" + description + "]";
    }

}

