package base;

import java.io.File;

public class ImageNote extends Note{
	private File image;
	
	public ImageNote(String title){
		super(title);
		
	}

	

	@Override
	public boolean containKeywords(String[] wds) {
		for(String wd : wds){
			String t = getTitle();
			if(t.toLowerCase().contains(wd)){
				return true;
			}
		}
		return false;
	}

}
