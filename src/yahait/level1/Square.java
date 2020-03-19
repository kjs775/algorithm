package yahait.level1;
//멀쩡한 사각형
public class Square {
	public long gcd(long a, long b) {
		long temp = 0;
		if (a < b) {
			temp = b;
			b = a;
			a = temp;
		}
		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
