
/*Develop a Program to implement inter_thread communication.*/

//___________________producer_consumer_problem______________

class Company
{
	int n;
	boolean f=false;
	// f=false: chance: producer
	//f=true: chance :consumer
	synchronized public void produce_item(int n)throws Exception
	{
		if(f)
		{
			wait();
		}
		this.n=n;
		System.out.println("Produced : "+this.n);
		f=true;
		notify();
	}

	synchronized public int consume_item()throws Exception
	{
		if(!f)
		{
			wait();
		}
		System.out.println("Consumed : "+this.n);
		f=false;
		notify();
		return this.n;
	}
}
class Producer extends Thread
{
public Company company;
	
	public Producer(Company comp) {
		company = comp;
	}

	public void run()
	{ 
		int i=1;
		while(true)
		{
			try {
				this.company.produce_item(i);
			} catch (Exception e1) {
			
				e1.printStackTrace();
			}
			try{Thread.sleep(1000);}catch(Exception e){}
			i++;
		}
	}

	
}
class Consumer extends Thread {
	
	public Company company;
	public Consumer(Company comp) {
		company = comp;
	}

	public void run()
	{
		while(true)
		{
			try {
				this.company.consume_item();
			} catch (Exception e1) {
			
				e1.printStackTrace();
			}
			try{Thread.sleep(1000);}catch(Exception e){}
		}
	}

	
}
public class InterThread_Demo {

	public static void main(String[] args) {
		Company comp=new Company();
		Producer p=new Producer(comp);
		Consumer c=new Consumer(comp);
		p.start();
		c.start();
	

	}

}
