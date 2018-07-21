package decorator;

public class Main {

	public static void main(String[] args)
	{
		String text;
		byte [] buffer = new byte[1024];
		IReader reader = new ImmediateReader(new FileReader("testfile"));
		
		reader.open();      
		while(reader.isNextByteAvailable())
			for(int i = 0; i< buffer.length; i++)
				buffer[i] = reader.readNextByte();
				
		text = new String(buffer);
		System.out.println(text);
		reader.close();
		
		reader = new  WordReader(new FileReader("testfile"));
		reader.open();      
		
		while(reader.isNextByteAvailable())
			for(int i = 0; i< buffer.length; i++)
				buffer[i] = reader.readNextByte();
				
		text = new String(buffer);
		System.out.println(text);
		reader.close();
		
		
		WordReader firstWord = new  WordReader(new FileReader("testfile"));
		firstWord.open();
		System.out.println(firstWord.readNextWord());
		firstWord.open();
		
		
		
		

	}

}
