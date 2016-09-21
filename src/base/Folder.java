package base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Folder implements Comparable<Folder>{

	private ArrayList<Note> notes;
	private String name;
	
	public Folder(String name){
		this.name = name;
		notes =  new ArrayList<Note>();
	}
	
	public void addNote(Note note){
		if(note != null){
			notes.add(note);
		}
		else {
			return;
		}
	}
	
	public String getName(){
		return name;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}

	@Override
	public String toString() {
		int nText = 0;
		int nImage = 0;
		
		for(Note n : notes){
			if(n instanceof TextNote){
				nText++;
			}
			if(n instanceof ImageNote){
				nImage++;
			}
		}
		
		return name + ":" + nText + ":" + nImage;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int compareTo(Folder o) {
		return this.name.compareTo(o.name);
	}
	
	public void sortNotes(){
		Collections.sort(notes);
	}
	
	public List<Note> searchNotes(String keywords){
		List<Note> n = new ArrayList<Note>();
		for(Note note : notes){
			if(note.seacrKeyword(keywords)){
				n.add(note);
			}
		}
		
		return n;
	}
	

}
