package com.powerpuffsquirrels.noveleaf.Mapping;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.AuthorDto;
import com.powerpuffsquirrels.noveleaf.model.Author;



public class AuthorMapper {

        public static AuthorDto mapToAuthorDto(Author author){

                AuthorDto authorDto = new AuthorDto(

                        author.getAuthorID(),
                        author.getFirstName(),
                        author.getLastName()
                     );

                return authorDto;


        }

        public static Author mapToAuthor(AuthorDto authorDto)
        {
                Author author= new Author(

                        authorDto.getAuthorID(),
                        authorDto.getFirstName(),
                        authorDto.getLastName()

                );


                return author;


        }


}


