package com.powerpuffsquirrels.noveleaf.DataTransferObj;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {

    private Integer authorID;
    private String firstName;
     private String lastName;

}
