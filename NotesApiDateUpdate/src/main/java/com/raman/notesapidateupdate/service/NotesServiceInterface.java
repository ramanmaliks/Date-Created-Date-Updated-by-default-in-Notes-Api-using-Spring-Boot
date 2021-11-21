package com.raman.notesapidateupdate.service;

import java.util.List;

import com.raman.notesapidateupdate.entity.Notes;

public interface NotesServiceInterface {

	public Notes addNote(Notes notes);

	public List<Notes> getAllNotes();

	public Notes getNote(Long noteId);

	public void delNote(Notes note1);

}
