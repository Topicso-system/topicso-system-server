package cz.xfabian.topicso.persistence.video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Integer> {

    @Query(value = "SELECT * FROM video WHERE category_id = :categoryId", nativeQuery = true)
    ArrayList<VideoEntity> findByCategory(@Param("categoryId") int categoryId);
}
