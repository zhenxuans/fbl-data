package me.robbie.fbl.data.model.footballdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MatchHead2HeadStats {
	private String wins;
	private String draws;
	private String losses;
}
