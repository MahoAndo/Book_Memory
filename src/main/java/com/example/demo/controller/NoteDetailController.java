
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.BookNote;
import com.example.demo.service.BookNoteService;

/**
 * NoteDetailController
 * @author maho ando
 * @date Dec 5 2022
 */
@Controller
public class NoteDetailController{
    @Autowired
    private BookNoteService bookNoteService;

	/**
	 * Get noteDetail
	 * @param userNo
	 * @param noteNo 
	 * @param model 
	 * @return noteDetail
	 */
    @GetMapping("/book/note/noteDetail")
	public String noteDetail( @RequestParam(name = "userNo") Integer userNo,
								@RequestParam(name = "noteNo") Integer noteNo, Model model) {
		//create new note
		if(noteNo != 0) {
			BookNote bookNote = bookNoteService.getBookNote(noteNo);
			model.addAttribute("bookNote", bookNote);
			
		}else {
			//edit a record
			model.addAttribute("bookNote", new BookNote());		
		}
		model.addAttribute("userNo", userNo);
		model.addAttribute("noteNo", noteNo);
		
		return "book/noteDetail";
	}
	
	/**
	 * Request noteDetail
	 * @param noteNo (0: insert / 1: update)
	 * @param userNo
	 * @param pageType (0: back / 1: insert or update / 2: delete)
	 * @param model 
	 * @return noteDetail page 
	 * 
	 */
    @PostMapping("/book/noteDetail")
	public String getNoteRecordNew( @RequestParam(name = "noteNo", required = false) Integer noteNo,
									@RequestParam(name = "userNo") Integer userNo,
									@RequestParam(name = "pageType") Integer pageType,
								    @ModelAttribute BookNote bookNote, Model model) {
		
		int result = 0;	 // for returning message
		
		try {
				// each button process
				switch (pageType) {
					case 1:
						if(noteNo != 0) {
							//update
							bookNoteService.updateNewNote(bookNote);
						}
						else {
							//insert
							bookNoteService.insertNewNote(bookNote);
							result = 1;
						}
						break;
						
					case 2:
						//delete
						bookNoteService.deleteNote(noteNo);
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
			return 	"redirect:note/?userNo=" + userNo + "&result=" + result;
		else 
			// back
			return 	"redirect:note/?userNo=" + userNo;
	}
	
}