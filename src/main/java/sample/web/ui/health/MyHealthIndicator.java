package sample.web.ui.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Что-то плохое творится! Error Code ", errorCode).build();
        }
        return Health.up().build();
    }

    public static int ALL_BAD = 666;
    int check(){
        return ALL_BAD;
    }

}
