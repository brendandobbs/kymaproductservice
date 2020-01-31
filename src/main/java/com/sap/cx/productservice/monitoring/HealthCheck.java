package com.sap.cx.productservice.monitoring;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Actuator")
public class HealthCheck implements HealthIndicator {
	
	private boolean isHealthy = false;
	
	private HealthCheck()
	{
		// wait 40 seconds before setting isHealthly to true allow the app enough time to boot
		ScheduledExecutorService scheduled =
		          Executors.newSingleThreadScheduledExecutor();
		        scheduled.schedule(() -> {
		            isHealthy = true;
		        }, 3, TimeUnit.SECONDS);
	}
	
	@Override
	public Health health() {	
		return isHealthy ? Health.up().build() : Health.down().build();						
	}
}
