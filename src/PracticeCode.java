import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PracticeCode {
JFrame f =new JFrame();
JPanel p = new JPanel();
JTextField tf = new JTextField();
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
	p.add(b1);
	b1.setText("hint");
	p.add(tf);
	p.add(l);
	f.pack();
		
	}
	
	
	
	
}
