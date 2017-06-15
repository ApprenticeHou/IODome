package ioDome;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class zip {
public static void main(String[] args) {
	try {
		FileInputStream br=new FileInputStream("D:\\learn\\file\\text\\haha.png");
		BufferedOutputStream bo=new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("D:\\learn\\file\\text\\haha.bnp.gz")));
		int x=0;
		while((x=br.read())!=-1){
			bo.write(x);
		}
		br.close();
		bo.close();
		GZIPInputStream bi=new GZIPInputStream(new FileInputStream("D:\\learn\\file\\text\\haha.bnp.gz"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\learn\\file\\text\\ha.png"));
		int y=0;
		while((x=bi.read())!=-1){
			bw.write(x);
	}
	} catch (FileNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
}
}
