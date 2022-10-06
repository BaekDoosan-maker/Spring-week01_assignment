package com.sparta.board2;
import com.sparta.board2.domain.Board;
import com.sparta.board2.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing /*Spring Audit 기능을 활용하기 위해 우선 @EnableJpaAuditing 어노테이션을 추가한다. */
@SpringBootApplication
public class Board2Application {
    public static void main(String[] args) {
        SpringApplication.run(Board2Application.class, args);
    }

    /**
     *  게시글 초기값 세팅용 Bean 객체 생성
     * @param boardRepository
     * @return
     */
    @Bean /* 개발자가 작성한 Method를 통해 반환되는 객체를 Bean으로 만드는것이다. Bean은 Spring IoC Container가 관리하는 자바 객체다.*/
    public CommandLineRunner demo(BoardRepository boardRepository) { /*CommandLineRunner : 스프링부트 애플리케이션 시작될때 특정 코드를 실행 시킬때 사용한다. */
        return (args) -> {
          boardRepository.save(new Board("게시글제목","백두산","게시글내용","1234"));
        };
    }
}