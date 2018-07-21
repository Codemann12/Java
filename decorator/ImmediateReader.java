package decorator;

import java.util.ArrayList;

public class ImmediateReader extends ReaderDecorator
{

    public ArrayList<Byte> list;
    int listIndex = 0;
    int sizeOfListAfterAdd = 0;
    int staticLengthOfListAfterAdd = 0;
	
	public ImmediateReader(IReader reader) 
	{
		super(reader);
		list = new ArrayList<>();		
	}


	@Override
	public void open() 
	{
		super.open();
		while(super.isNextByteAvailable()) {
			list.add(super.readNextByte());
		}
		sizeOfListAfterAdd = list.size();
		staticLengthOfListAfterAdd = sizeOfListAfterAdd;
	}

	@Override
	public void close()	{ super.close();}

	@Override
	public byte readNextByte()
	{
		byte nextByte  = 0;
		if(listIndex < staticLengthOfListAfterAdd) {
			nextByte = list.get(listIndex);
		}
		listIndex ++;
		sizeOfListAfterAdd --;
		return nextByte;
	}

	@Override
	public boolean isNextByteAvailable() { return this.sizeOfListAfterAdd >=0;}
}
