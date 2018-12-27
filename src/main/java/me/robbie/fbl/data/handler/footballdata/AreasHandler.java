package me.robbie.fbl.data.handler.footballdata;

import me.robbie.fbl.common.DataHandlerContext;
import me.robbie.fbl.data.handler.AbstractFblDataHandler;
import me.robbie.fbl.data.model.footballdata.Areas;

public class AreasHandler extends FootballDataHandler {
	
	public AreasHandler() {
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
		String urlString = data[0].toString();
		Areas areas = parse(urlString, Areas.class);
		context.fireDataProcessed(areas.getAreas().toArray());
	}

}
