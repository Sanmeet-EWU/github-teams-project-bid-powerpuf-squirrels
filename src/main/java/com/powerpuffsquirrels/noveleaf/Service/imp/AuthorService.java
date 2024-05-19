package com.powerpuffsquirrels.noveleaf.Service.imp;
import com.powerpuffsquirrels.noveleaf.DataTransferObj.AuthorDto;
import com.powerpuffsquirrels.noveleaf.Mapping.AuthorMapper;
import com.powerpuffsquirrels.noveleaf.Service.AuthorServInterface;
import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService implements AuthorServInterface {

    private AuthorRepository author_repo;

    public AuthorService(AuthorRepository author_repo) {
        this.author_repo = author_repo;
    }



    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = author_repo.findAll();
        List<AuthorDto> authorDtos = authors.stream()
                .map((author -> AuthorMapper.mapToAuthorDto(author)))
                .collect(Collectors.toList());

            return authorDtos;
        }
    /* getAllAuthros take data from the DataBAase entites and convert is into Author objs.
    * it retrieves all Authros from the DB
    * will need to write more methods.
    * */

/*
    lambda  List <Integer > num - Ararays.asList (1,2,3,4,5);
    List <Integer > sqr = num.stream()
        .map(num -> num* num)
        .collect(Colletors.toList());

 */



}

