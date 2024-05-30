package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.WantToReadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WantToReadRepository extends JpaRepository<WantToReadEntity, String> {
    List<WantToReadEntity> findByUserId(int user_id);

    WantToReadEntity findByUserIdAndIsbn(int user_id, String isbn);


}
