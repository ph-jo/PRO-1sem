package opgave2;

public class MainApp {

	public static void main(String[] args) {
		Union f1 = new Union();
		MyThread t1 = new MyThread("t1", f1, 0);
		MyThread t2 = new MyThread("t2", f1, 1);

		t1.start();
		t2.start();
	}

}
