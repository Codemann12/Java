package mvc;

import javax.swing.JFrame;
import javax.swing.JLabel;

public final class SecondView extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private final JLabel label;

	public SecondView()
	{
		super("Second View");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.label = new JLabel("N/A");
		super.getContentPane().add(this.label);
		super.pack();
	}

	public void setInput(String content) {label.setText(content);}
}
