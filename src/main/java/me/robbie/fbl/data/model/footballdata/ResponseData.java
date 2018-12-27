package me.robbie.fbl.data.model.footballdata;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseData {
	private HashMap<String, String> headers;
	private int responseCode;
	private String reasonPhrase;
	private String content;
}
