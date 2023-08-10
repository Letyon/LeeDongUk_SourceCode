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

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")                // 클라이언트가 리소스를 생성할 때 필요한 어노테이션
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);         // DTO 에 있는, 엔터티 객체들을 저장하는 메서드
    }

    @PutMapping("/api/v1/posts/{id}")            // 클라이언트가 리소스를 갱신(수정)할 때 필요한 어노테이션
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);      // id의 값을, requestDto 의 해당 id 값으로 바꾸는 메서드
    }

    @DeleteMapping("/api/v1/posts/{id}")         // 클라이언트가 리소스를 삭제할 때 필요한 어노테이션
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);                  // id를 삭제하는 메서드
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")             // 클라이언트가 리소스를 조회할 때 필요한 어노테이션
    public PostsResponseDto findById(@PathVariable Long id) {

        return postsService.findById(id);         // id를 단일 조회하는 메서드
    }

    @GetMapping("/api/v1/posts/list")             // 클라이언트가 리소스를 조회할 때 필요한 어노테이션
    public List<PostsListResponseDto> findAll() {

        return postsService.findAllDesc();       // id를 전체 조회하는 메서드(내림차순으로 정렬하여 리턴)
    }
}
