package ioDome;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMapped {
	static FileChannel fc;
	static int length=1024*1024*1;
public static void main(String[] args) throws IOException {
	File f=new File("D:\\learn\\file\\test.dat");
	fc=new RandomAccessFile(f, "rw").getChannel();
	MappedByteBuffer mb=fc.map(FileChannel.MapMode.READ_WRITE,0,length);
	for(int i=0;i<length;i++)
	mb.put((byte)'x');
//	new LockDome(mb,0,length/2);
	new LockDome(mb,length/2,length/2+length/4);
	while(mb.position()<mb.limit()){
		System.out.println((char)mb.get());
	}
}
private static class LockDome extends Thread{
	private ByteBuffer b;
	private int start,end;
	public LockDome(ByteBuffer buf,int start ,int end){
		this.start=start;
		this.end=end;
		buf.limit(end);
		buf.position(start);
		b=buf.slice();
		run();
	}
	public void run(){
		try {
			FileLock fl=fc.tryLock(start,end,false);
			System.out.println("Locking"+start+"to"+end);
			while(b.position()<b.limit()-1){
		   b.put((byte) (b.get()+1));
			}
			fl.release();
			System.out.println("over"+start+"to"+end);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
}
}
}
