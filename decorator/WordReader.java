package decorator;
import java.util.ArrayList;


public class WordReader extends ReaderDecorator
{

	public WordReader(IReader reader){super(reader);}

	@Override
	public void open() {super.open();}

	@Override
	public void close() {super.close();	}

	@Override
	public byte readNextByte() { return super.readNextByte();}

	@Override
	public boolean isNextByteAvailable() { return super.isNextByteAvailable();}

	
	
	public String readNextWord() 
	{ 

		ArrayList<Byte> list = new ArrayList<>();
		byte observer = 0;
		while(observer != 32 && isNextByteAvailable() == true)
		{
			observer = readNextByte();
			list.add(observer);			
		}
		
		int size = list.size();
		byte [] buffer = new byte [size];
		for(int i = 0; i < size; i++)
			buffer[i] = list.get(i);
				
		String word = new String(buffer);
		return word;
	 	
	}
	
}
