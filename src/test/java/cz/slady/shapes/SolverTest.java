package cz.slady.shapes;

import junit.framework.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ehp
 * Date: 9/12/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class SolverTest {
    @Test
    public void testGivenInput() throws IOException {
        testAndCompare("/inputGiven.dat", "/outputGiven.dat");
    }

    @Test
    public void testRule1() throws IOException {
        testAndCompare("/inputRule1Ok.dat", "/outputRule1Ok.dat");
        testAndCompare("/inputRule1Error.dat", "/outputRule1Error.dat");
    }

    @Test
    public void testRule2() throws IOException {
        testAndCompare("/inputRule2Ok.dat", "/outputRule2Ok.dat");
        testAndCompare("/inputRule2Error.dat", "/outputRule2Error.dat");
    }

    @Test
    public void testRule3() throws IOException {
        testAndCompare("/inputRule3Ok.dat", "/outputRule3Ok.dat");
        testAndCompare("/inputRule3Error.dat", "/outputRule3Error.dat");
    }

    @Test
    public void testRule4() throws IOException {
        testAndCompare("/inputRule4Ok.dat", "/outputRule4Ok.dat");
        testAndCompare("/inputRule4Error.dat", "/outputRule4Error.dat");
    }

    @Test
    public void testRule5() throws IOException {
        testAndCompare("/inputRule5Ok.dat", "/outputRule5Ok.dat");
        testAndCompare("/inputRule5AOk.dat", "/outputRule5AOk.dat");
        testAndCompare("/inputRule5Error.dat", "/outputRule5Error.dat");
    }

    @Test
    public void testRule6() throws IOException {
        testAndCompare("/inputRule6Ok.dat", "/outputRule6Ok.dat");
        testAndCompare("/inputRule6Error.dat", "/outputRule6Error.dat");
    }

    @Test
    public void testRule7() throws IOException {
        testAndCompare("/inputRule7Ok.dat", "/outputRule7Ok.dat");
        testAndCompare("/inputRule7Error.dat", "/outputRule7Error.dat");
    }


    private void testAndCompare(String inputPath, String outputPath) throws IOException {
        final File file = new File("src/test/resources" + inputPath);
        final String result = Shapes.validate(file);
        final String expected = readFile("src/test/resources" + outputPath);
        assertEquals(expected, result);
    }

    private static String readFile(final String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

}
