package opgave4;

public class MyThread extends Thread {
	private String navn;
	private Union fælles;

	public MyThread(String navn, Union fælles) {
		super();
		this.fælles = fælles;
		this.navn = navn;
	}

	@Override
	public void run() {
		for (int j = 0; j < 100; j++) {
			fælles.kritisksection();
			fælles.TagerRandomTid(150);

			System.out.println(navn + ": " + fælles.getCount());
		}
		System.out.println("Tæller: " + fælles.getCount());
	}
}
