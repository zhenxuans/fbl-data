package me.robbie.fbl.data.dao;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.data.model.sporttery.WinDrawLose14;
import me.robbie.fbl.data.model.sporttery.WinDrawLoseMatchResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class WinDrawLose14Dao extends BaseDao {
    public void saveWinDrawLoseMatch(WinDrawLose14 wdl) {

        if(wdl == null || wdl.getResult() == null)
        {
            log.info("WinDrawLose14 or Hash map is null.");
            return;
        }

        try {
            HashMap<String, WinDrawLoseMatchResult> map = wdl.getResult();
            map.forEach((num, res) -> {
                int count = session.selectOne("me.robbie.fbl.data.dao.Windrawlose14Mapper.isMatchExisted", res.getMid());
                if(count < 1) {
                    session.insert("me.robbie.fbl.data.dao.Windrawlose14Mapper.newMatch14", res);
                    session.commit();
                }
                else
                {
                    session.update("me.robbie.fbl.data.dao.Windrawlose14Mapper.updateMatch14", res);
                    session.commit();
                }

            });
        } catch (Exception ex) {
            session.rollback();
            log.error(ex.getMessage());
        }
    }
}
