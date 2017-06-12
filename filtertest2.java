package ioDome;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class filtertest2 {
public static void main(String[] args) {
	final String s="txt";
	File f=new File("D:\\learn\\file");
	for(String si:f.list())
		System.out.println(si);
	System.out.println("____________");
		String[] str=f.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				Pattern p=Pattern.compile(s);
				return name.contains(s);
			}
		});
		for(String st:str){
			System.out.println(st);
		}
		System.out.println(Pattern.compile("s").matcher("stst").find());
}
}
