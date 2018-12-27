package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MatchHead2Head {
	private int numberOfMatches;
	private int totalGoals;
	private MatchHead2HeadStats homeTeam;
	private MatchHead2HeadStats awayTeam;
}
