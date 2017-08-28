package ioDome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
//压缩文件
public class zipCompres {
public static void main(String[] args) {
	try {
		FileOutputStream fo=new FileOutputStream("d://learn//file//txt.zip");
		CheckedOutputStream cs=new CheckedOutputStream(fo, new Adler32());
		ZipOutputStream zs=new ZipOutputStream(cs);
		zs.setComment("我的压缩包");
		File f=new File("d://learn//file");
		File[] fi=f.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File fi, String name) {
				// TODO 自动生成的方法存根
				return name.indexOf(".txt")!=-1;
			}
		});
//		BufferedWriter bw=new BufferedWriter(new FileWriter(new File("d://learn//file//zip.txt")));
//		BufferedReader bre=new BufferedReader(new FileReader("d://learn//file//a.txt"));
//		FileInputStream bre=new FileInputStream("d://learn//file//a.txt");
		for(int x=0;x<fi.length;x++){
//			System.out.println(x);
			FileInputStream br=new FileInputStream(fi[x]);
			zs.putNextEntry(new ZipEntry(fi[x].getName()));
			int y=0;
			byte[] arr=new byte[1024];
			//System.out.println("b");
			while((y=br.read(arr))!=-1){
//				System.out.println(arr);
//				System.out.println(fi[x]);
				zs.write(arr,0,y);
			}
			br.close();
		}
		zs.close();
		System.out.println("reading");
		System.out.println("checksum"+cs.getChecksum().getValue());
		FileInputStream fs=new FileInputStream("d://learn//file//txt.zip");
		CheckedInputStream ci=new CheckedInputStream(fs, new Adler32());
		ZipInputStream zsi=new ZipInputStream(ci);
		ZipEntry ze;
		System.out.println("checksum"+ci.getChecksum().getValue());
		while((ze=zsi.getNextEntry())!=null){
			System.out.println(ze);
			int x=0;
			while((x=zsi.read())!=-1){
				System.out.println(x);
			}
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
