package com.sphong.historyapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sphong.historyapi.controller.HistoryController;
import com.sphong.historyapi.domain.SearchHistoryRepository;
import com.sphong.historyapi.domain.VisitHistoryRepository;
import com.sphong.historyapi.dto.VisitHistoryRequestDto;
import com.sphong.historyapi.service.HistoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.function.Function;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HistoryController.class)
public class HistoryContollerTest {

    @MockBean
    private HistoryService historyService;

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    public void setup() {
    }

    private <T,R> R toJsonString(T request, Function<T,R> converter) {
        return converter.apply(request);
    }

    //TODO: mockMVC Return nothing.
    @Test
    public void saveVisitHistoryTest() throws Exception {
        String email = "test@email";
        String url = "testUrl";
        VisitHistoryRequestDto requestDto = VisitHistoryRequestDto.builder().email(email).url(url).build();
        given(this.historyService.saveVisitHistory(requestDto)).willReturn(requestDto.getUrl());
        System.out.println(historyService.saveVisitHistory(requestDto));
        mockMvc.perform(post("/save_visit_history").characterEncoding("utf-8")
                        .content(toJsonString(requestDto, VisitHistoryRequestDto::convertToJson))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
