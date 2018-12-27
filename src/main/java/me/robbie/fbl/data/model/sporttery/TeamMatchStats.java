package me.robbie.fbl.data.model.sporttery;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TeamMatchStats {
    private int win;
    private int draw;
    private int lose;
}
