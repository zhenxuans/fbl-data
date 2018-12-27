package me.robbie.fbl.data.model.sporttery;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TeamMatchData {
    private String match_id;
    private String date_cn;
    private String time_cn;
    private String gameweek;
    private String sporttery_matchid;
    private String flag_reverse;
    private String l_id_dc;
    private String s_id_dc;
    private String r_id_dc;
    private String g_id_dc;
    private String h_id_dc;
    private String a_id_dc;
    private String l_cn;
    private String l_cn_abbr;
    private String l_color;
    private String h_cn;
    private String h_cn_abbr;
    private String a_cn;
    private String a_cn_abbr;
    private int is_home;
    private String half;
    @JSONField(name = "final")
    private String final_score;
    private String team_rs;
    private String h;
    private String d;
    private String a;
}
