package me.robbie.fbl.data.handler.footballdata;

import me.robbie.fbl.data.handler.AbstractFblDataHandler;

public abstract class FootballDataHandler extends AbstractFblDataHandler {

    private String authTokenName = "X-Auth-Token";
    private String authTokenValue = "241f8932759a44128be999726591a875";

    public FootballDataHandler() {
        headers.put(authTokenName, authTokenValue);
    }
 }
