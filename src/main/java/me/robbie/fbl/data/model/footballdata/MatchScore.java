package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MatchScore {
	private String winner;
	private String duration;
	private MatchScoreNumber fullTime;
	private MatchScoreNumber halfTime;
	private MatchScoreNumber extraTime;
	private MatchScoreNumber penalties;
}
