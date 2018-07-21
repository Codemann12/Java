package mvc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class FirstView extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JTextField txtNa;
	private final JLabel lblNa;
	private final JButton btnOk;

	public FirstView() 
	{
		super("First View");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 1, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 1, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		this.getContentPane().setLayout(gridBagLayout);

		this.txtNa = new JTextField();
		this.txtNa.setText("N/A");
		final GridBagConstraints gbc_txtNa = new GridBagConstraints();
		gbc_txtNa.insets = new Insets(0, 0, 5, 5);
		gbc_txtNa.fill = GridBagConstraints.BOTH;
		gbc_txtNa.gridx = 0;
		gbc_txtNa.gridy = 0;
		this.getContentPane().add(this.txtNa, gbc_txtNa);
		this.txtNa.setColumns(10);

		this.btnOk = new JButton("Ok");
		final GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.fill = GridBagConstraints.BOTH;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 0;
		this.getContentPane().add(btnOk, gbc_btnOk);

		this.lblNa = new JLabel("N/A");
		final GridBagConstraints gbc_lblNa = new GridBagConstraints();
		gbc_lblNa.insets = new Insets(0, 0, 0, 5);
		gbc_lblNa.fill = GridBagConstraints.BOTH;
		gbc_lblNa.gridx = 0;
		gbc_lblNa.gridy = 1;
		this.getContentPane().add(this.lblNa, gbc_lblNa);

		super.pack();
		
	}

	public String getInput()
	{
		if(txtNa.getText().isEmpty())
			throw new UnsupportedOperationException();
		return txtNa.getText();
	}
	
	public void setInput(String content) {lblNa.setText(content);}
	public void addModelListener(ActionListener listenerForOkButton){btnOk.addActionListener(listenerForOkButton);}

}
