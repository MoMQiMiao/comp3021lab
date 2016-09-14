package base;

import java.util.ArrayList;

public class NoteBook {

	private ArrayList<Folder> folders;
	
	public NoteBook(){
		this.folders = new ArrayList<Folder>();
	}
	
	public boolean createTextNote(String folderName, String title){
		TextNote note = new TextNote(title);
		return insertNote(folderName, note);
		
	}
	
	public boolean createImageNote(String folderName, String title){
		ImageNote note = new ImageNote(title);
		return insertNote(folderName, note);
		
	}
	

	public ArrayList<Folder> getFolders() {
		return folders;
	}

	private boolean insertNote(String folderName, Note note){
		Folder folder = null;
		for(Folder f : folders){
			if(f.getName().equals(folderName)){
				folder = f;
			}
		}
		
		if(folder == null){
			Folder folder2 = new Folder(folderName);
			folders.add(folder2);
			folder = folder2;
		}
		
		for(Note n : folder.getNotes()){
			if(n.equals(note)){
				System.out.println("Creating note " + note.getTitle() + " under folder " + folderName + " failed");
				return false;
			}
		}
		
		folder.addNote(note);
		return true;
		
	}
}
