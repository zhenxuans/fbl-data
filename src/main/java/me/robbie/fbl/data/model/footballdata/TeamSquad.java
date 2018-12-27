package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TeamSquad {
	private int id;
	private String name;
	private String position;
	private String dateOfBirth;
	private String countryOfBirth;
	private String nationality;
	private String role;
}
