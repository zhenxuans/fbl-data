package me.robbie.fbl.data.handler.footballdata;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.common.DataHandlerContext;
import me.robbie.fbl.data.handler.AbstractFblDataHandler;
import me.robbie.fbl.data.model.footballdata.Competition;
import me.robbie.fbl.data.model.footballdata.StandingsData;

@Slf4j
public class StandingHandler extends FootballDataHandler {

	public StandingHandler() {
	}

	@Override
	public void handlerAdded(DataHandlerContext context) {
		
	}

	@Override
	public void handlerRemoved(DataHandlerContext context) {
		
	}

	@Override
	public void dataProcessed(DataHandlerContext context, Object[] data) throws Exception {
		if(data == null || data.length <=0)
			throw new IllegalArgumentException("Argument data is null or illgal.");
		if(!(data[0] instanceof Competition))
			throw new IllegalArgumentException("Argument data[] element is not type Competition.");
		
		List<StandingsData> standings = new ArrayList<>();
		for(Object item : data) {
			Competition cp = (Competition)item;
			String urlString = String.format("http://api.football-data.org/v2/competitions/%s/standings", cp.getId());
			
			Thread.sleep(10000);
			
			StandingsData sd = parse(urlString, StandingsData.class);
			if(sd != null) {
				standings.add(sd);
				log.info(sd.toString());
			}
			else {
				log.error("Standing Data is null: " + urlString);
				return;
			}
		}
		context.fireDataProcessed(standings.toArray());
	}

}
