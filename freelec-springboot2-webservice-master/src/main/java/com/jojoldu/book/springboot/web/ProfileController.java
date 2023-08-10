package com.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class ProfileController {
    private final Environment env;

    @GetMapping("/profile")
    public String profile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());          // 프로필 List 객체<String 타입의 배열> = (추가/삭제 필요없는)배열 리스트(현재 활성화된 profile 을 리턴하는 메서드)
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0);   // 기본 프로필 = 삼항 연산자(프로필이 비어있다면 ? "default"문자열 리턴 : 0번째 프로필 값 리턴)

        return profiles.stream()                              // 스트림 객체로 만들기 위한 메서드
                .filter(realProfiles::contains)               // 스트림 내 요소들을 하나씩 평가해서 걸러내는 메서드
                .findAny()                                    // 조건에 일치하는 요소 1개를 리턴
                .orElse(defaultProfile);                      // 해당 값이 null 이든 아니든 관계없이 항상 리턴
                                                              // .map() : 스트림 내 요소들을 하나씩 특정 값으로 변환
    }
}
