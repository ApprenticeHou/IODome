package ioDome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSExecuteDome {
public static void main(String[] args) {
	OSExcute.command("javap C:\\Users\\DELL\\workspace\\hou\\src\\ioDome\\OSExecuteDome.class");
}
}
class OSExcute{
	public static void command(String s){
		boolean b=false;
		try {
			Process p=new ProcessBuilder(s.split(" ")).start();
			BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
			String ss;
			while((ss=br.readLine())!=null){
				System.out.println(ss);
			}
			BufferedReader errors=new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while((ss=errors.readLine())!=null){
				System.err.println(ss);
				b=true;
			}
		} catch (IOException e) {
			if(s.startsWith("CMD/C")){
				s="CMD/c"+s;
			}
			else 
				throw new RuntimeException();
			
		}
		if(b){
//				throw new RuntimeException("Errors"+s);
			}
	}
}
