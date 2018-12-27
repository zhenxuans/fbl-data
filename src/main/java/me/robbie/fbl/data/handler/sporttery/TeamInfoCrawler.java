package me.robbie.fbl.data.handler.sporttery;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.common.DataHandlerContext;
import me.robbie.fbl.data.dao.TeamInfoDao;
import me.robbie.fbl.data.model.sporttery.TeamInfoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TeamInfoCrawler extends SportteryDataHandler {

    @Autowired
    private TeamInfoDao teamInfoDao;

    @Override
    public void handlerAdded(DataHandlerContext dataHandlerContext) {

    }

    @Override
    public void handlerRemoved(DataHandlerContext dataHandlerContext) {

    }

    @Override
    public void dataProcessed(DataHandlerContext dataHandlerContext, Object[] objects) throws InterruptedException {
        if(objects == null || objects.length <= 0)
            return;
        for(Object o : objects) {
            String tid = (String)o;
            String teamInfoUrl = String.format("http://i.sporttery.cn/api/fb_match_info/get_team_data?tid=%s", tid);
            log.info(teamInfoUrl);
            TeamInfoResult ts = parse(teamInfoUrl, TeamInfoResult.class);
            log.info(ts.toString());
            teamInfoDao.saveTeamInfo(ts);
            int randomNumber = (int) (Math.random() * 3000);
            Thread.sleep(randomNumber);
        }
    }
}
