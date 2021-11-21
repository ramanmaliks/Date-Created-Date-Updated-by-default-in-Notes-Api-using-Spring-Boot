package com.raman.notesapidateupdate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raman.notesapidateupdate.entity.Notes;
import com.raman.notesapidateupdate.service.NotesServiceInterface;

@RestController
@RequestMapping("/api")
public class NoteController {


	
	@Autowired
	private NotesServiceInterface notesServiceInterface;

	@RequestMapping(value = "/notes", method =RequestMethod.GET)
	public ResponseEntity<List<Notes>> getAllNotes(){
		return new ResponseEntity<List<Notes>>(notesServiceInterface.getAllNotes(),HttpStatus.OK);
	}

	@RequestMapping(value = "/notes", method =RequestMethod.POST)
	public ResponseEntity<Notes> addNote(@Valid @RequestBody Notes notes){
		Notes newNotes= notesServiceInterface.addNote(notes);
		return new ResponseEntity<Notes>(newNotes,HttpStatus.OK);
	}

	@RequestMapping(value = "/notes/{id}", method =RequestMethod.GET)
	public ResponseEntity<Notes> getNote(@PathVariable(value="id") Long noteId){
		Notes newNotes= notesServiceInterface.getNote(noteId);
		return new ResponseEntity<Notes>(newNotes,HttpStatus.OK);
	}
	
	  @RequestMapping(value = "/notes/{id}", method =RequestMethod.PUT) 
	  public ResponseEntity<Notes> updateNote(@PathVariable(value="id") Long noteId, @Valid @RequestBody Notes notes)
	  { 		  	
		  Notes note1 = notesServiceInterface.getNote(noteId);
		  note1.setTitle(notes.getTitle());
		  note1.setContent(notes.getContent());
		  Notes newNotes= notesServiceInterface.addNote(note1);
			return new ResponseEntity<Notes>(newNotes,HttpStatus.OK);
	  }
	  
	 @RequestMapping(value="/notes/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<?> delNote(@PathVariable(value="id") Long noteId)
	 {
		 Notes note1 = notesServiceInterface.getNote(noteId);
		 
		 notesServiceInterface.delNote(note1);
		 return ResponseEntity.ok().build();
	 }
	
}
