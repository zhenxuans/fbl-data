package me.robbie.fbl.data;

import me.robbie.fbl.data.dao.TeamInfoDao;
import me.robbie.fbl.data.handler.sporttery.TeamIdFinder;
import me.robbie.fbl.data.handler.sporttery.TeamInfoCrawler;
import me.robbie.fbl.data.handler.sporttery.TeamMatchRecordCrawler;
import me.robbie.fbl.data.handler.sporttery.WinDrawLose14Crawler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


import me.robbie.fbl.common.DataPipeline;
import me.robbie.fbl.common.DefaultDataPipeline;
import me.robbie.fbl.data.handler.footballdata.CompetitionsHandler;
import me.robbie.fbl.data.handler.footballdata.StandingExcelWriterHandler;
import me.robbie.fbl.data.handler.footballdata.StandingHandler;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication()
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		DataPipeline pl = new DefaultDataPipeline();
//		pl.addLast("competitions", new CompetitionsHandler());
//		pl.addLast("standing", new StandingHandler());
//		pl.addLast("excel", new StandingExcelWriterHandler("C:\\logs\\standings.xlsx", true));
//		pl.execute(new Object[] { "http://api.football-data.org/v2/competitions" });
//
		List<Object> data = new ArrayList<>();
		pl.addLast("14m", SpringBeanFactory.getApplicationContext().getBean(WinDrawLose14Crawler.class));
		int i = 18175;
		while(i>=18001) {
			data.add(String.format("http://i.sporttery.cn/wap/fb_lottery/fb_lottery_match?num=%s", i));
			i--;
		}
		pl.execute(data.toArray());

//		pl.execute(new Object[] { "http://i.sporttery.cn/api/fb_match_info/get_team_rec_data?tid=676&is_ha=all&limit=100000&ptype[]=three_-1" });
//		pl.addLast("teamId", new TeamIdFinder());
//		pl.addLast("teamInfo", SpringBeanFactory.getApplicationContext().getBean(TeamInfoCrawler.class));
//		pl.addLast("teamMatches", SpringBeanFactory.getApplicationContext().getBean(TeamMatchRecordCrawler.class));
//		pl.execute(null);
	}
}
