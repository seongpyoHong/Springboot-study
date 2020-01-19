package com.sphong.resttemplate.demo.dto;

import lombok.*;

@RequiredArgsConstructor
@Getter
public class UserDto {
    private final String userName;
    private final String location;
}
