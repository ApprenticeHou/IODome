package ioDome;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class mapedIO {
private static int in=1024*10;
public static abstract class Tester{
	private String name;
	public Tester(String name){
		this.name=name;
	}
	public  void runtest() throws IOException{
		double l=System.nanoTime();
		test();
		l=(System.nanoTime()-l)/10e6;
		System.out.println(name+"时间:"+l);
	}
	public void test() throws IOException {
		// TODO 自动生成的方法存根
		
	}
}
private static Tester[] test={
		new Tester("Stream write"){
			public void test() throws IOException {
				// TODO 自动生成的方法存根
				DataOutputStream ds=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("D:\\learn\\file\\haha.txt"))));
				for(int i=0;i<in;i++){
					ds.writeInt(i);
//					ds.writeUTF(String(i));
				}
				ds.close();
			}
		},
		new Tester("mapped write"){
			public void test() throws IOException {
				// TODO 自动生成的方法存根
				FileChannel f=new RandomAccessFile("haha.txt","rw").getChannel();
				IntBuffer ib=f.map(FileChannel.MapMode.READ_WRITE, 0,in).asIntBuffer();
				for(int i=0;i<in/4;i++){
					ib.put(i);
				}
				f.close();;
			}
		} ,
		new Tester("Stream read"){
			public void test() throws IOException {
				// TODO 自动生成的方法存根
				DataInputStream ds=new DataInputStream(new BufferedInputStream(new FileInputStream(new File("D:\\learn\\file\\haha.txt"))));
				while(ds.read()!=-1){
					ds.readInt();
				}
				ds.close();
			}
		},
		new Tester("mapped read"){
			public void test() throws IOException {
				// TODO 自动生成的方法存根
				FileChannel f=new RandomAccessFile("haha.txt","rw").getChannel();
				IntBuffer ib=f.map(FileChannel.MapMode.READ_WRITE, 0,f.size()).asIntBuffer();
				for(int i=0;i<in/4;i++){
					ib.get(i);
				}
				f.close();;
			}
		} ,
		new Tester("Stream read/write"){
			public void test() throws IOException {
				RandomAccessFile r=new RandomAccessFile("haha.txt","rw");
				r.writeInt(1);
				for(int i=0;i<in/4;i++)
				{
					
					r.readInt();
				}
				r.close();
				}
		},
		new Tester("mapped read/write"){
			public void test() throws IOException {
				// TODO 自动生成的方法存根
				FileChannel f=new RandomAccessFile("haha.txt","rw").getChannel();
				IntBuffer ib=f.map(FileChannel.MapMode.READ_WRITE, 0,f.size()).asIntBuffer();
				for(int i=0;i<in/4;i++){
					ib.get(i);
				}
				f.close();;
			}
		} ,
};
public static void main(String[] args) throws IOException {
	for(Tester t:test){
		t.runtest();
	}
}
}
