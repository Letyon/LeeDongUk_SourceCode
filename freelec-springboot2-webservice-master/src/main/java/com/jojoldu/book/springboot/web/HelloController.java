package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController                         // Json 형태로 객체 데이터를 반환(REST API설계 방식에서 사용하는 어노테이션)
public class HelloController {

    @GetMapping("/hello")                // 클라이언트가 리소스를 조회할 때 필요한 어노테이션
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,     // "name"이라는 이름으로 name 변수의 값을 받아 옴
                                     @RequestParam("amount") int amount) {  // "amount"라는 이름으로 amount 변수의 값을 받아 옴
        return new HelloResponseDto(name, amount);
    }

}
