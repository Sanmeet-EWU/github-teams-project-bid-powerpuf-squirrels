package com.powerpuffsquirrels.noveleaf.Service;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.AuthorDto;
import com.powerpuffsquirrels.noveleaf.model.Author;

import java.util.List;

public interface AuthorServInterface {

    List<AuthorDto> getAllAuthors() ;

}
