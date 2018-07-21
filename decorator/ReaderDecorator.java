package decorator;

public abstract class ReaderDecorator implements IReader 
{
	private IReader reader;
	
	public ReaderDecorator(IReader reader) {this.reader = reader;}

	@Override
	public void open() { reader.open();}
	
	@Override
	public void close() {reader.close();}

	@Override
	public byte readNextByte() {return reader.readNextByte();}

	@Override
	public boolean isNextByteAvailable() {return reader.isNextByteAvailable();}

}
