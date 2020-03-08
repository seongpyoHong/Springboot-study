package com.sphong.historyapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class VisitHistoryResponseDto {
    private String email;
    private List<String> urls = new ArrayList<>();

    public VisitHistoryResponseDto(String email, List<String> urls) {
        this.email = email;
        this.urls = urls;
    }
}
