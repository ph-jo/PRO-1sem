package opgave2;

import java.util.Random;

public class Union {

	private int turn;
	private boolean flag[];

	private int count;

	public Union() {
		this.count = 0;
		flag = new boolean[2];
		flag[0] = false;
		flag[1] = false;
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
			temp = temp * -200;
		}
	}

	public void kritisksection() {
		int temp = count;
		TagerRandomTid(5000);
		count = temp + 1;
	}

	public int getCount() {
		return count;
	}

	public void setFlag(boolean flag, int id) {
		this.flag[id] = flag;
	}

	public boolean getFlag(int id) {
		return flag[id];
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getTurn() {
		return turn;
	}
}
