package me.robbie.fbl.data;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledService {

	public ScheduledService() {
	}
	
	@Async
	@Scheduled(fixedRate = 5000)
	public void startTaskAtFixedRate() {
		log.debug("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
	}
	
	@Async
	@Scheduled(fixedDelay = 5000)
	public void startTaskAtFixedDelay() {
		log.debug("=====>>>>>使用fixedDelay{}", System.currentTimeMillis());
	}

}
