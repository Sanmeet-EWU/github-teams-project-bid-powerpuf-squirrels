package com.powerpuffsquirrels.noveleaf.DataTransferObj;

import lombok.Builder;
import lombok.Data;

//transfer these around between processes instead of User objects, so we don't pass around the hash unnecessarily
@Data
@Builder
public class UserDto {
    private int UserID;
    private String username;
}
