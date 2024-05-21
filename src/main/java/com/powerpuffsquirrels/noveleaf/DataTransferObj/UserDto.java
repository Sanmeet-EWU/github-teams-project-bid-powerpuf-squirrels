package com.powerpuffsquirrels.noveleaf.DataTransferObj;

import lombok.Builder;
import lombok.Data;


//transfer these around between processes instead of User objects because we don't need to and shouldn't want to pass around the hash data unnecessarily


@Data
@Builder
public class UserDto {
    private int UserID;
    private String username;
}
