package me.robbie.fbl.data.handler.sporttery;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.common.DataHandlerContext;
import me.robbie.fbl.data.dao.TeamMatchDao;
import me.robbie.fbl.data.model.sporttery.TeamMatchRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TeamMatchRecordCrawler extends SportteryDataHandler {

    @Autowired
    private TeamMatchDao matchDao;

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
            String teamMatchUrl = String.format("http://i.sporttery.cn/api/fb_match_info/get_team_rec_data?tid=%s&is_ha=all&limit=100000&ptype[]=three_-1",tid);
            log.info(teamMatchUrl);
            TeamMatchRecords matchRec = parse(teamMatchUrl, TeamMatchRecords.class);
            log.info(matchRec.toString());
            matchDao.saveMatches(matchRec);
            int randomNumber = (int) (Math.random() * 3000);
            Thread.sleep(randomNumber);
        }
    }
}
