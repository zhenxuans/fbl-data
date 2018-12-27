package me.robbie.fbl.data.model.sporttery;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Status {
    private String code;
    private String message;
}
