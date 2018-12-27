package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MatchScoreNumber {
	private String homeTeam;
	private String awayTeam;
}
