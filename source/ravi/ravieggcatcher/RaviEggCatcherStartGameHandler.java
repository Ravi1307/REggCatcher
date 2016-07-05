package ravi.ravieggcatcher;


import java.util.Random;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JFrame;


public class RaviEggCatcherStartGameHandler extends Thread {
	
	protected static int score;
	protected static boolean gameOver;
	protected static RaviEggCatcherBasket basket;
	
	private JFrame frame;
	private JLabel labelScore;
	private JLabel labelGameOver;
	private JLabel labelFinalScore;
	
	public RaviEggCatcherStartGameHandler(JFrame frame) {
		
		this.score = 0;
		this.frame = frame;
		this.gameOver = false;
		
		this.labelGameOver = new JLabel();
		this.labelFinalScore = new JLabel();
		this.labelScore = new JLabel("Score : " + score);
		this.basket = new RaviEggCatcherBasket();
		
		this.labelScore.setBounds(0, 0, 200, 50);
		this.labelGameOver.setBounds(80, 40, 400, 200);
		this.labelFinalScore.setBounds(110, 120, 450, 200);
		
		this.labelScore.setFont(new Font("monotype corsiva", Font.BOLD, 20));
		this.labelGameOver.setFont(new Font("monotype corsiva", Font.BOLD, 70));
		this.labelFinalScore.setFont(new Font("monotype corsiva", Font.BOLD, 40));
		
		frame.add(labelGameOver);
		frame.add(labelFinalScore);
		frame.add(labelScore);
		frame.add(basket);
		
		this.start();
		
	}
	
	public void run() {
		
		do {
			
			new RaviEggCatcherEggHandler(this);
			
			try {
				
				if(!gameOver)		sleep((((new Random()).nextInt(50)) + 500) * 10);
				
			} catch(Exception e) {}
			
		} while(!gameOver);
		
	}
	
	protected synchronized void addEgg(RaviEggCatcherEgg egg) {
		
		frame.add(egg);
		
	}
	
	protected synchronized void removeEgg(RaviEggCatcherEgg egg) {
		
		frame.remove(egg);
		labelScore.setText("Score : " + score);
		
		if(gameOver) {
			
			this.labelGameOver.setText("Game Over");
			this.labelFinalScore.setText("Your Score is " + score);
			
		}
		
	}
	
	protected synchronized boolean isGameOver() {
		
		return gameOver;
		
	}
	
}
