package me.robbie.fbl.data.model.footballdata;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Season {
	private int id;
	private String startDate;
	private String endDate;
	private int currentMatchDay;
	private List<String> availbleStages;
}
