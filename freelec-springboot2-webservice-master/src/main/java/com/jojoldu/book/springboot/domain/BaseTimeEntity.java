package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass                                 // 부모클래스를 상속받는 자식 클래스에 매핑 정보(엔터티 컬럼)만 제공
@EntityListeners(AuditingEntityListener.class)    // 해당 클래스에 Auditing 기능을 포함
public abstract class BaseTimeEntity {

    @CreatedDate                                 // Entity가 생성되어 저장될 때, 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate                           // 조회한 Entity의 값을 변경할 때, 시간 자동 저장
    private LocalDateTime modifiedDate;

}
