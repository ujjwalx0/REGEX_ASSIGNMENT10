
/*Develop a Program using join() method.
Develop 3 threads like RedSignalThread, YellowSignalThread, and GreenSignalThread.
Order of execution must be 
1. RedSignalThread
2. YellowSignalThread
3. GreenSignalThread*/

class RedSignalThread extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("RED SIGNAL THREAD");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}System.out.println("================"+"\n");
	}
}

class  YellowSignalThread extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("YELLOW SIGNAL THREAD");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}System.out.println("================"+"\n");
	}
}
class   GreenSignalThread extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("GREEN SIGNAL THREAD");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}
}
public class Join_Methods_Demo {

	public static void main(String[] args) throws InterruptedException {
		
		RedSignalThread t1= new RedSignalThread();
		t1.start();
		t1.join();
		
		YellowSignalThread t2 = new YellowSignalThread();
		t2.start();
		t2.join();
		
		GreenSignalThread t3 = new GreenSignalThread ();
		t3.start();
	}

}
