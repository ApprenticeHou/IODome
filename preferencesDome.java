package ioDome;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class preferencesDome {
public static void main(String[] args) throws BackingStoreException {
	Preferences pf=Preferences.userNodeForPackage(preferencesDome.class);
	pf.put("name", "²»ÖªµÀ");
	pf.put("loaction", "oz");
	pf.putInt("companions",4);
	pf.putBoolean("Are there witches",true);
	int useageCount=pf.getInt("Useagecount",0);
	useageCount++;
	pf.putInt("Useagecount", useageCount);
	System.out.println(pf.getInt("Useagecount",0));
	for(String key:pf.keys()){
		System.out.println(key+":"+pf.get(key,null));
	}
	System.out.println(pf.getInt("companions", 0));
}
}
