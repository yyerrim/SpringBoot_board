package com.example.board.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

// 스프링이 원래 알고 있는 객체면 dev tools 서버 재시작을 할 때 세션의 값을 다시 입력해줌
// User는 스프링이 원래 알고 있는 객체가 아님 ===> 서버 재시작되면 로그인 풀림
// Serializable을 상속시켜주면 모르는 객체라도 서버가 재시작될때 세션에 있는 값을 다시 입력해줌
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String email;
	private String pwd;
	private String name;
}