package com.sparta.board2.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 비밀번호 확인하기
@Getter
@NoArgsConstructor /* @NoArgsConstructor : 파라미터가 없는 기본 생성자를 생성해주는 Lombok 어노테이션*/
public class BoardCheckRequestDto {
    private String password;

    }


