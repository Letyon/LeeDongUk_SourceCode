package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {       // 클라이언트의 요청 데이터를 entity 로 보냄
    private String title;                  // 필드(변수 집합) 선언
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {       // 생성자(인스턴스 초기화 메서드) 선언 : 엔터티 객체들을 초기화해서 저장
        this.title = title;
        this.content = content;
    }
}
