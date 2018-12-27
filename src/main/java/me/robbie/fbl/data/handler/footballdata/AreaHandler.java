package me.robbie.fbl.data.handler.footballdata;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.common.DataHandlerContext;
import me.robbie.fbl.data.handler.AbstractFblDataHandler;
import me.robbie.fbl.data.model.footballdata.Area;

@Slf4j
public class AreaHandler extends FootballDataHandler {

	public AreaHandler() {
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
		if(!(data[0] instanceof Area))
			throw new IllegalArgumentException("Argument data[] element is not type Area.");
		
		for(Area area : (Area[])data) {
			log.info(area.toString());
		}
	}

}
