package com.sphong.kafkaproducer.demo.controller;

import com.sphong.kafkaproducer.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/posts/{id}")
    public String readPost(@PathVariable("id") Long id) {
        return postService.loadPostById(id);
    }
}
