package com.slice.wordmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.slice.wordmanagement.domain.Words;

public interface WordsRepo extends JpaRepository<Words , Integer> {
	
	Words findByWord(String word);

}
