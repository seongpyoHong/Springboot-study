package com.sphong.historyapi.service;

import com.sphong.historyapi.domain.SearchHistory;
import com.sphong.historyapi.domain.SearchHistoryRepository;
import com.sphong.historyapi.domain.VisitHistory;
import com.sphong.historyapi.domain.VisitHistoryRepository;
import com.sphong.historyapi.dto.SearchKeywordRequestDto;
import com.sphong.historyapi.dto.VisitHistoryRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
public class HistoryService {

    private final VisitHistoryRepository visitHistoryRepository;
    private final SearchHistoryRepository searchHistoryRepository;

    public HistoryService(VisitHistoryRepository visitHistoryRepository, SearchHistoryRepository searchHistoryRepository) {
        this.visitHistoryRepository = visitHistoryRepository;
        this.searchHistoryRepository = searchHistoryRepository;
    }

    public String saveVisitHistory(VisitHistoryRequestDto requestDto) {
        VisitHistory history = dtoToEntity(requestDto, VisitHistoryRequestDto::convert);
        return visitHistoryRepository.save(history).getUrl();
    }

    public List<String> getVisitHistory(String email) {
        return visitHistoryRepository.findAllByUserEmail(email).stream().map(VisitHistory::getUrl).collect(toList());
    }

    public String saveSearchKeyword(SearchKeywordRequestDto requestDto) {
        SearchHistory history = dtoToEntity(requestDto,SearchKeywordRequestDto::convert);
        return searchHistoryRepository.save(history).getKeyword();
    }

    public List<String> getSearchKeyword(String email) {
        return searchHistoryRepository.findAllByUserEmail(email).stream().map(SearchHistory::getKeyword).collect(toList());
    }

    private <T,R> R dtoToEntity(T dto, Function<T,R> converter) {
        return converter.apply(dto);
    }
}
