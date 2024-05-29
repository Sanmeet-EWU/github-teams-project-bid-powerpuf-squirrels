package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.model.WantToReadEntity;
import com.powerpuffsquirrels.noveleaf.repository.WantToReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WantToReadService {

    @Autowired
    private WantToReadRepository readShelfRepository;

    public List<WantToReadEntity> getAllReadShelves() {
        return readShelfRepository.findAll();
    }

    public List<WantToReadEntity> getReadShelvesByUserId(int userId) {
        return readShelfRepository.findByUserId(userId);
    }

    public WantToReadEntity getWantReadItem(String isbn, int userId) {
        return readShelfRepository.findByUserIdAndIsbn(userId, isbn);
    }

    //add to want to read read shelf by String isbn
    public void addWantToReadItem(String isbn, int userId) {
        WantToReadEntity readShelfEntity = new WantToReadEntity();
        readShelfEntity.setIsbn(isbn);
        readShelfEntity.setUserId(userId);
        readShelfEntity.setDateAdded(new java.sql.Date(System.currentTimeMillis()));
        readShelfRepository.save(readShelfEntity);
    }

    public void updateWantToReadItem(String isbn, int rating, int userId) {
        WantToReadEntity readShelfEntity = readShelfRepository.findByUserIdAndIsbn(userId, isbn);
        readShelfEntity.setIsbn(isbn);
        readShelfEntity.setUserId(userId);
        readShelfRepository.save(readShelfEntity);
    }

    public void removeWantToReadItem(String isbn, int userId) {
        WantToReadEntity readShelfEntity = readShelfRepository.findByUserIdAndIsbn(userId, isbn);
        readShelfRepository.delete(readShelfEntity);
    }
}
