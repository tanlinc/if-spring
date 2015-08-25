package app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class EventApp {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EventApp.class, args);
    }
}
