package q3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TestUtils {
    private static final PrintStream originalOut = System.out;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public static String getConsoleOutput(Runnable runnable) {
        System.setOut(new PrintStream(outContent));
        try {
            runnable.run();
            return outContent.toString();
        } finally {
            resetSystemOut();
        }
    }

    private static void resetSystemOut() {
        System.setOut(originalOut);
        outContent.reset();
    }
}
