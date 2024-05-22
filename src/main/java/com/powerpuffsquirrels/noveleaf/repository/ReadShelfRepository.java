package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.ListCrudRepository;


import java.util.List;

@Repository
public interface ReadShelfRepository extends JpaRepository<ReadShelfEntity, String> {
    List<ReadShelfEntity> findByUserId(int user_id);


}
