
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.BookRecord;
import com.example.demo.service.BookRecordService;

/**
 * RecordDetailController
 * @author maho ando
 * @date Oct 15 2022
 */
@Controller
public class RecordDetailController{
    @Autowired
    private BookRecordService bookRecordService;
    
	/**
	 * Get recordDetail
	 * @param userNo 
	 * @param recordNo 
	 * @param model 
	 * @return recordDetail
	 */
	@GetMapping("/book/record/recordDetail")
	public String recordDetail( @RequestParam(name = "userNo") Integer userNo,
								@RequestParam(name = "recordNo") Integer recordNo, Model model) {
		//create new record
		if(recordNo != 0) {
			BookRecord bookRecord = bookRecordService.getBookRecord(recordNo);
			model.addAttribute("bookRecord", bookRecord);
		
		}else {
			//edit a record
			model.addAttribute("bookRecord", new BookRecord());		
		}
		model.addAttribute("userNo", userNo);
		model.addAttribute("recordNo", recordNo);
		
		return "book/recordDetail";
	}
	
	
	
	/**
	 * Request recordDetail
	 * @param recordNo (0: insert / 1: update)
	 * @param userNo
	 * @param pageType (0: back / 1: insert or update / 2: delete)
	 * @param model
	 * @return recordDetail page
	 */
	@PostMapping("/book/recordDetail")
	public String recordButtonProcess(@RequestParam(name = "recordNo", required = false) Integer recordNo,
									  @RequestParam(name = "userNo") Integer userNo,
									  @RequestParam(name = "pageType") Integer pageType,
									  @ModelAttribute BookRecord bookRecord, Model model) {
		
		int result = 0;	 // for returning message
		
		try {
				// each button process
				switch (pageType) 
				{
					case 1:
						if(recordNo != 0) {
							//update
							bookRecordService.updateNewRecord(bookRecord);
						}
						else {
							//insert
							bookRecordService.insertNewRecord(bookRecord);
							result = 1;
						}
						break;
						
					case 2:
						//delete
						bookRecordService.deleteRecord(recordNo);
						result = 2;
						break;
						
					default:
						break;
				}

		} catch (Exception e) {
			
			result = 3;
			
		}finally {
			
			model.addAttribute("userNo", userNo);
			model.addAttribute("result", result);
		}
		
		if(pageType != 0)  
			//create & update & delete
			return 	"redirect:record/?userNo=" + userNo + "&result=" + result;
		else 
			// back
			return 	"redirect:record/?userNo=" + userNo;
	}
}