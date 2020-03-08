package com.sphong.historyapi;


import com.sphong.historyapi.domain.SearchHistory;
import com.sphong.historyapi.domain.SearchHistoryRepository;
import com.sphong.historyapi.domain.VisitHistory;
import com.sphong.historyapi.domain.VisitHistoryRepository;
import com.sphong.historyapi.dto.SearchKeywordRequestDto;
import com.sphong.historyapi.dto.VisitHistoryRequestDto;
import com.sphong.historyapi.service.HistoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HistoryServiceTest {

    @Autowired
    private VisitHistoryRepository visitHistoryRepository;

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @Autowired
    private HistoryService historyService;

    @AfterEach
    public void tearDown() {
        visitHistoryRepository.deleteAll();;
        searchHistoryRepository.deleteAll();
    }

    @Test
    public void saveVisitHistoryTest() {
        //given
        String email = "sphong@mail";
        String url = "testUrl";
        VisitHistoryRequestDto requestDto = VisitHistoryRequestDto.builder().email(email).url(url).build();
        //when
        historyService.saveVisitHistory(requestDto);
        //then
        List<VisitHistory> findList = visitHistoryRepository.findAllByUserEmail(requestDto.getEmail());
        assertEquals(email, findList.get(0).getUserEmail());
        assertEquals(url, findList.get(0).getUrl());
    }

    @Test
    public void saveSearchKeywordTest() {
        //given
        String email = "sphong@mail";
        String keyword = "testKeyword";
        SearchKeywordRequestDto requestDto = SearchKeywordRequestDto.builder().email(email).keyword(keyword).build();
        //when
        historyService.saveSearchKeyword(requestDto);
        //then
        List<SearchHistory> findList = searchHistoryRepository.findAllByUserEmail(requestDto.getEmail());
        assertEquals(email, findList.get(0).getUserEmail());
        assertEquals(keyword, findList.get(0).getKeyword());
    }

    @Test
    public void getVisitHistoryTest() {
        //given
        String email = "sphong@mail";
        String url1 = "testUrl1";
        String url2 = "testUrl2";
        VisitHistoryRequestDto requestDto1 = VisitHistoryRequestDto.builder().email(email).url(url1).build();
        VisitHistoryRequestDto requestDto2 = VisitHistoryRequestDto.builder().email(email).url(url2).build();
        historyService.saveVisitHistory(requestDto1);
        historyService.saveVisitHistory(requestDto2);

        //when
        List<String> visitedUrls = historyService.getVisitHistory(email);

        //then
        assertTrue(visitedUrls.contains(url1));
        assertTrue(visitedUrls.contains(url2));
    }

    @Test
    public void getSearchKeywordTest() {
        //given
        String email = "sphong@mail";
        String keyword1 = "testKeyword1";
        String keyword2 = "testKeyword2";
        SearchKeywordRequestDto requestDto1 = SearchKeywordRequestDto.builder().email(email).keyword(keyword1).build();
        SearchKeywordRequestDto requestDto2 = SearchKeywordRequestDto.builder().email(email).keyword(keyword2).build();
        historyService.saveSearchKeyword(requestDto1);
        historyService.saveSearchKeyword(requestDto2);

        //when
        List<String> searchKeyword = historyService.getSearchKeyword(email);

        //then
        assertTrue(searchKeyword.contains(keyword1));
        assertTrue(searchKeyword.contains(keyword2));
    }
}
