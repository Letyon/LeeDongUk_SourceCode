package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {      // 클라이언트로부터 전달받은 요청 데이터를 담고 있는 객체
    private String title;               // 필드(변수 집합) 선언
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {       // 생성자(인스턴스 초기화 메서드) 선언 : 엔터티 객체들을 초기화해서 저장
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {      // 엔터티(Entity 으로 변환하는 메서드) 선언 : 엔터티 객체들을 반환
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
