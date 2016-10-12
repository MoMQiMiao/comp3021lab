package base;

import java.io.Serializable;
import java.util.Date;


public abstract class Note implements Comparable<Note>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private String title;
	
	public Note(String title) {
		this.title = title;
		this.date = new Date(System.currentTimeMillis());
	}
	
	public String getTitle(){
		return this.title;
		
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public int compareTo(Note o) {
		if(o.date.after(this.date)){
			return 1;
		}
		else if(o.date.after(this.date)){
			return -1;
		}
		return 0;
	}
	
	public abstract boolean containKeywords(String[] wds);
	
	public boolean seacrKeyword(String keywords){
		String kyd = keywords.toLowerCase();
		String[] kydlist = kyd.split(" ");
		boolean contain = false;
		for(int i = 0; i < kydlist.length; i++){
			String[] word = {kydlist[i]};
//			if(word.equals("or") && i != 0){
//				String[] wds = {kydlist[i-1], kydlist[i+1]}; 
//				if(!this.containKeywords(wds)){
//					contain = false;
//					return contain;
//				}
//			}
			
			if(this.containKeywords(word)){
				return true;
			}
		}
		
		return contain;
	}
	
	@Override
	public String toString(){
		return date.toString() + "\t" + title;
	}

}
