package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;      // 서비스 주입 : 접근제한자(private) 자료형(final) 클래스(PostService) 변수명(postsService)

    @PostMapping("/api/v1/posts")                // 클라이언트가 리소스를 생성할 때 필요한 어노테이션
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);         // save 생성 메서드 : 서비스의 requestDTO 에 있는, 엔터티 객체들 리턴
    }

    @PutMapping("/api/v1/posts/{id}")            // 클라이언트가 리소스를 갱신(수정)할 때 필요한 어노테이션
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);   // update 수정 메서드 : 서비스의 id 값 -> requestDto 의 해당 id 값으로 변환
    }

    @DeleteMapping("/api/v1/posts/{id}")         // 클라이언트가 리소스를 삭제할 때 필요한 어노테이션
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);                  // delete 삭제 메서드 : 서비스의 id를 삭제
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")             // 클라이언트가 리소스를 조회할 때 필요한 어노테이션
    public PostsResponseDto findById(@PathVariable Long id) {

        return postsService.findById(id);         // findById 단일행 조회 메서드 : 서비스의 id를 단일 조회
    }

    @GetMapping("/api/v1/posts/list")             // 클라이언트가 리소스를 조회할 때 필요한 어노테이션
    public List<PostsListResponseDto> findAll() {

        return postsService.findAllDesc();       // findAllDesc 전체행 조회 메서드(id를 내림차순으로 정렬하여 리턴)
    }
}
