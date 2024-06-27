package com.example.board.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Data

@ToString(exclude = {"fileInfos", "comments"})

public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String content;
	private String userId;

	@OneToMany(mappedBy = "board")
	// @OneToMany(mappedBy = "board", orphanRemoval = true, cascade = CascadeType.REMOVE)
	// // Board가 삭제되면서 나를 외래키로 쓰고 있는 녀석들아 다 삭제되거라 라는 명령어
	// // 쫌 과격한 방법임
	List<FileInfo> fileInfos = new ArrayList<>();
	// Thymeleaf는 LAZY 신경안써도됨

	@OneToMany(mappedBy = "board", orphanRemoval = true, cascade = CascadeType.REMOVE)
	List<Comment> comments = new ArrayList<>();
}