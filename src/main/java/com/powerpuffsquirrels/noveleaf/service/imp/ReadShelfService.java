package com.powerpuffsquirrels.noveleaf.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.powerpuffsquirrels.noveleaf.repository.ReadShelfRepository;
import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import java.util.List;

@Service
public class ReadShelfService {

    @Autowired
    private ReadShelfRepository readShelfRepository;

    public List<ReadShelfEntity> getAllReadShelves() {
        return readShelfRepository.findAll();
    }

    public List<ReadShelfEntity> getReadShelvesByUserId(int userId) {
        return readShelfRepository.findByUserId(userId);
    }

    //add to read shelf by String isbn
    public void addReadShelfItem(String isbn, int userId) {
        ReadShelfEntity readShelfEntity = new ReadShelfEntity();
        readShelfEntity.setIsbn(isbn);
        readShelfEntity.setUserId(userId);
        readShelfEntity.setDateAdded(new java.sql.Date(System.currentTimeMillis()));
        readShelfRepository.save(readShelfEntity);
    }
}
