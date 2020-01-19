package com.sphong.resttemplate.demo.service;

import com.sphong.resttemplate.demo.dto.UserDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.web.client.RestTemplateRequestCustomizer;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(SpringExtension.class)
@RestClientTest (value = OrderService.class)
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;


    private String getUserUrl = "http://localhost:9090/user/";
    @Test
    public void UserDto에_결과값이_정상적으로_저장된다 () {

        //given
        String orderedMenu = "testMenu";
        String expectedResponse = "{\"name\":\"sphong\",\"location\":\"Suwon\"}";

        mockRestServiceServer.expect(ExpectedCount.manyTimes(),requestTo(getUserUrl + orderedMenu))
        .andRespond(withSuccess(expectedResponse, MediaType.APPLICATION_JSON));

        //when
        UserDto response = orderService.getUserHasMenu(orderedMenu);

        //then
        assertEquals(response.getUserName(),"sphong");
        assertEquals(response.getLocation(),"Suwon");
    }

}