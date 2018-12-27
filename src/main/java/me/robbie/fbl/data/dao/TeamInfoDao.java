package me.robbie.fbl.data.dao;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.data.model.sporttery.TeamInfoResult;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TeamInfoDao extends BaseDao{

    public void saveTeamInfo(TeamInfoResult ts) {

        if(ts == null || ts.getResult() == null)
        {
            log.info("TeamInfoResult or TeamInfo is null.");
            return;
        }

        try {
            int count = session.selectOne("me.robbie.fbl.data.dao.TeamInfoMapper.isTeamExisted", ts.getResult().getTeam_id());
            if(count < 1) {
                session.insert("me.robbie.fbl.data.dao.TeamInfoMapper.newTeam", ts.getResult());
                session.commit();
            }
            else
            {
                session.update("me.robbie.fbl.data.dao.TeamInfoMapper.updateTeam", ts.getResult());
                session.commit();
            }
        } catch (Exception ex) {
            session.rollback();
            log.error(ex.getMessage());
        }
    }
}
