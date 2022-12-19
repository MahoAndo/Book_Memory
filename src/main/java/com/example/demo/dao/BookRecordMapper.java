package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.BookRecord;

/**
 * BookRecordMapper
 * @author maho ando
 * @date Oct 15 2022
 */
@Mapper
public interface BookRecordMapper{
	
	/**
	 * get book record List
	 * @param userNo
	 * @return BookRecord list
	 */
	public List<BookRecord> getBookRecordList(Integer userNo);

	/**
	 * get a record by userNo
	 * @param recordNo
	 * @return BookRecord
	 */
	public BookRecord getBookRecord(Integer recordNo);
	
	/**
	 * insert book record
	 * @param bookRecord
	 */
	public void insertNewRecord(BookRecord bookRecord);
	
	/**
	 *  update a record
	 *  @param bookRecord
	 */
	public void updateRecord(BookRecord bookRecord);
	
	/**
	 *  delete a record
	 *  @param recordNo
	 */
	public void deleteRecord(Integer recordNo);
}