package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ReadShelfRepository extends JpaRepository<ReadShelfEntity, String> {
    List<ReadShelfEntity> findByUserId(int user_id);

    ReadShelfEntity findByUserIdAndIsbn(int user_id, String isbn);


}
