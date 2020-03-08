package com.sphong.historyapi.controller;

import com.sphong.historyapi.dto.SearchKeywordRequestDto;
import com.sphong.historyapi.dto.SearchKeywordResponseDto;
import com.sphong.historyapi.dto.VisitHistoryRequestDto;
import com.sphong.historyapi.dto.VisitHistoryResponseDto;
import com.sphong.historyapi.service.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping("/save_visit_history")
    public String saveVisitHistory(@RequestBody VisitHistoryRequestDto requestDto) {
        return historyService.saveVisitHistory(requestDto);
    }

    @GetMapping("/visit_page")
    public List<String > getVisitHistory(@RequestParam("email") String email) {
        return historyService.getVisitHistory(email);
    }

    @PostMapping("save_search_keyword")
    public String saveSearchKeyword(@RequestBody SearchKeywordRequestDto requestDto) {
        return historyService.saveSearchKeyword(requestDto);
    }

    @GetMapping("/search_keyword")
    public List<String> getSearchKeyword(@RequestParam("email") String email) {
        return historyService.getSearchKeyword(email);
    }
}
