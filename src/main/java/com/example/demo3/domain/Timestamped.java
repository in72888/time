package com.example.demo3.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // Entity가 자동으로 컬럼으로 인식합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
@Getter
public abstract class Timestamped { // abstract : 빵을 못만드는 빵틀, 상속으로만 사용가능

    @CreatedDate    //생성날짜
    private LocalDateTime createdAt;

    @LastModifiedDate   //변경날짜
    private LocalDateTime modifiedAt;
}