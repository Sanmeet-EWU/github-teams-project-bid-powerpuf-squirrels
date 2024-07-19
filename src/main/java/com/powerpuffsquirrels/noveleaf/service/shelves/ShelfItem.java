package com.powerpuffsquirrels.noveleaf.service.shelves;

import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;

public interface ShelfItem {
    ReadShelfEntity ReadShelfEntity();
    Book book();
    Author author();

    // Default method using the instance provided by the implementing class
    default String getIsbn() {
        return this.ReadShelfEntity().getIsbn();
    }
}
