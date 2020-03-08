package com.sphong.historyapi.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@NoArgsConstructor
@Document(indexName = "search_history", type = "search")
public class SearchHistory {
    @Id
    private Long id;
    private String userEmail;
    private String keyword;

    @Builder
    public SearchHistory(String userEmail, String keyword) {
        this.userEmail = userEmail;
        this.keyword = keyword;
    }
}
