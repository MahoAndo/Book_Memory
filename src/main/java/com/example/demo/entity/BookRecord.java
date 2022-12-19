package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * BookRecord
 * @author maho ando
 * @date Oct 15 2022
 */
@Data 
@Getter
@Setter
public class BookRecord{
	
	/** record no */	private int recordNo;
	/** user no */		private int userNo;
	/** title */		private String title;
	/** author */		private String author;
	/** start date */	private String startDate;
	/** finish date */	private String endDate;
	/** input date */	private String inputDate;
	/** status */		private int status;
	/** statusName */	private String statusName;
	/** memo */			private String memo;

	public BookRecord() {

	}
	
	public BookRecord(
			int recordNo,
			int userNo,
			String title,
			String author,
			String startDate,
			String endDate,
			String inputDate,
			int status,
			String statusName,
			String memo
			) 
		{
			this.recordNo = recordNo;
			this.userNo = userNo;
			this.title = title;
			this.author = author;
			this.startDate = startDate;
			this.endDate = endDate;
			this.inputDate = inputDate;
			this.status = status;
			this.statusName = statusName;
			this.memo = memo;
		}
}