package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;        // 리포지토리 주입 : 접근제한자(private) 자료형(final) 클래스(PostsRepository) 변수명(postsRepository)

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();      // save 생성 메서드 : (Entity 으로 변환하는) 메서드에서, 엔터티 객체 중 Id를 리턴
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());  // update 수정 메서드 : Title, Content 수정
        return id;                                                    // 수정된 id 리턴
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        postsRepository.delete(posts);                              // delete 삭제 메서드 : 단일 조회한 id 삭제
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)                     // entity 변수에 (리포지토리에서 단일 id 조회한 값) 저장
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));   // id 이외의 값을 받으면, 예외 메서드 실행
        return new PostsResponseDto(entity);                 // PostsResponseDto 조회 메서드 : 단일 조회한 id 리턴
    }

    @Transactional(readOnly = true)      // 조회용 메서드임을 확인(메모리가 절약되는 성능상 이점, 조회용으로 가져온 Entity의 예상치 못한 수정을 방지)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .stream()                            // 스트림 객체로 만드는 메서드
                .map(PostsListResponseDto::new)      // .map() : 스트림 내 요소들을 하나씩 특정 값으로 변환
                .collect(Collectors.toList());       // 스트림의 요소들을 List 객체로 변환
    }
}
