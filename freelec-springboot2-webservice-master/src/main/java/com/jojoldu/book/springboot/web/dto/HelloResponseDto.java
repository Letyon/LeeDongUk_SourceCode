package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {                // 클라이언트의 요청 데이터를 entity 에서 가져옴

    private final String name;
    private final int amount;

}
