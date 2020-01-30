package com.sphong.kafkaproducer.demo.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String topic;

    @Builder
    public PostResponseDto (Long id, String title, String topic) {
        this.id = id;
        this.title = title;
        this.topic = topic;
    }
}
