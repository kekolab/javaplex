package kekolab.libplex.test;

import java.util.Random;

public class TestUtils {
    String randomString() {
		String s = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		String ret = new String();
		for (int i = 0; i < 10; i++)
			ret += s.charAt(random.nextInt(s.length()));
		return ret;
	}
}
