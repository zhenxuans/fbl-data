package me.robbie.fbl.data.model.footballdata;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Match {
	private int id;
	private Competition competition;
	private Season season;
	private String utcDate;
	private String status;
	private int attendance;
	private String venue;
	private String matchday;
	private String stage;
	private String group;
	private String lastUpdated;
	private MatchTeam homeTeam;
	private MatchTeam awayTeam;
	private MatchScore score;
	private List<MatchGoal> goals;
	private List<MatchBooking> bookings;
	private List<MatchSubstitution> substitutions;
	private List<Referee> referees;
}
