package opgave3;

public class MainApp {

	public static void main(String[] args) {
		Union f1 = new Union();
		MyThread t1 = new MyThread("t1", f1);
		MyThread t2 = new MyThread("t2", f1);
		t1.start();
		t2.start();
	}

}
