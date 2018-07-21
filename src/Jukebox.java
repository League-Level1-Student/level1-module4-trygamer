/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
JFrame f = new JFrame();
JPanel p = new JPanel();
JButton b1 = new JButton();
JButton b2 = new JButton();
JButton b3 = new JButton();
boolean bb=false;
boolean tb=false;
boolean wb=false;
Song s = new Song("src/Imagine Dragons - Believer (with lyrics).mp3");
Song t = new Song("Imagine Dragons - Thunder.mp3");
Song w= new Song("Imagine Dragons - Whatever It Takes.mp3");
	public static void main(String[] args) {
		Jukebox j = new Jukebox();
		j.set();
		SwingUtilities.invokeLater(new Jukebox());
	}

	
	public  void set() {
		f.setVisible(true);
		f.add(p);
		f.setTitle("Imagine Dragon Songs");
		p.add(b1);
		b1.setText("Believer");
		p.add(b2);
		b2.setText("Thunder");
		p.add(b3);
		b3.setText("Whatever It Takes");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.pack();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if(b1==buttonPressed&&bb==false) {
			s.play();
			bb=true;
		}
		else if(b2==buttonPressed&&tb==false) {
			t.play();
			tb=true;
		}
		else if(b3==buttonPressed&&wb==false) {
			w.play();
			wb=true;
		}
		else if(b1==buttonPressed&&bb==true) {
			s.stop();
			bb=false;
		}
		else if(b2==buttonPressed&&tb==true) {
			t.stop();
			tb=false;
		}
		else if(b3==buttonPressed&&wb==true) {
			w.stop();
			wb=false;
		}
	}
           public void run() {

		// 3. Find an mp3 on your computer or on the Internet.
		// 4. Create a Song

		// 5. Play the Song


		/*
		 * 6. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */


          }
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

