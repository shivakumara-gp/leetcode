class Solution {

    static final long MOD = 1000000007;

    public int sumDecoded(long[] nums) {

        long out = 0;

        for (int i = 0; i < nums.length; i++) {

            int width = (int)(nums[i] % 10);
            long d = nums[i] / 10;

            int[] result = decode(width, d);

            int x = result[0];
            int y = result[1];

            long cur = power(x, y);

            out = (out + cur) % MOD;
        }

        return (int)out;
    }

    public int[] decode(int width, long d) {

        int n = String.valueOf(d).length();

        int divisor = 1;

        for (int i = 0; i < n - width; i++) {
            divisor *= 10;
        }

        int x = (int)(d / divisor);
        int y = (int)(d % divisor);

        return new int[]{x, y};
    }

    public long power(long x, long y) {

        long result = 1;

        while (y > 0) {

            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }

            x = (x * x) % MOD;
            y /= 2;
        }

        return result;
    }
}