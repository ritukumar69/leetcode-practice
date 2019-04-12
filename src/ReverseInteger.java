public class ReverseInteger {
	public int reverse(int x) {
		if (x == 0)
			return x;
		String result = "";
		if (x < 0) {
			result += "-";
			x *= -1;
		}
		while (x != 0) {
			int tmp = x % 10;
			result += tmp;
			x = x / 10;
		}
		try {
			int answer = Integer.valueOf(result);
			return answer;
		} catch (Exception ex) {
			return 0;
		}
	}

}
