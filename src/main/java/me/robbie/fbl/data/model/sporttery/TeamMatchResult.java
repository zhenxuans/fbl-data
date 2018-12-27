package me.robbie.fbl.data.model.sporttery;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
@NoArgsConstructor
public class TeamMatchResult {
    private TeamMatchStats total;
    private TeamMatchStats h_total;
    private TeamMatchStats a_total;
    private ArrayList<TeamMatchData> data;
}
