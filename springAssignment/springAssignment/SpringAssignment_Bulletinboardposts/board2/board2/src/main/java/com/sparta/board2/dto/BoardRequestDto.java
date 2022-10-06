package com.sparta.board2.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor /* @NoArgsConstructor : 파라미터가 없는 기본 생성자를 생성해주는 Lombok 어노테이션*/
public class BoardRequestDto { // DTO : 테이블의 데이터에 접근할때 완충역할
    private String username; // 게시글 작성자 이름
    private String contents; //게시글 내용
    private String title; //게시글 제목
    private String password; //게시글 비밀번호
}
