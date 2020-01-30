package com.sphong.kafkaproducer.demo.service;

import com.sphong.kafkaproducer.demo.domain.Post;
import com.sphong.kafkaproducer.demo.domain.PostRepository;
import com.sphong.kafkaproducer.demo.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final KafkaTemplate kafkaTemplate;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String loadPostById(Long id) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateStr = localDateTime.format(dateTimeFormatter);
        Post post = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Not found"));
        PostResponseDto.builder().id(post.getId()).title(post.getTitle()).topic(post.getTopic()).build();
        String message = "date:" + dateStr + "\t" + "title:" + post.getTitle() +"\t" + "topic:" + post.getTopic();
        kafkaTemplate.send("click-log", message);
        return "Send Message : "+ message;
    }
}

