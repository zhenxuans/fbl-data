package me.robbie.fbl.data.model.footballdata;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Standing {
	private String stage;
	private String type;
	private String group;
	private List<StandingFact> table;
}
