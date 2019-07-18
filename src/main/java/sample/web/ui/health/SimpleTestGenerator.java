package sample.web.ui.health;

import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class SimpleTestGenerator {

    @Autowired
    private MetricWriter metricWriter;

    @Scheduled(fixedDelay = 100)
    private void generate(){
        metricWriter.set(new Metric<Number>("Speed", random()));
        metricWriter.set(new Metric<Number>("Speed2", random()));
    }

    private static int max = 10;
    private static int min = 1;
    int random(){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}