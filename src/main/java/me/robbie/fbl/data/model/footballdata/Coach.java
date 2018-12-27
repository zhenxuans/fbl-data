package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Coach {
	private int id;
	private String name;
	private String countryOfBirth;
	private String nationality;
}
