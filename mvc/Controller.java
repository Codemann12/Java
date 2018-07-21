package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.IllegalFormatException;

public final class Controller 
{
	private FirstView firstView;
	private SecondView secondView;
	private Model model;

	public Controller(FirstView firstView, SecondView secondView, Model model)
	{
		this.firstView = firstView;
		this.secondView = secondView;
		this.model = model;				
		this.firstView.addModelListener(new ModelListener());		
	}
	
	
	class ModelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e){ startApplication();}		
	}
	
	
	public void setModelContent(String content)	{model.setContent(content);}
	public String getModelContent() {return model.getContent();}

	public void startApplication() 
	{
		String content = null;
		
		try {
			firstView.setVisible(true);	
			secondView.setVisible(true);
			content = firstView.getInput();
			model.setContent(content);
			firstView.setInput(model.getContent());
			secondView.setInput(model.getContent());
			
		}catch(IllegalFormatException ex) {
			System.out.println(ex);
		}		
	}
}
