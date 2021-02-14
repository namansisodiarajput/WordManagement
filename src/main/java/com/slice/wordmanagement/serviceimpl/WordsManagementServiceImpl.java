package com.slice.wordmanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.slice.wordmanagement.constants.ErrorConstants;
import com.slice.wordmanagement.domain.Words;
import com.slice.wordmanagement.exceptions.BadRequestException;
import com.slice.wordmanagement.repository.WordsRepo;
import com.slice.wordmanagement.service.WordsManagementService;

@Service
public class WordsManagementServiceImpl implements WordsManagementService {
	
	@Autowired
	private WordsRepo wordsRepo;
	
	@Override
	public void addWord(String word) {
		if(word.isEmpty() || word.length() < 1) {
			throw new BadRequestException(ErrorConstants.WORD_EMPTY);
		}
		
		//either word exist or need to create one
		Words newWord = wordsRepo.findByWord(word);
		if(newWord == null) {
			newWord = new Words();
			newWord.setWord(word);
		}
		newWord.setCount(newWord.getCount() + 1);
		wordsRepo.save(newWord);
	}
	
	@Override
	public Integer getWord(String word) {
		Words existingWord = wordsRepo.findByWord(word);
		if(existingWord == null) {
			return 0;
		}
		return existingWord.getCount();
	}

}
