package com.sparta.board2.service;

import com.sparta.board2.domain.Board;
import com.sparta.board2.dto.BoardCheckRequestDto;
import com.sparta.board2.dto.BoardRequestDto;
import com.sparta.board2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@RequiredArgsConstructor /* final 이 붙거나 @Not Null 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션*/
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    /**
     * 아이디 확인
     * @param id
     * @param requestDto
     */
    /* 스프링은 @Transactional 어노테이션을 이용한 선언적 트랜잭션 처리를 지원한다. 클래스나 메서드에 @Transactional을 붙여줄 경우
    해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다. */
    @Transactional
    public void update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    /**
     * 비밀번호 확인
     * @param id
     * @param requestDto
     * @return
     */
     /* 스프링은 @Transactional 어노테이션을 이용한 선언적 트랜잭션 처리를 지원한다. 클래스나 메서드에 @Transactional을 붙여줄 경우
    해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다. */
    @Transactional
    public boolean passwordCheck(Long id, BoardCheckRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는 글입니다.")
        );

        return board.getPassword().equals(requestDto.getPassword());
    }
}
