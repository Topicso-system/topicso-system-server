package cz.xfabian.topicso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Launcher {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Launcher.class, args);
		context.getBean(DataFiller.class).fillData();
	}
}
