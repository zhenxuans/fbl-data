package me.robbie.fbl.data.model.footballdata;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MockModel {
	private int id;
	private String name;
	private boolean isMock;
	private List<String> data;
	private Map<String, String> values;
}
