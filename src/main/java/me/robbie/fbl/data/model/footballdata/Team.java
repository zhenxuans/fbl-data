package me.robbie.fbl.data.model.footballdata;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Team {
	private int id;
	private Area area;
	private List<Competition> activeCompetitions;
	private String name;
	private String shortName;
	private String tla;
	private String crestUrl;
	private String address;
	private String phone;
	private String website;
	private String email;
	private int founded;
	private String clubColors;
	private String venue;
	private List<TeamSquad> squad;
	private String lastUpdated;
}
