import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Dialog extends JFrame implements ActionListener{
	
	private PanelHas³a panelHas³a;
	
	private JTextArea notatnik;
	private JScrollPane scrollPane;
	private JButton bDodajU¿ytkownika;
	
	public Dialog()
	{
		setTitle("Demonstracja okna dialogowego!");
		setSize(400,400);
		setLayout(null);
		
		notatnik = new JTextArea();
		notatnik.setWrapStyleWord(true); //metoda, która w notatniku powoduje automatyczne przechodzenie do nowej linijki
		scrollPane = new JScrollPane(notatnik);
		scrollPane.setBounds(0,0,300,200);
		add(scrollPane);
		
		bDodajU¿ytkownika = new JButton("DodajU¿ytkownika");
		bDodajU¿ytkownika.setBounds(0,250,150,20);
		add(bDodajU¿ytkownika);
		bDodajU¿ytkownika.addActionListener(this);
	}
	
	public static void main(String[] args) 
	{
		Dialog dialog = new Dialog();
		dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(panelHas³a==null)
		   panelHas³a = new PanelHas³a(this);
		panelHas³a.setVisible(true);
		panelHas³a.setFocus();
		
		if(panelHas³a.isOk())
		{
			notatnik.append(panelHas³a.getUser() + ",");
			notatnik.append(panelHas³a.getPassword() + "\n");
		}
	}
	
	class PanelHas³a extends JDialog implements ActionListener
	{
		private JLabel lUser, lHas³o;
		private JTextField tUser;
		JPasswordField pHas³o;
		private JButton bOk, bCancel;
		private boolean okData;
		
		public PanelHas³a(JFrame owner)
		{
			super(owner,"Wprowadzanie has³a",true);
			setSize(300,200);
			setLayout(null);
			
			lUser = new JLabel("U¿ytkownik: ",JLabel.RIGHT);
			lUser.setBounds(0,0,100,20);
			add(lUser);
			
			tUser = new JTextField();
			tUser.setBounds(120,0,100,20);
			add(tUser);
			
			lHas³o = new JLabel("Has³o: ",JLabel.RIGHT);
			lHas³o.setBounds(0,50,100,20);
			add(lHas³o);
			
			pHas³o = new JPasswordField();
			pHas³o.setBounds(120,50,100,20);
			add(pHas³o);
			
			bOk = new JButton("OK");
			bOk.setBounds(0,100,100,20);
			bOk.addActionListener(this);
			add(bOk);
			
			bCancel = new JButton("Cancel");
			bCancel .setBounds(150,100,100,20);
			bCancel.addActionListener(this);
			add(bCancel);
		}
		
		public String getUser()
		{
			return tUser.getText();
		}
		
		public String getPassword()
		{
			return new String(pHas³o.getPassword());
		}
		
		public boolean isOk()
		{
			return okData;
		}
		
		public void setFocus()
		{
			tUser.requestFocusInWindow();
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			Object source = e.getSource();
			if(source==bOk)
				okData = true;
			else
				okData = false;
			setVisible(false);
		}
	}
}
