package me.robbie.fbl.data.model.sporttery;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;

@Data
@ToString
@NoArgsConstructor
public class WinDrawLose14 {
    private Status status;
    private HashMap<String, WinDrawLoseMatchResult> result;
}
