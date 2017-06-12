package ioDome;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class filtertest {
public static FilenameFilter fileFilter(final String s){
	return new FilenameFilter() {
		Pattern p=Pattern.compile(s);
		public boolean accept(File dir, String name) {
			return p.matcher(name).find();
		}
	};
}  
public static void main(String[] args){
	File f=new File("D:\\learn\\file");
	for(String s:f.list())
		System.out.println(s);
	System.out.println("____________");
		String[] str=f.list(fileFilter(".txt"));
		for(String s:str){
			System.out.println(s);
		}
}
}
