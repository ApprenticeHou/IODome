package ioDome;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public class ElivsImpersoner {
	private static String[] favorite={"football","talkshow"};
	private static byte[] b=Arrays.toString(favorite).getBytes();
public static void main(String[] args){
//	System.out.println(b);
//Elivs elivs=(Elivs) deserialize(b);
Elivs impersonator=ElivsStealer.impersonator;
System.out.println(impersonator.toString());
//elivs.printFavorite();
impersonator.printFavorite();
}
private static Object deserialize(byte[] b){
	try {
	InputStream i=new ByteArrayInputStream(b);
		ObjectInputStream oi=new ObjectInputStream(i);
		System.out.println("oi");
		return oi.readObject();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return Elivs.INSTANCE;
}
}
class Elivs implements Serializable{
	public static Elivs INSTANCE=new Elivs();
	private Elivs(){}
	private String[] favorite={"football","talkshow"};
	public void printFavorite(){
		/*byte[] b=Arrays.toString(favorite).getBytes();
		for(byte by:b)
		System.out.println(by);*/
		System.out.println(Arrays.toString(favorite));
	}
	private static final long serialVersionUID=11111111111111l;
}
class ElivsStealer implements Serializable{
	public static Elivs impersonator;
	private Elivs payload=Elivs.INSTANCE;
	private Object readResolve(){
		impersonator=payload;
		return new String[] {"ganganaganagana"};
	}
	private static final long serialVersionUID=0;
}

