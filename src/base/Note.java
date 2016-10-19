package base;

import java.io.Serializable;
import java.util.ArrayList;
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
		boolean contain = true;
		int i= 0;
		while(i < kydlist.length){
			
			String word = kydlist[i];
			if(kydlist.length == 1){
				String[] wds = {kydlist[0]};
				if (!this.containKeywords(wds)) {
					contain = false;
					return contain;
				}
				else{
					return true;
				}
			}
			if(i+1 < kydlist.length){
				if(!kydlist[i+1].equals("or")){
					String[] wds = {kydlist[i]};
					if (!this.containKeywords(wds)) {
						contain = false;
						return contain;
					}
					i++;
				}
				else{
					ArrayList<String> wds = new ArrayList<>();
					wds.add(word);
					int j = i+1;
					while(j < kydlist.length){
						if(!kydlist[j].equals("or")){
							break;							
						}
						wds.add(kydlist[j+1]);
						j = j + 2;
					}
					i = j;
					String[] a = new String[wds.size()];
					wds.toArray(a);
					if (!this.containKeywords(a)) {
						contain = false;
						return contain;
					}
				}
			}
		}
		return contain;
	}
	
	@Override
	public String toString(){
		return date.toString() + "\t" + title;
	}

}
