package com.raman.notesapidateupdate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raman.notesapidateupdate.entity.Notes;
import com.raman.notesapidateupdate.exception.ResourceNotFoundException;
import com.raman.notesapidateupdate.repository.NotesRepository;

@Service
public class NotesService implements NotesServiceInterface{
	
	@Autowired
	NotesRepository notesRepository;

	@Override
	public Notes addNote(Notes notes) {
		return notesRepository.save(notes);
		
	}

	@Override
	public List<Notes> getAllNotes() {	
		return notesRepository.findAll();
	}

	@Override
	public Notes getNote(Long noteId) {
		return notesRepository.findById(noteId)
				.orElseThrow(()-> new ResourceNotFoundException("Note","id",noteId));
	}


	@Override
	public void delNote(Notes note1) {
		notesRepository.delete(note1);
		
	}
	
	
}
