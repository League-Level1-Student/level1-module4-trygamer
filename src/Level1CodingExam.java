import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level1CodingExam implements ActionListener {
JFrame f = new JFrame();
JPanel p = new JPanel();
JButton by =new JButton();
JButton br =new JButton();
JButton bb =new JButton();
JButton bg =new JButton();
Color blue = new Color(0,0,255);
Color green = new Color(0,255,0);
Color red = new Color(255,0,0);
Color yellow = new Color(255,255,0);



public static void main(String[] args) {
	Level1CodingExam Level1CodingExam = new Level1CodingExam();
	Level1CodingExam.set();
}

public void set() {
	f.setVisible(true);
	f.add(p);
	f.setTitle("Color Teacher");
	p.add(bb);
	bb.addActionListener(this);
	bb.setBackground(blue);
	bb.setOpaque(true);
	p.add(bg);

	bg.setBackground(green);
	bg.setOpaque(true);
	p.add(br);
	
	br.setBackground(red);
	br.setOpaque(true);
	p.add(by);
	
	by.setBackground(yellow);
	by.setOpaque(true);
	bg.addActionListener(this);
	br.addActionListener(this);
	by.addActionListener(this);
	
	f.pack();
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==bb) {
		
		speak("blue");
	}
	else if(e.getSource()==bg) {
		speak("green");
	}
	else if (e.getSource()==br) {
		
		speak("red");
	}
	else {
		
		speak("yellow");
	}
}

void speak(String words) {
	try {
		Runtime.getRuntime().exec("say " + words);
	} catch(IOException e) {
		e.printStackTrace();
	}
}

	
	
	
	
	
	
	
}
