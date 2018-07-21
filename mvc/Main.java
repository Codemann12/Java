package mvc;

public final class Main 
{
	public static void main(final String[] args) 
	{		
		Model model           = new Model();
		FirstView firstView   = new FirstView();
		SecondView secondView = new SecondView();
		Controller controller = new Controller(firstView, secondView, model);
		controller.startApplication();
	}

}
