package AtCoder.other.zone2021.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(final String[] args) throws IOException {
        final FastScanner scanner = new FastScanner(System.in);
        final int n = scanner.nextInt();
        final double d = scanner.nextInt();
        final double h = scanner.nextInt();
        final double answer = IntStream.range(0, n)
            .mapToDouble(i -> {
                final double di = scanner.nextDouble();
                final double hi = scanner.nextDouble();
                return h - (h - hi) / (d - di) * d;
            }).max()
            .orElseThrow();
        System.out.println(answer);
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) throws IOException {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = new StringTokenizer(reader.readLine());
        }

        String next() throws IOException {
            if (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            try {
                return Double.parseDouble(next());
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }
}
    