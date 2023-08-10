package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {             // 비즈니스 로직에서 생성된 데이터를 클라이언트에 리턴
    private Long id;                        // 필드(변수 집합) 선언
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {      // 생성자(인스턴스 초기화 메서드) 선언 : : 엔터티 객체들을 초기화해서 저장
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
