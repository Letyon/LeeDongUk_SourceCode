package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller                              // view를 반환하기 위해 사용하는 어노테이션
public class IndexController {          // Controller 클래스(클라이언트 요청에 대한 서비스의 응답)

    private final PostsService postsService;   // 접근제한자(private) 자료형(final) 클래스(PostsService) 변수명(postsService)

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {           // Model(객체), @LoginUser(로그인 유저를 지칭하는 어노테이션)
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());      // addAttribute 메서드("userName"이라는 이름으로, user 객체에서 가져온 이름을 View 로 데이터 전달)
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {   // 접근제한자(public) 자료형(String) 메서드(자료형(Long, Model) 인수(id, model))
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
