package me.robbie.fbl.data.model.footballdata;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Competition {
	private int id;
	private Area area;
	private String name;
	private String code;
	private String plan;
	private Season currentSeason;
	private List<Season> seasons;
	private String lastUpdated;
}
