package com.hexaware.cricteam.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException()
    {
        super();
    }
    public PlayerNotFoundException(String msg)
    {
        super(msg);
    }
}