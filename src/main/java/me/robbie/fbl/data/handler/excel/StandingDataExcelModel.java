package me.robbie.fbl.data.handler.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StandingDataExcelModel extends BaseRowModel {
	@ExcelProperty(index=0, value="排名")
	private int position;
	
	@ExcelProperty(index=1, value="球队")
	private String teamName;
	
	@ExcelProperty(index=2, value="场数")
	private int playedGames;
	
	@ExcelProperty(index=3, value="胜场")
	private int won;
	
	@ExcelProperty(index=4, value="平场")
	private int draw;
	
	@ExcelProperty(index=5, value="负场")
	private int lost;
	
	@ExcelProperty(index=6, value="积分")
	private int points;
	
	@ExcelProperty(index=7, value="进球")
	private int goalsFor;
	
	@ExcelProperty(index=8, value="失球")
	private int goalsAgainst;
	
	@ExcelProperty(index=9, value="净胜球")
	private int goalDifference;
}
