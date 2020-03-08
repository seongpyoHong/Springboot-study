package com.sphong.historyapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@NoArgsConstructor
@Document(indexName = "visit_history", type ="visit")
public class VisitHistory {
    @Id
    private Long id;
    private String userEmail;
    private String url;

    @Builder
    public VisitHistory(String userEmail, String url) {
        this.userEmail = userEmail;
        this.url = url;
    }
}
