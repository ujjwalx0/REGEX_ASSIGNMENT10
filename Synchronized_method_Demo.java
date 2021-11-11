
/*Develop a Program to implement synchronous concept?*/
class EvenNumTable {
	public synchronized  void EvenNums(int n) {
		System.out.println("Even NUms Table for"+" "+ n);
		for (int i = 1;i<=n;i++) {
			if(i%2==0) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
class mythread1 extends Thread{
	EvenNumTable et;
	mythread1(EvenNumTable et){
		this.et=et;
	}
	public void run() {
		et.EvenNums(10);
	}
	
}
class mythread2 extends Thread{
	EvenNumTable et;
	mythread2(EvenNumTable et){
		this.et=et;
	}
	public void run() {
		et.EvenNums(20);
	}
	
}
public class Synchronized_method_Demo {

	public static void main(String[] args) {
		EvenNumTable Et= new EvenNumTable();
		mythread1 t1 = new mythread1(Et);
		mythread2 t2 = new mythread2(Et);
		t1.start();
		t2.start();
		

	}

}
