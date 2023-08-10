package com.jojoldu.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor       // 자동으로 생성자 주입 코드 생성
public enum Role {             // enum(열거형 - 서로 연관된 상수들의 집합)

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;    // final(상수값으로 만듦)
    private final String title;

}
