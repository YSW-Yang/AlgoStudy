import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		long playerHp = Integer.parseInt(strArr[0]);
		long playerAtk = Integer.parseInt(strArr[1]);
		long demonHp = Integer.parseInt(strArr[2]);
		long maxDemonHp = demonHp;
		int demonAtk = Integer.parseInt(strArr[3]);
		strArr = br.readLine().split(" ");
		long P = Integer.parseInt(strArr[0]);
		long S = Integer.parseInt(strArr[1]);

		long turn = 0;
		if ((demonHp - P) % playerAtk == 0 && demonHp - P != 0) {
			turn = (demonHp - P) / playerAtk - 1;
		} else {
			turn = (demonHp - P) / playerAtk;
		}

		demonHp -= (turn + 1) * playerAtk;
		playerHp -= turn * demonAtk;
		if (playerHp <= 0) {
			System.out.println("gg");
			return;
		} else if (demonHp <= 0) {
			System.out.println("Victory!");
			return;
		} else if (demonHp >= 1 && demonHp <= P) {
			playerHp -= demonAtk;
			if (maxDemonHp < demonHp + S) {
				demonHp += maxDemonHp;
			} else {
				demonHp += S;
			}
		}

		if (demonHp % playerAtk == 0) {
			turn = demonHp / playerAtk - 1;
		} else {
			turn = demonHp / playerAtk;
		}

		if (playerHp - turn * demonAtk <= 0) {
			System.out.println("gg");
		} else {
			System.out.println("Victory!");
		}
	}
}