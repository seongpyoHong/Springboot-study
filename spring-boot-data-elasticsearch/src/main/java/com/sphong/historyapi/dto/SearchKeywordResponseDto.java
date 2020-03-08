package com.sphong.historyapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SearchKeywordResponseDto {
    private String email;
    private List<String> keywords = new ArrayList<>();

    public SearchKeywordResponseDto(String email, List<String> keywords) {
        this.email = email;
        this.keywords = keywords;
    }
}
