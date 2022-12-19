package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * BookNote
 * @author maho ando
 * @date Oct 15 2022
 */
@Data
@Getter
@Setter
public class BookNote{

	/** noteNo */		private int noteNo;
	/** userNo */		private int userNo;
	/** title */		private String title;
	/** memo */			private String memo;
	/** inputDate */	private String inputDate;
	
	public BookNote() {

	}
	
	public BookNote(
			int noteNo,
			int userNo,
			String title,
			String memo,
			String inputDate
			) 
		{
			this.noteNo = noteNo;
			this.userNo = userNo;
			this.title = title;
			this.memo = memo;
			this.inputDate = inputDate;
		}
}