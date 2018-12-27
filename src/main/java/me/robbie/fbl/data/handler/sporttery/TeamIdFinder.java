package me.robbie.fbl.data.handler.sporttery;

import lombok.extern.slf4j.Slf4j;
import me.robbie.fbl.common.DataHandler;
import me.robbie.fbl.common.DataHandlerContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TeamIdFinder implements DataHandler {

    private int[] mids = new int[] {
            127,//英超
            278,//英冠
            385,//英甲
            434,//英乙
            79,//意甲
            249,//意乙
            128,//西甲
            248,//西乙
            78,//德甲
            247,//德乙
            81,//法甲
            250,//法乙
            140,//葡超
            291,//葡甲
            82,//荷甲
            246,//荷乙
            151,//俄超
            137,//苏超
            133,//挪超
            132,//瑞典超
            83,//比甲
            148,//希超
            131,//瑞士超
            134,//丹超
            85,//奥甲
            84,//巴甲
            98,//阿甲
            99,//智利甲
            109,//墨超
            50,//日职
            241,//日乙
            51//韩职
    };

    @Override
    public void handlerAdded(DataHandlerContext dataHandlerContext) {

    }

    @Override
    public void handlerRemoved(DataHandlerContext dataHandlerContext) {

    }

    @Override
    public void dataProcessed(DataHandlerContext dataHandlerContext, Object[] objects) throws IOException, InterruptedException {

        List<String> tidList = new ArrayList<>();
        for(int mid : mids) {
            String url = String.format("http://info.sporttery.cn/football/history/history_data.php?mid=%s", mid);
            log.info("mid url: " + url);
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("a[href^=\"http://info.sporttery.cn/football/info/fb_team_info.php?tid=\"]");
            for(Element e : elements) {
                String teamUrl = e.attributes().get("href");
                log.info(teamUrl);
                tidList.add(getTeamIdByUrl(teamUrl));
            }
            int randomNumber = (int) (Math.random() * 3000);
            Thread.sleep(randomNumber);
        }
        List<String> tidListUnique = tidList.stream().distinct().collect(Collectors.toList());
        dataHandlerContext.fireDataProcessed(tidListUnique.toArray());
    }

    private String getTeamIdByUrl(String url) {
        int idx = url.lastIndexOf("=");
        String idStr = url.substring(idx + 1);
        return idStr;
    }
}
