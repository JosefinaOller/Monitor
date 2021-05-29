package monitor;

public class Hilo extends Thread {
	private Monitor monitor;

	public Hilo(Monitor monitor) {
		super();
		this.monitor = monitor;
	}

	@Override
	public void run() {
		while(true) {
			monitor.pingServidorOriginal();
			monitor.pingServidorRedudante();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) { //espera 40 seg para las respuestas de ping
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}
	
	
}
