import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Objects.isNull;

public class Main {
    public static void main(String[] args) throws IOException {
        BigInteger max = BigInteger.ZERO;
        int maxIndex = -1;
        final List<String> lines =  Files.lines(Paths.get("base_exp.txt")).toList();
        int count = 0;
        for (String line: lines) {
            if (!isNull(line) && !"".equals(line)) {
                final String[] parts = line.split(",");
                final BigInteger result = BigInteger.valueOf(Integer.parseInt(parts[0])).pow(Integer.parseInt(parts[1]));
                if (max.compareTo(result) < 0) {
                    max = result;
                    maxIndex = lines.indexOf(line) + 1;
                    System.out.println("found new max");
                }
                System.out.println("processed line: " + ++count);
            }
        }
        System.out.println(maxIndex);
    }
}
