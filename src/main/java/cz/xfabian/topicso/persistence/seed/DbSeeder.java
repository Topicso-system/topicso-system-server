package cz.xfabian.topicso.persistence.seed;

import cz.xfabian.topicso.core.video.VideoService;
import cz.xfabian.topicso.rest.video.dto.VideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder {

    @Autowired
    private VideoService videoService;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedVideos();
    }

    private void seedVideos() {
        VideoDTO videoDTO = new VideoDTO(1, "JUnit 5 Basics 1 - Introduction and agenda", "2E3WqYupx7c", 5, "JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoService.addVideo(videoDTO);

        videoDTO = new VideoDTO(2, "JUnit 5 Basics 2 - Why write tests", "kp6ei9mEggc", 4.8, "JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoService.addVideo(videoDTO);

        videoDTO = new VideoDTO(3, "JUnit 5 Basics 3 - Why do we need a testing framework", "deMlViVF-mE", 4.1, "JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoService.addVideo(videoDTO);

        videoDTO = new VideoDTO(4, "JUnit 5 Basics 4 - Why JUnit 5", "sQ4KgrxGQSc", 3.6, "JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoService.addVideo(videoDTO);

        videoDTO = new VideoDTO(5, "JUnit 5 Basics 5 - JUnit 5 Architecture", "1xRcRYKOTHs", 3.9, "JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoService.addVideo(videoDTO);

        videoDTO = new VideoDTO(6, "JUnit 5 Basics 6 - Creating a new JUnit 5 Maven project", "09ZZiNgUPVU", 4.8, "JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoService.addVideo(videoDTO);
    }
}
