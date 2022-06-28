package cn.shimeng.utils;

public class RandomUtils {
    private RandomUtils() {
    }

    public static int Random_number(int min, int max) {
        int s = (int) min + (int) (Math.random() * (max - min));
        if (s % 2 == 0) {
            return s;
        } else {
            return s + 1;
        }
    }
}
