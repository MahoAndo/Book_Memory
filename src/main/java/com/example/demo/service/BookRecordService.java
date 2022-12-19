package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookRecordMapper;
import com.example.demo.entity.BookRecord;

/**
 *  BookService
 *	@author maho
 */
@Service
public class BookRecordService {

	@Autowired
	private BookRecordMapper bookRecordMapper;
	@Autowired
	private DateService dateService;
	
	/**
	 * getting BookRecord List by userId
	 * @retrun BookRecord List 
	 */
	public List<BookRecord> getBookRecordList(int userNo) {
		
		List<BookRecord> recordList = bookRecordMapper.getBookRecordList(userNo);

		//set status name for showing status on record list
		for(BookRecord status : recordList) {
			switch (status.getStatus()) {
			case 1:
				status.setStatusName(CorderConstance.STATUS_1);
				break;
			case 2:
				status.setStatusName(CorderConstance.STATUS_2);
				break;
			case 3:
				status.setStatusName(CorderConstance.STATUS_3);
				break;
			default:
				break;
			}
		}
		return recordList;
	}	
	
	/**
	 * get book record info
	 * @param recordNo
	 */
	public BookRecord getBookRecord(Integer recordNo) {
		return bookRecordMapper.getBookRecord(recordNo);	
	}
	
	/**
	 * insert new book record
	 */
	public void insertNewRecord(BookRecord bookRecord) {
		//get now date by type Date
		bookRecord.setInputDate(dateService.getNowDate());
		//insert
		bookRecordMapper.insertNewRecord(bookRecord);
	}
	
	/**
	 * update book record
	 */
	public void updateNewRecord(BookRecord bookRecord) {
		//get now date by type Date
		bookRecord.setInputDate(dateService.getNowDate());
		//update
		bookRecordMapper.updateRecord(bookRecord);
	}
	
	/**
	 * insert new book record
	 */
	public void deleteRecord(Integer recordNo) {
		//delete
		bookRecordMapper.deleteRecord(recordNo);
	}
}