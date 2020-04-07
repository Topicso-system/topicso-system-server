package cz.xfabian.topicso.seeder;

import cz.xfabian.topicso.core.video.VideoService;
import cz.xfabian.topicso.persistence.category.CategoryEntity;
import cz.xfabian.topicso.persistence.category.CategoryRepository;
import cz.xfabian.topicso.persistence.video.VideoEntity;
import cz.xfabian.topicso.persistence.video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private VideoRepository videoRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        if (!videoRepository.findAll().isEmpty()) return; // Skip when data already inserted
        seedCategories();
        seedVideos();
    }

    private void seedCategories() {
        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setName("Information Technologies");
        categoryEntity1.setPicture("../assets/img/categories/IT.png");
        categoryEntity1.setOrder(1);
        categoryRepository.save(categoryEntity1);

        CategoryEntity categoryEntity2 = new CategoryEntity();
        categoryEntity2.setName("Sport");
        categoryEntity2.setPicture("../assets/img/categories/Sport.png");
        categoryEntity2.setOrder(2);
        categoryRepository.save(categoryEntity2);

        CategoryEntity categoryEntity3 = new CategoryEntity();
        categoryEntity3.setName("Dance");
        categoryEntity3.setPicture("../assets/img/categories/Dance.png");
        categoryEntity3.setOrder(3);
        categoryRepository.save(categoryEntity3);
    }

    private void seedVideos() {
        CategoryEntity itCategory = categoryRepository.findById(1).get();
        if (!itCategory.getName().equals("Information Technologies")) throw new IllegalStateException("Wrong category has been loaded during seeding");

        VideoEntity videoEntity;
        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 1 - Introduction and agenda");
        videoEntity.setYoutubeId("2E3WqYupx7c");
        videoEntity.setRating(5.0);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 2 - Why write tests");
        videoEntity.setYoutubeId("kp6ei9mEggc");
        videoEntity.setRating(4.8);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 3 - Why do we need a testing framework");
        videoEntity.setYoutubeId("deMlViVF-mE");
        videoEntity.setRating(4.1);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 4 - Why JUnit 5");
        videoEntity.setYoutubeId("sQ4KgrxGQSc");
        videoEntity.setRating(3.6);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 5 - JUnit 5 Architecture");
        videoEntity.setYoutubeId("1xRcRYKOTHs");
        videoEntity.setRating(3.9);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 6 - Creating a new JUnit 5 Maven project");
        videoEntity.setYoutubeId("09ZZiNgUPVU");
        videoEntity.setRating(4.8);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoRepository.save(videoEntity);
    }
}
