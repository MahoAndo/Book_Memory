
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

import com.example.demo.entity.BookNote;
import com.example.demo.service.BookNoteService;
import com.example.demo.service.CsvService;

/**
 * NoteController
 * @author maho ando
 * @date Oct 15 2022
 */
@Controller
public class NoteController{
    @Autowired
    private BookNoteService bookNoteService;
    @Autowired
    private CsvService csvService;
    @Autowired
    private NoteDetailController noteDetailController;
    	
    /**
	 * Get note
	 * @param result (0: update / 1: create / 2: delete / 3: fail / null: back)
	 * @param model 
	 * @return book note
	 */
    @GetMapping("/book/note")
	public String noteList( @RequestParam(name = "userNo") Integer userNo, 
							@RequestParam(name = "result", required = false) Integer result, Model model) {
		//get a book note list
		List<BookNote> noteList = bookNoteService.getBookNoteList(userNo);
		
		model.addAttribute("userNo", userNo);
		model.addAttribute("noteLsit", noteList);
		
		if(result != null)
			model.addAttribute("result", result);
		
		return "book/note";
	}
	
	
	/**
	 * Request note
	 * @param userNo
	 * @param pageType (0: back / 1: insert / 2: csv)
	 * @param model
	 * @return recordDetail page
	 */
    @PostMapping("/book/note")
	public String openPrint(@RequestParam(name = "userNo") Integer userNo,
							@RequestParam(name = "pageType") Integer pageType,
							HttpServletResponse response, Model model) throws IOException{
		String retrunString = "";
		switch (pageType) {
			case 0:
				// back to login page
				retrunString = "redirect:/user/select/?userNo=" + userNo;
				break;
				
			case 1:
				//create New
				retrunString = noteDetailController.noteDetail(userNo, 0, model);
				break;
				
			case 2:
				//get a book note list
				List<BookNote> noteList = bookNoteService.getBookNoteList(userNo);
				
				// make csv file
				csvService.makeNoteCsvFile(response, noteList);
				
				model.addAttribute("userNo", userNo);
				model.addAttribute("noteLsit", noteList);
				
				retrunString = "book/note";
				break;
				
			default:
				break;
		}
		
		return retrunString;
	}
}