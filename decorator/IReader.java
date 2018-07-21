package decorator;

public interface IReader 
{
	public void open();
	public void close();
	public byte readNextByte();
	public boolean isNextByteAvailable();

}
