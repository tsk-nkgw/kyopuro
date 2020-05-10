package AtCoder.ABC.ABC167.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO solve
public class Main {
    private static final int MOD = 998244353;

    public static void main(final String[] args) {
        final FastScanner scanner = new FastScanner(System.in);
        final int n = scanner.nextInt();
        final long m = scanner.nextInt();
        final long k = scanner.nextInt();

        final CombinationCalculator calculator = new CombinationCalculator(n + 1, MOD);

        long answer = 0;
        long base = m;
        for (int j = 1; j < n; j++) {
            base *= m - 1;
            base %= MOD;
        }

        final long inv = modInv(m - 1);
        for (int i = 0; i <= k; i++) {
            if (n - i < i) {
                break;
            }
            long multi = base * calculator.calc(n - i, i);
            multi %= MOD;
            answer += multi;
            answer %= MOD;

            base *= inv;
            base %= MOD;
        }

        System.out.println(answer);
    }

    private static long modInv(final long a) {
        return modPow(a, MOD - 2);
    }

    private static long modPow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n >>= 1;
        }
        return res;
    }

    private static class CombinationCalculator {
        private final int size;
        private final int mod;
        private final long[] factorials;
        private final long[] invertedElements;
        private final long[] invertedFactorials;

        CombinationCalculator(final int size, final int mod) {
            this.size = size;
            this.mod = mod;
            this.factorials = new long[size];
            this.invertedElements = new long[size];
            this.invertedFactorials = new long[size];
            init();
        }

        private void init() {
            factorials[0] = 1;
            factorials[1] = 1;
            invertedFactorials[0] = 1;
            invertedFactorials[1] = 1;
            invertedElements[1] = 1;
            for (int i = 2; i < size; i++) {
                factorials[i] = factorials[i - 1] * i % mod;
                invertedElements[i] = mod - invertedElements[mod % i] * (mod / i) % mod;
                invertedFactorials[i] = invertedFactorials[i - 1] * invertedElements[i] % mod;
            }
        }

        /**
         * mod 込みで nCk を計算した結果を返す．
         *
         * @param n 組み合わせの対象となる数
         * @param k 組み合わせる個数
         * @return 組み合わせの結果
         */
        long calc(final int n, final int k) {
            return factorials[n] * (invertedFactorials[k] * invertedFactorials[n - k] % mod) % mod;
        }
    }


    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
