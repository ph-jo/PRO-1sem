package opgave4;

import java.util.Random;

public class Union {

	private int count;

	public Union() {
		this.count = 0;
	}

	public void add() {
		count++;
	}

	public void remove() {
		count--;
	}

	public int getCount() {
		return count;
	}

	public void TagerRandomTid(int max) {
		Random r = new Random();
		int nymax = Math.abs(r.nextInt()) % max + 1;
		int temp = 0;
		for (int j = -500; j < nymax; j++) {
			temp++;
			for (int g = -3000; g < nymax; g++) {
				temp += temp;
			}
			temp--;
			temp -= temp;
			temp = (int) (temp * Math.sqrt(400 / 2 * 500));
		}
	}

	public synchronized void kritisksection() {
		int temp = count;
		TagerRandomTid(5000);
		count = temp + 1;
	}
}
