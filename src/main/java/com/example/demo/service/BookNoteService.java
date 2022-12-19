package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookNoteMapper;
import com.example.demo.entity.BookNote;

/**
 *  BookService
 *	@author maho
 */
@Service
public class BookNoteService {
	
	@Autowired
	private BookNoteMapper bookNoteMapper;
	@Autowired
	private DateService dateService;
	/**
	 * getting BookNote List by userId
	 * @retrun BookNote List 
	 */
	public List<BookNote> getBookNoteList(int userNo) {
		return bookNoteMapper.getBookNoteList(userNo);
	}
	
	/**
	 * get book note info
	 */
	public BookNote getBookNote(Integer noteNo) {
		return bookNoteMapper.getBookNote(noteNo);	
	}
	
	/**
	 * insert book note
	 */
	public void insertNewNote(BookNote booknote) {
		//get now date by type Date
		booknote.setInputDate(dateService.getNowDate());
		
		//insert 
		bookNoteMapper.insertNewNote(booknote);
	}
	
	/**
	 * update book note
	 */
	public void updateNewNote(BookNote booknote) {
		//get now date by type Date
		booknote.setInputDate(dateService.getNowDate());
		//update
		bookNoteMapper.updateNote(booknote);
	}
	
	/**
	 * delete book note
	 */
	public void deleteNote(Integer noteNo) {
		//delete
		bookNoteMapper.deleteNote(noteNo);
	}
	
}