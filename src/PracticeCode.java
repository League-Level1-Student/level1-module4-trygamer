import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PracticeCode implements ActionListener{
JFrame f =new JFrame();
JPanel p = new JPanel();
JTextField tf = new JTextField(26);
JLabel l = new JLabel();
JButton b = new JButton();
JButton b1 = new JButton();
	public static void main(String[] args) {
		PracticeCode pc = new PracticeCode();
		pc.set();
	}
	
	public void set() {
	f.setVisible(true);
	f.add(p);
	f.setTitle("Riddle");
	p.add(b);
	b.setText("enter");
	b.addActionListener(this);
	p.add(b1);
	b1.setText("hint");
	p.add(tf);
	p.add(l);
	l.setText("What do u call something that is brown, white, and read all over. ");
	b1.addActionListener(this);
	
	f.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
		JOptionPane.showMessageDialog(null, "Where do we find the most words?");
		}
		else if(e.getSource()==b) {
			if(tf.getText().equals("a book")) {
				
				JOptionPane.showMessageDialog(null, "correct");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "incorrect");
			}
			
		}
	}
	
	
	                         
	
	
	
}
