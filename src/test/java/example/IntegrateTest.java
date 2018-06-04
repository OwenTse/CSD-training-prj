package example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import java.io.*;

public class IntegrateTest {

    @Test
    public void testMain_VendorAddARoom_Then_UserSearch() throws IOException {
        // change System for test
        final PrintStream original = System.out;
        final PrintStream mockPrintStream = mock(PrintStream.class);
        System.setOut(mockPrintStream);

        // arrange
        String[] vendorArgs = {"vendor", "vendor1", "add", "room1"};
        String[] userArgs = {"user", "search"};
        String expectedVendorOut = "vendor1 add room1";
        String expectedUserOut = "room1 from vendor1";

        // act
        One.main(vendorArgs);
        One.main(userArgs);

        // assert
        verify(mockPrintStream).println(expectedVendorOut);
        verify(mockPrintStream).println(expectedUserOut);

        // recover System
        System.setOut(original);
    }
}