package com.sphong.historyapi.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sphong.historyapi.domain.VisitHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VisitHistoryRequestDto {
    private String email;
    private String url;

    public VisitHistory convert() {
        return VisitHistory.builder().userEmail(this.getEmail()).url(this.getUrl()).build();
    }

    @Builder
    public VisitHistoryRequestDto (String email, String url) {
        this.email = email;
        this.url = url;
    }

    public static String convertToJson(VisitHistoryRequestDto dto){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String result = objectMapper.writeValueAsString(dto);
            return result;
        } catch (JsonProcessingException e) {
            System.out.println("=============================================");
            return "";
        }
    }
}
