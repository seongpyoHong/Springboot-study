package com.sphong.historyapi.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitHistoryRepository extends ElasticsearchRepository<VisitHistory, Long> {
    List<VisitHistory> findAllByUserEmail(String email);
}
