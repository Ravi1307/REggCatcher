package ravi.ravieggcatcher;


import java.util.Random;

import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class RaviEggCatcherEgg extends JLabel {
	
	private int[] eggPosition;
	private int eggType, sleepTime;
	
	private RaviEggCatcherBasket basket;
	
	public RaviEggCatcherEgg() {
		
		int x = (new Random()).nextInt(430);
		
		this.basket = RaviEggCatcherStartGameHandler.basket;
		this.sleepTime = (70 + (new Random()).nextInt(50));
		
		this.eggPosition = new int[2];
		this.eggPosition[1] = 5;
		this.eggPosition[0] = (x + 10);
		
		this.eggType = ((((eggType = ((new Random()).nextInt(100))) % 7) == 0) ? (((eggType % 2) == 0) ? 2 : 1) : 0);
		this.eggType = (((basket.getWidth() >= 200) && (eggType == 1))	? 2 : eggType);
		
		
		this.setBounds(eggPosition[0],  eggPosition[1], 50, 50);
		this.setEggType();
		
	}
	
	private void setEggType() {
		
		switch(eggType) {
			
			case 0:		this.setIcon(new ImageIcon(getClass().getResource("/res/drawable/egg_normal.png")));
			break;
			
			case 1:		this.setIcon(new ImageIcon(getClass().getResource("/res/drawable/egg_gold.png")));
			break;
			
			case 2:		this.setIcon(new ImageIcon(getClass().getResource("/res/drawable/egg_red.png")));
			break;
			
		}
		
	}
	
	protected boolean move() {
		
		this.setBounds(eggPosition[0], (eggPosition[1] += 5), 50, 50);
		
		if((eggPosition[1] + 50) > 430)  {
			
			switch(eggType) {
				
				case 0:
					
					if((eggPosition[0] >= basket.getX()) && ((eggPosition[0] + 50) <= (basket.getX() + basket.getWidth())))		RaviEggCatcherStartGameHandler.score++;
					else	RaviEggCatcherStartGameHandler.gameOver = true;
					
				break;
				
				case 1:
					
					if((eggPosition[0] >= basket.getX()) && ((eggPosition[0] + 50) <= (basket.getX() + basket.getWidth())))		basket.setBounds(basket.getX(), 430, basket.increaseWidth(), 50);
					
				break;
				
				case 2:
					
					if(((eggPosition[0] + 50) >= basket.getX()) && (eggPosition[0] <= (basket.getX() + basket.getWidth())))		basket.setBounds(basket.getX(), 430, basket.decreaseWidth(), 50);
					if(basket.getWidth() < 50)		RaviEggCatcherStartGameHandler.gameOver = true;
					
				break;
				
			}
			
			return true;
			
		} else	return RaviEggCatcherStartGameHandler.gameOver;
		
	}
	
	protected int getSleepTime() {
		
		return sleepTime;
		
	}
	
}
