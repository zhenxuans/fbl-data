package me.robbie.fbl.data.model.sporttery;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class WinDrawLoseMatchResult {
    private String league;
    private String a_cn;
    private String h_cn;
    private String date;
    private String result;
    private String prize_str;
    private String time;
    private String mid;
    private double a;
    private double h;
    private double d;
    private String full;
    private String num;
}
