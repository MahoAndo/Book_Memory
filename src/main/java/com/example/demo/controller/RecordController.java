
package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.BookRecord;
import com.example.demo.service.BookRecordService;
import com.example.demo.service.CsvService;

/**
 * RecordController
 * @author maho ando
 * @date Oct 15 2022
 */
@Controller
public class RecordController{
    @Autowired
    private BookRecordService bookRecordService;
    @Autowired
    private CsvService csvService;
    @Autowired
    private RecordDetailController recordDetailController;
    	
    /**
	 * Get record
	 * @param result (0: update / 1: create / 2: delete / 3: fail / null: back)
	 * @param model
	 * @return record
	 */
	@GetMapping("/book/record")
	public String recordList(@RequestParam(name = "userNo") Integer userNo, 
							 @RequestParam(name = "result", required = false) Integer result, Model model) {
		//get a book record list
		List<BookRecord> recordLsit = bookRecordService.getBookRecordList(userNo);
		
		model.addAttribute("userNo", userNo);
		model.addAttribute("recordLsit", recordLsit);
		
		if(result != null)
			model.addAttribute("result", result);
		
		return "book/record";
	}
	
	
	/**
	 * Request record
	 * @param userNo
	 * @param pageType (0: back / 1: insert / 2: csv)
	 * @param model
	 * @return record
	 */
	@PostMapping("/book/record")
	public String openPrint(@RequestParam(name = "userNo") Integer userNo, 
							@RequestParam(name = "pageType") Integer pageType, 
							HttpServletResponse response, Model model) throws IOException {
		String retrunString = "";
		
		switch (pageType) {
			case 0:
				// back to login page
				retrunString = "redirect:/user/select/?userNo=" + userNo;
				break;
				
			case 1:
				//create New
				retrunString = recordDetailController.recordDetail(userNo, 0, model);
				break;
				
			case 2:
				//get a book note list
				List<BookRecord> recordLsit = bookRecordService.getBookRecordList(userNo);
				
				// make csv file
				csvService.makeRecordCsvFile(response, recordLsit);
				
				model.addAttribute("userNo", userNo);
				model.addAttribute("recordLsit", recordLsit);
				
				retrunString = "book/record";
				break;
				
			default:
				break;
		}
		
		return retrunString;
	}
}