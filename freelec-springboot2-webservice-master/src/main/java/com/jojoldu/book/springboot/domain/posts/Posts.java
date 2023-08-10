package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter                   // 엔터티의 필드 조회(필드 생성 시 필요한 어노테이션)
@NoArgsConstructor        // 기본 생성자 만듦(생성자 생성 시 필요한 어노테이션)
@Entity                   // 객체-테이블 매핑(엔터티 생성 시 필요한 어노테이션)
public class Posts extends BaseTimeEntity {

    @Id                   // 기본키 매핑(기본키가 있는 컬럼 생성 시 필요한 어노테이션)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본키 생성 전략(기본키가 있는 컬럼 생성 시 필요한 어노테이션)
    private Long id;

    @Column(length = 500, nullable = false)      // 필드-컬럼 매핑(DB테이블의 컬럼 매핑 시 필요한 어노테이션)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)    // 필드-컬럼 매핑(DB테이블의 컬럼 매핑 시 필요한 어노테이션)
    private String content;

    private String author;

    @Builder                                     // 가독성 좋은 생성자 만듦(생성자 생성 시 필요한 어노테이션)
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
