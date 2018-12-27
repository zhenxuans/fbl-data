package me.robbie.fbl.data.handler.footballdata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.common.DataHandler;
import me.robbie.fbl.common.DataHandlerContext;
import me.robbie.fbl.data.handler.excel.StandingDataExcelModel;
import me.robbie.fbl.data.model.footballdata.Standing;
import me.robbie.fbl.data.model.footballdata.StandingFact;
import me.robbie.fbl.data.model.footballdata.StandingsData;

@Slf4j
public class StandingExcelWriterHandler implements DataHandler {

	private String fileName;
	private boolean timeStampAdded;
	
	public StandingExcelWriterHandler(String fileName, boolean timeStampAdded) {
		
		if(fileName.lastIndexOf(".xlsx") == -1)
			throw new IllegalArgumentException("file name must be xlsx.");
		
		this.fileName = fileName;
		this.timeStampAdded = timeStampAdded;
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
		
		List<StandingsData> sheetsData = new ArrayList<>();
		for(Object o : data) {
			sheetsData.add((StandingsData)o);
		}
		writeExcel(sheetsData);
	}
	
	private void writeExcel(List<StandingsData> sheetsData) throws FileNotFoundException, IOException {
		
		if(!checkSheets(sheetsData))
			return;
		
		if(timeStampAdded)
		{
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
			String mainFileName = fileName.substring(0, fileName.lastIndexOf(".xlsx") - 1);
			fileName = mainFileName + "_" + timeStamp + ".xlsx";
			
		}
		
		try(OutputStream out = new FileOutputStream(fileName);) {
			ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
			int sheetNo = 1;
			for(StandingsData sheetData : sheetsData) {
				String competitionName = sheetData.getCompetition().getName();
				for(Standing standing : sheetData.getStandings()) {
					
					String sheetName = "";				
					String standingType = standing.getType().substring(0, 1);
					String standingGroup = standing.getGroup();
					if(standingGroup == null)
						standingGroup = "";
					else
						standingGroup = standingGroup.substring(standingGroup.length()-1, standingGroup.length());
					
					sheetName = String.format("%s-%s-%s", competitionName, standingType, standingGroup);
					
					Sheet sheet = new Sheet(sheetNo, 0, StandingDataExcelModel.class);
					sheet.setSheetName(sheetName);
					List<StandingDataExcelModel> rows = new ArrayList<>();
					for(StandingFact fact : standing.getTable()) {
						StandingDataExcelModel row = new StandingDataExcelModel();
						row.setPosition(fact.getPosition());
						row.setTeamName(fact.getTeam().getName());
						row.setPlayedGames(fact.getPlayedGames());
						row.setWon(fact.getWon());
						row.setDraw(fact.getDraw());
						row.setLost(fact.getLost());
						row.setPoints(fact.getPoints());
						row.setGoalsFor(fact.getGoalsFor());
						row.setGoalsAgainst(fact.getGoalsAgainst());
						row.setGoalDifference(fact.getGoalDifference());
						rows.add(row);
					}
					writer.write(rows, sheet);
					sheetNo ++;
				}
			}
			
			writer.finish();
		}
		
	}

	private boolean checkSheets(List<StandingsData> sheets) {
		for(StandingsData sheet : sheets) {
			String sheetName = sheet.getCompetition().getName();
			if(sheetName.isEmpty()) {
				log.error("cannot create a excel sheet by using a null/empty sheetName");
				return false; 
			}
		}
		
		return true;
	}
}