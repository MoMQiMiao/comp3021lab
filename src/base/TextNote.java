package base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import apple.laf.JRSUIState.TitleBarHeightState;


public class TextNote extends Note {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;
	
	public TextNote(String title){
		super(title);
	}
	
	public TextNote(String title, String content){
		super(title);
		this.content = content;
	}

	public TextNote(File file){
		super(file.getName());
		this.content = getTextFromFile(file.getAbsolutePath());
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
	
	public String getTextFromFile(String absolutePath){
		String result = "";
		File file = new File(absolutePath);
		BufferedReader br = null;
		try {
			 br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			while((line = br.readLine()) != null){
				result = result + line;
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void exportTextToFile(String pathFolder){
		String title = this.getTitle();
		title = title.replaceAll(" ", "_");
		File f = new File(pathFolder + title + ".txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
