package me.robbie.fbl.data.model.sporttery;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TeamInfo {
    private String team_id;
    private String official_name;
    private String club_name;
    private String team_city;
    private String type;
    private String team_founded;
    private String sporttery_teamid;
    private String club_abbr_name;
    private String team_pic;
    private String competition_name;
    private String competition_abbr_name;
    private String rank;
    private String win;
    private String draw;
    private String lose;
    private String coach;
}
