package com.sphong.historyapi.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchHistoryRepository extends ElasticsearchRepository<SearchHistory,Long> {
    List<SearchHistory> findAllByUserEmail(String email);

}
