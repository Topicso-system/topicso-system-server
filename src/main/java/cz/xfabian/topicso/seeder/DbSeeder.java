package cz.xfabian.topicso.seeder;

import cz.xfabian.topicso.config.AppEnvironment;
import cz.xfabian.topicso.core.video.VideoService;
import cz.xfabian.topicso.domain.category.CategoryEntity;
import cz.xfabian.topicso.domain.category.CategoryRepository;
import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;
import cz.xfabian.topicso.domain.video.VideoEntity;
import cz.xfabian.topicso.domain.video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder {

    @Autowired
    private AppEnvironment environment;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private VideoRepository videoRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        if (!environment.isDebug() || isDataInserted()) return; // Skip

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
        seedItVideos();
//        seedDanceVideos();
    }

    private void seedDanceVideos() {
        CategoryEntity danceCategory = categoryRepository.findById(3).get();
        throwIfWrongCategory(danceCategory, "Dance");
    }

    private void seedItVideos() {
        CategoryEntity itCategory = categoryRepository.findById(1).get();
        throwIfWrongCategory(itCategory, "Information Technologies");

        VideoEntity videoEntity;
        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 1 - Introduction and agenda");
        videoEntity.setYoutubeId("2E3WqYupx7c");
        videoEntity.setRating(5.0);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoEntity.setDifficultyLevel(DifficultyLevel.ADVANCED);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 2 - Why write tests");
        videoEntity.setYoutubeId("kp6ei9mEggc");
        videoEntity.setRating(4.8);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoEntity.setDifficultyLevel(DifficultyLevel.ADVANCED);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 3 - Why do we need a testing framework");
        videoEntity.setYoutubeId("deMlViVF-mE");
        videoEntity.setRating(4.1);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoEntity.setDifficultyLevel(DifficultyLevel.ADVANCED);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 4 - Why JUnit 5");
        videoEntity.setYoutubeId("sQ4KgrxGQSc");
        videoEntity.setRating(3.6);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoEntity.setDifficultyLevel(DifficultyLevel.ADVANCED);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 5 - JUnit 5 Architecture");
        videoEntity.setYoutubeId("1xRcRYKOTHs");
        videoEntity.setRating(3.9);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoEntity.setDifficultyLevel(DifficultyLevel.ADVANCED);
        videoRepository.save(videoEntity);

        videoEntity = new VideoEntity();
        videoEntity.setTitle("JUnit 5 Basics 6 - Creating a new JUnit 5 Maven project");
        videoEntity.setYoutubeId("09ZZiNgUPVU");
        videoEntity.setRating(4.8);
        videoEntity.setDescription("JUnit 5 Basics is an introduction to the JUnit Jupiter testing framework. JUnit is the defacto standard for testing in Java. learn about how to use JUnit to write effective tests. Understand the features of JUnit including the `@Test` annotation, assertion APIs, test lifecycle and controlling executions.");
        videoEntity.setCategory(itCategory);
        videoEntity.setDifficultyLevel(DifficultyLevel.ADVANCED);
        videoRepository.save(videoEntity);
    }

    private void throwIfWrongCategory(CategoryEntity category, String expectedCategoryTitle) {
        if (!category.getName().equals(expectedCategoryTitle)) throw new IllegalStateException("Wrong category has been loaded during seeding");
    }

    private boolean isDataInserted() {
        return !videoRepository.findAll().isEmpty();
    }
}
