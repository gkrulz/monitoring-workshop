package com.padmaka.monitoring;

import com.padmaka.monitoring.model.Health;
import com.padmaka.monitoring.model.HealthResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HealthMonitoringServiceTest {

    @Autowired
    private HealthMonitoringService healthMonitoringService;

    @Test
    void calculateHealthWithoutWebFluxTest() {
        HealthResponse healthResponse = healthMonitoringService.calculateHealthWithoutWebFlux();

        Assertions.assertThat(healthResponse.getOverallHealth().getStatus()).isEqualTo("GREEN");
        Assertions.assertThat(healthResponse.getDependencies().size()).isEqualTo(5);
    }
}
