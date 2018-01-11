package opgave2;

public class MyThread extends Thread {
	private String navn;
	private Union fælles;
	private int id;

	public MyThread(String navn, Union fælles, int id) {
		super();
		this.fælles = fælles;
		this.navn = navn;
		this.id = id;
	}

	@Override
	public void run() {
		int concurrentId = (id + 1) % 2;
		for (int j = 0; j < 100; j++) {

			fælles.setFlag(true, id);
			fælles.setTurn(concurrentId);
			while (fælles.getFlag(concurrentId) && fælles.getTurn() == concurrentId) {

			}
			fælles.kritisksection();
			fælles.setFlag(false, id);
			fælles.TagerRandomTid(200);

			System.out.println(navn + ": " + fælles.getCount());
		}
		System.out.println("Tæller: " + fælles.getCount());
	}
}
