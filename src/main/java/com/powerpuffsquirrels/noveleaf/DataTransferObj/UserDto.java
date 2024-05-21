package com.powerpuffsquirrels.noveleaf.DataTransferObj;

//transfer these around between processes instead of User objects so we don't pass round the hash unnecessarily


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private int UserID;
    private String username;
}
