import com.aoserver.AOServer;
import com.aoserver.server.console.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleTest {

    private AOServer sv;

    @Before
    public void before() {
        this.sv = new AOServer();
    }

    @Test
    public void testStopCommandConsole() throws InterruptedException {
        String commands = "/stop\n";

        Scanner input = new Scanner(
                new ByteArrayInputStream(commands.getBytes())
        );

        Console console = new Console(input);

        sv.setConsole(console);
        sv.start();

        assertFalse(console.isRunning());
    }
}
