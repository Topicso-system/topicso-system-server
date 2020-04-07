package cz.xfabian.topicso.persistence.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    @Query(value = "SELECT * FROM category WHERE parent_id IS NULL ORDER BY order_number", nativeQuery = true)
    ArrayList<CategoryEntity> getMainCategories();
}
