/**
 * 
 * @author Onur
 * 
 * @editor Denizhan
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Reader implements java.io.Serializable {

	FileOutputStream fileOut;
    ObjectOutputStream out; 
    FileInputStream fileIn;
    ObjectInputStream in;
    String mapName;
    
    Reader(String mapName) throws IOException
    {
    this.mapName= mapName;
    
    fileOut	= new FileOutputStream(this.mapName + ".txt");
    out = new ObjectOutputStream(fileOut);
    fileIn = new FileInputStream(this.mapName + ".txt");
    in = new ObjectInputStream(fileIn);
    }
	
public void writeMap(Map map) throws Exception
{
    out.writeObject(map);
    out.close();
    fileOut.close();
 }

public Map readMap() throws Exception
{
        Map map = (Map) in.readObject();
        in.close();
        fileIn.close();
        return map;
}
	
}
