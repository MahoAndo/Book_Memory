package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.BookNote;

/**
 * BookNoteMapper
 * @author maho ando
 * @date Oct 15 2022
 */
@Mapper
public interface BookNoteMapper{
	/**
	 * get book note list
	 * @param userNo
	 * @return BookNote list
	 */
	public List<BookNote> getBookNoteList(Integer userNo);
	
	/**
	 * get a note by userNo
	 * @param noteNo
	 * @return BookNote
	 */
	public BookNote getBookNote(Integer noteNo);
	
	/**
	 * insert book note
	 * @param bookNote
	 */
	public void insertNewNote(BookNote bookNote);
	
	/**
	 * update book note
	 * @param bookNote
	 */
	public void updateNote(BookNote bookNote);
	
	/**
	 * delete book note
	 * @param noteNo
	 */
	public void deleteNote(Integer noteNo);
}