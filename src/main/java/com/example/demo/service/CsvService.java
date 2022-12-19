package com.example.demo.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BookNote;
import com.example.demo.entity.BookRecord;

/**
 *  CsvService
 *	@author maho
 *  @date Nov 6 2022
 */
@Service
public class CsvService {

	/**
	 * make a csv file of book note
	 * @param response
	 *  @param noteList
	 */	  
	public void makeNoteCsvFile(HttpServletResponse response, List<BookNote> noteList){
		// Set character encoding and output CSV file name
        response.setContentType(CorderConstance.TYPE_UTIL + CorderConstance.CHARACTER);
        response.setHeader("Content-Disposition", "attachment; filename=\"BookNote.csv\"");

        try (PrintWriter pw = response.getWriter()) {
        	
        	//column
        	String column = "NO" + "," + 
        					"TITLE" + "," + 
        					"MEMO" + "," + 
        					"INPUT DATE" + CorderConstance.NEW_LINE;
        	
        	// Write to CSV file (column)
            pw.print(column);
            
        	// get note data
            for (int i = 0; i < noteList.size(); i++) {
            	
            	Integer no = i + 1;
                String title = noteList.get(i).getTitle();
                String memo = noteList.get(i).getMemo();
                String inputDate = noteList.get(i).getInputDate();

                
                String data = no + "," +
                			  title + "," + 
                			  memo +  "," + 
                			  inputDate + CorderConstance.NEW_LINE;

                // Write to CSV file (data)
                pw.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * make a csv file of book record
	 * @param response
	 * @param recordList
	 */	  
	public void makeRecordCsvFile(HttpServletResponse response, List<BookRecord> recordList){
		// Set character encoding and output CSV file name
		response.setContentType(CorderConstance.TYPE_UTIL + CorderConstance.CHARACTER);
        response.setHeader("Content-Disposition", "attachment; filename=\"BookRecord.csv\"");

        try (PrintWriter pw = response.getWriter()) {
        	
        	//column
            String column = "NO" + "," + 
            				"TITLE" + "," + 
            				"AUTHOR" + "," + 
            				"STATUS" + "," + 
            				"START DATE" + "," + 
            				"END DATE" + "," + 
            				"MEMO" + "," + 
        					"INPUT DATE" + CorderConstance.NEW_LINE;
            				
            
            // Write to CSV file (column)
            pw.print(column);
            
        	// get record data
            for (int i = 0; i < recordList.size(); i++) {
            	
            	Integer no = i + 1;
                String title = recordList.get(i).getTitle();
                String author = recordList.get(i).getAuthor();
                String statusName = getStatusName(recordList.get(i).getStatus());
                String startDate = recordList.get(i).getStartDate();
                String endDate = recordList.get(i).getEndDate();
                String memo = recordList.get(i).getMemo();
                String inputDate = recordList.get(i).getInputDate();
                
                String data = 	no + "," + 
                				title + "," + 
        						author + "," + 
        						statusName + "," + 
        						startDate + "," + 
        						endDate + "," +
        						memo + "," +
        						inputDate + CorderConstance.NEW_LINE;

                // Write to CSV file (data)
                pw.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * getStatusName
	 * @param status
	 * @return statusName
	 */
	public String getStatusName(Integer status) {
	String statusName = "";
	
	switch (status) {
		case 1:
			statusName =  CorderConstance.STATUS_1;
			break;
		case 2:
			statusName =  CorderConstance.STATUS_2;
			break;
		case 3:
			statusName =  CorderConstance.STATUS_3;
			break;
		default:
			break;
	}
		return statusName;
	}
}