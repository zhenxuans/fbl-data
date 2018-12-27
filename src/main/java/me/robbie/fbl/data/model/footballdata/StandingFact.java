package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class StandingFact {
	private int position;
	private Team team;
	private int playedGames;
	private int won;
	private int draw;
	private int lost;
	private int points;
	private int goalsFor;
	private int goalsAgainst;
	private int goalDifference;
}
