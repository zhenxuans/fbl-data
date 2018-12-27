package me.robbie.fbl.data.model.footballdata;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Competitions {
	private int count;
	private List<String> filters;
	private List<Competition> competitions;
}
