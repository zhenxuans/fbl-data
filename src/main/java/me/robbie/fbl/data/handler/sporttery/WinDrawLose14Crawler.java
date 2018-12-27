package me.robbie.fbl.data.handler.sporttery;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.common.DataHandlerContext;
import me.robbie.fbl.data.dao.WinDrawLose14Dao;
import me.robbie.fbl.data.model.sporttery.WinDrawLose14;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WinDrawLose14Crawler extends SportteryDataHandler {

    @Autowired
    private WinDrawLose14Dao wdlDao;

    @Override
    public void handlerAdded(DataHandlerContext dataHandlerContext) {

    }

    @Override
    public void handlerRemoved(DataHandlerContext dataHandlerContext) {

    }

    @Override
    public void dataProcessed(DataHandlerContext dataHandlerContext, Object[] objects) {
        if(objects == null || objects.length <= 0)
            return;

        for(Object o : objects) {
            String url = (String)o;
            WinDrawLose14 matches = parse(url, WinDrawLose14.class);
            String num = url.substring(url.lastIndexOf("=") + 1);
            if(matches != null && matches.getResult() != null) {
                matches.getResult().forEach((id, res) -> {
                    res.setMid(id);
                    res.setNum(num);
                });
                log.info(matches.toString());
                wdlDao.saveWinDrawLoseMatch(matches);
            }
        }
    }
}
