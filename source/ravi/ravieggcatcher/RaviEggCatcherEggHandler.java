package ravi.ravieggcatcher;


public class RaviEggCatcherEggHandler extends Thread {
	
	private RaviEggCatcherStartGameHandler startGameHandler;
	
	public RaviEggCatcherEggHandler(RaviEggCatcherStartGameHandler startGameHandler) {
		
		this.startGameHandler = startGameHandler;
		
		this.start();
		
	}
	
	public void run() {
		
		RaviEggCatcherEgg egg = new RaviEggCatcherEgg();
		
		startGameHandler.addEgg(egg);
		
		while(!egg.move()) {
			
			try {
				
				sleep(egg.getSleepTime());
				
			} catch(Exception e) {}
			
		}
		
		startGameHandler.removeEgg(egg);
		
	}
	
}
