package ioDome;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintStream;

public class Date {
public static void main(String[] args) {
	try {
		DataOutputStream ds=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\1.java")));
		ds.writeBytes("haha java so hard");
	//	PrintStream ps=new PrintStream(new OutputStream());
		DataInputStream di=new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\test.class")));
		System.out.println(di.readLine());
		ds.close();
	} catch (FileNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
}
}
