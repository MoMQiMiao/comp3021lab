package base;

public class TextNote extends Note {

	private String content;
	
	public TextNote(String title){
		super(title);
	}
	
	public TextNote(String title, String content){
		super(title);
		this.content = content;
	}


	@Override
	public boolean containKeywords(String[] wds) {
		for(String wd : wds){
			if(getTitle().toLowerCase().contains(wd) || content.toLowerCase().contains(wd)){
				return true;
			}
		}
		return false;
	}
}
