package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {             // 비즈니스 로직에서 생성된 데이터를 클라이언트에 반환

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {      // (Entity -> DTO) 메서드
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
