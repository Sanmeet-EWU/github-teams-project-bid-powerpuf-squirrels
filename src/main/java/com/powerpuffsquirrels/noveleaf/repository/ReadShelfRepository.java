package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ReadShelfRepository extends JpaRepository<ReadShelfEntity, String> {
    List<ReadShelfEntity> findByUserId(int user_id);

    ReadShelfEntity findByUserIdAndIsbn(int user_id, String isbn);

    //get the most added books in the last 7 days
    @Query(value = "SELECT isbn FROM read_shelf WHERE date_added > (current_date - 7) GROUP BY isbn ORDER BY COUNT(user_id) DESC LIMIT 7", nativeQuery = true)
    List<String> mostAdded7Days();
}
