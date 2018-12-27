package me.robbie.fbl.data.model.footballdata;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class StandingsData {
	private String filters;
	private Competition competition;
	private Season season;
	private List<Standing> standings;
}
