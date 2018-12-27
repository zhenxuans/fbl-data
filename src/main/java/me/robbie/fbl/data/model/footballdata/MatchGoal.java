package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MatchGoal {
	private int minute;
	private String extraTime;
	private String type;
	private MatchTeam team;
	private Player scorer;
	private Player assist;
}
