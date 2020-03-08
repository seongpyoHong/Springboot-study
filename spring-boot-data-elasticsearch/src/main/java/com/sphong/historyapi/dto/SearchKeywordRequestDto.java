package com.sphong.historyapi.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sphong.historyapi.domain.SearchHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchKeywordRequestDto {
    private String email;
    private String keyword;

    @Builder
    public SearchKeywordRequestDto(String email, String keyword) {
        this.email = email;
        this.keyword = keyword;
    }

    public SearchHistory convert() {
        return SearchHistory.builder().keyword(keyword).userEmail(email).build();
    }

    public String convertToJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
