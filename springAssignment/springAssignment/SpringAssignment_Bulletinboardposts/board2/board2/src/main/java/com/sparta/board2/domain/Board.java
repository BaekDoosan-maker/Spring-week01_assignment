package com.sparta.board2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.board2.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Board extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false) // null 값 인정 -> 값이 null 로 들어가도 인정됨 // null 값 오류가 안뜨게 하는 것
    private String title; //게시글 제목

    @Column(nullable = false)
    private String username; //게시글 작성자이름

    @Column(nullable = false)
    private String contents; //게시글 내용

    @JsonIgnore  //password 안보이게 // get요청시 비밀번호 안보이게 하는 어노테이션.
    @Column(nullable = false)
    private String password; //게시글 비밀번호

    public Board(String title, String username, String contents, String password) {
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.password = password;
    }

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto requestDto) {
        this.title= requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
}
