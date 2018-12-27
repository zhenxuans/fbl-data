package me.robbie.fbl.data.dao;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.data.model.sporttery.TeamInfoResult;
import me.robbie.fbl.data.model.sporttery.TeamMatchData;
import me.robbie.fbl.data.model.sporttery.TeamMatchRecords;
import me.robbie.fbl.data.model.sporttery.TeamMatchResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class TeamMatchDao extends BaseDao{

    public void saveMatches(TeamMatchRecords rec) {
        if(rec == null || rec.getResult() == null) {
            return;
        }

        TeamMatchResult res = rec.getResult();
        ArrayList<TeamMatchData> matches = res.getData();
        for(TeamMatchData data : matches) {
            int count = session.selectOne("me.robbie.fbl.data.dao.TeamMatchMapper.isMatchExisted",data.getMatch_id());
            if(count<1) {
                session.insert("me.robbie.fbl.data.dao.TeamMatchMapper.newMatch",data);
                session.commit();
            }
            else {
                session.update("me.robbie.fbl.data.dao.TeamMatchMapper.updateMatch",data);
                session.commit();
            }
        }
    }
}
