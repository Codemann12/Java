package decorator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader implements IReader 
{
	
	private String fileName;
	FileInputStream fis;
	
	public FileReader(String fileName) {this.fileName = fileName;}

	@Override
	public void open() {
		try {
		fis = new FileInputStream(new File(fileName));
		}catch(FileNotFoundException e) {
			System.out.println("There is no file to open...FILE NOT FOUND! "+ e);
		}		
	}

	@Override
	public void close() 
	{
		try {
			if(fis != null)
				fis.close();
		}catch(IOException e) {
			System.out.println("Problem with the file. CAN NOT BE CLOSE!");
			e.printStackTrace();
		}		
	}

	@Override
	public byte readNextByte() 
	{
		byte buffer = 0;
		if(isNextByteAvailable())
			try {
				buffer = (byte) fis.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return buffer;
	}

	@Override
	public boolean isNextByteAvailable() 
	{
		try {
			if(fis.available() > 0) {
				return true;}
			else
				return false;
			} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getFileName(){return fileName;}
	public void setFileName(String fileName) {this.fileName = fileName;	}
}
