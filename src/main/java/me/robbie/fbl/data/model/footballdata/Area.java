package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Area {
	private int id;
	private String name;
	private String countryCode;
	private int parentAreaId;
	private String parentArea;
}
