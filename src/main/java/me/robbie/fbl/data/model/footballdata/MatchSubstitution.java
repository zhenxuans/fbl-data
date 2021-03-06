package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MatchSubstitution {
	private int minute;
	private MatchTeam team;
	private Player playerIn;
	private Player playerOut;
}
