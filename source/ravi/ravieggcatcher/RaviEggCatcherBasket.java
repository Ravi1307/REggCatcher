package ravi.ravieggcatcher;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;


public class RaviEggCatcherBasket extends JButton implements KeyListener {
	
	int[] basketPosition;
	
	public RaviEggCatcherBasket() {
		
		this.setIcon(new ImageIcon(getClass().getResource("/res/drawable/basket.png")));
		
		this.basketPosition = new int[2];
		this.basketPosition[0] = 5;
		this.basketPosition[1] = 80;
		
		this.setBounds(basketPosition[0], 430, basketPosition[1], 50);
		this.addKeyListener(this);
		
		
	}
	
	protected int increaseWidth() {
		
		return basketPosition[1] += 10;
		
	}
	
	protected int decreaseWidth() {
		
		return basketPosition[1] -= 10;
		
	}
	
	public void keyPressed(KeyEvent ke) {
		
		if((ke.getKeyCode() == 37) && ((basketPosition[0] - 5) >= 5))		this.setBounds((basketPosition[0] -= 5), 430, basketPosition[1], 50);
		else	if((ke.getKeyCode() == 39) && (((basketPosition[0] + basketPosition[1]) + 5) <= 495))		this.setBounds((basketPosition[0] += 5), 430, basketPosition[1], 50);
		
	}
	
	public void keyReleased(KeyEvent ke) {}
	
	public void keyTyped(KeyEvent ke) {}
	
}
