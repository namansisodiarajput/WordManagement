package com.slice.wordmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.slice.wordmanagement.service.WordsManagementService;

@RestController
@RequestMapping("/word")
public class WordManagementController {
	
	@Autowired
	private WordsManagementService wordManagementService;
	
	@PutMapping("/{word}")
    public void addWord(@PathVariable(name = "word" , required = true) String word) {
     	 
		wordManagementService.addWord(word);
    }
	
	@GetMapping("/{word}")
    public Integer getWord(@PathVariable(name = "word" , required = true) String word) {
     	 
		return wordManagementService.getWord(word);
    }

}
