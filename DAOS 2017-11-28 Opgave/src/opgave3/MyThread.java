package opgave3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

public class MyThread extends Thread {
	private String navn;
	private Union fælles;
	private static Semaphore semaphore = new Semaphore(1);

	public MyThread(String navn, Union fælles) {
		super();
		this.fælles = fælles;
		this.navn = navn;
	}

	@Override
	public void run() {
		for (int j = 0; j < 100; j++) {
			try {
				semaphore.acquire();
				fælles.kritisksection();
				fælles.TagerRandomTid(150);
				semaphore.release();
			} catch (InterruptedException ex) {
				Logger.getLogger(Union.class.getClass()).log(Level.SEVERE, null, ex);
			}
			System.out.println(navn + ": " + fælles.getCount());

		}
		System.out.println("Tæller: " + fælles.getCount());
	}
}
