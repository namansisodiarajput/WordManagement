package com.slice.wordmanagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "words")
public class Words {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "word")
	private String word;
	
	@Column(name = "count")
	private Integer count = 0;
}
