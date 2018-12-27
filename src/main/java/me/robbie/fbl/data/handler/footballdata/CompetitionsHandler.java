package me.robbie.fbl.data.handler.footballdata;

import java.util.ArrayList;
import java.util.List;

import me.robbie.fbl.common.DataHandlerContext;
import me.robbie.fbl.data.handler.AbstractFblDataHandler;
import me.robbie.fbl.data.model.footballdata.Competition;
import me.robbie.fbl.data.model.footballdata.Competitions;

public class CompetitionsHandler extends FootballDataHandler {

	private List<Integer> availableCompetitionIds = new ArrayList<Integer>();
	
	public CompetitionsHandler() {
		availableCompetitionIds.add(2001);//CHAMPIONS LEAGUE
		availableCompetitionIds.add(2017);//PRIMEIRA LIGA Portugal
		availableCompetitionIds.add(2021);//PREMIER LEAGUE England
		availableCompetitionIds.add(2003);//EREDIVISIE Netherland
		availableCompetitionIds.add(2002);//BUNDESLIGA Genman
		availableCompetitionIds.add(2015);//LIGUE France
		availableCompetitionIds.add(2019);//SERIE A Italy
		availableCompetitionIds.add(2014);//Primera Division aka. LA LIGA Spain
		availableCompetitionIds.add(2016);//CHAMPIONSHIP England
		availableCompetitionIds.add(2013);//Série A Brazil
//		availableCompetitionIds.add(2000);//World cup Russia
		availableCompetitionIds.add(2018);//European Championship
	}

	@Override
	public void handlerAdded(DataHandlerContext context) {
		
	}

	@Override
	public void handlerRemoved(DataHandlerContext context) {
		
	}

	@Override
	public void dataProcessed(DataHandlerContext context, Object[] data) throws Exception {
		if(data == null || data.length != 1)
			throw new IllegalArgumentException("Argument data is null or illgal.");
		
		String url = data[0].toString();
		Competitions competitions = parse(url, Competitions.class);
		
		List<Competition> availableCompetitions = new ArrayList<Competition>();
		
		for(Competition cp : competitions.getCompetitions()) {
			if(availableCompetitionIds.contains(cp.getId())) {
				availableCompetitions.add(cp);
			}
		}
		
		context.fireDataProcessed(availableCompetitions.toArray());
	}

}
