package me.robbie.fbl.data.model.footballdata;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MatchTeam {
	private int id;
	private String name;
	private Coach coach;
	private Player captain;
	private List<Player> lineup;
	private List<Player> bench;
}
