package com.sphong.resttemplate.demo.service;

import com.sphong.resttemplate.demo.domain.Order;
import com.sphong.resttemplate.demo.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class OrderService {

    private RestTemplate restTemplate;

    public OrderService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public UserDto getUserHasMenu(String menu) {
        String getUserApiUrl = "http://localhost:9090/user/" + menu;
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromHttpUrl(getUserApiUrl);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
        return restTemplate.getForObject(getUserApiUrl,UserDto.class);
    }
}
