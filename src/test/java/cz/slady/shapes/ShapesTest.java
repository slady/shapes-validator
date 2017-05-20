package cz.slady.shapes;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class ShapesTest {
    @Test
    public void go() throws Exception {
    }

    @Test
    public void readDotList() throws Exception {
        final File file = new File("src/test/resources/input1.txt");
        final List<Dot> dots = Shapes.readDotList(file);
        assertNotNull(dots);
        assertEquals(12, dots.size());
        final Dot dot = dots.get(0);
        assertEquals(7, dot.getX());
        assertEquals(22, dot.getY());
        assertEquals(Color.G, dot.getColor());
        assertEquals(" Green structure #1", dot.getComment());
    }

    @Test
    public void convertDotListToRowList() throws Exception {
        final File file = new File("src/test/resources/input1.txt");
        final List<Dot> dotList = Shapes.readDotList(file);
        final List<Row> rowList = Shapes.convertDotListToRowList(dotList);
        assertNotNull(rowList);
        assertEquals(4, rowList.size());
        final Row row = rowList.get(0);
        final List<Dot> sortedDotList = row.getSortedDotList();
        assertNotNull(sortedDotList);
        assertEquals(3, sortedDotList.size());

        final Dot dotG = sortedDotList.get(0);
        assertEquals(7, dotG.getX());
        assertEquals(22, dotG.getY());
        assertEquals(Color.G, dotG.getColor());

        final Dot dotR1 = sortedDotList.get(1);
        assertEquals(11, dotR1.getX());
        assertEquals(22, dotR1.getY());
        assertEquals(Color.R, dotR1.getColor());

        final Dot dotR2 = sortedDotList.get(2);
        assertEquals(12, dotR2.getX());
        assertEquals(22, dotR2.getY());
        assertEquals(Color.R, dotR2.getColor());

        final Row lastRow = rowList.get(3);
        final List<Dot> sortedDotListLast = lastRow.getSortedDotList();
        assertEquals(4, sortedDotListLast.size());

        final Dot dotY1 = sortedDotListLast.get(0);
        assertEquals(7, dotY1.getX());
        assertEquals(25, dotY1.getY());
        assertEquals(Color.Y, dotY1.getColor());

        final Dot dotY2 = sortedDotListLast.get(1);
        assertEquals(8, dotY2.getX());
        assertEquals(25, dotY2.getY());
        assertEquals(Color.Y, dotY2.getColor());
    }

    @Test
    public void createShapesFromInputFile() throws Exception {
        final File file = new File("src/test/resources/input1.txt");
        final List<Shape> shapes = Shapes.createShapesFromInputFile(file);
        assertNotNull(shapes);
        assertEquals(5, shapes.size());

        final Shape shapeG = shapes.get(0);
        final List<Dot> gDotList = shapeG.getDotList();
        assertEquals(1, gDotList.size());
        final Dot dotG = gDotList.get(0);
        assertEquals(7, dotG.getX());
        assertEquals(22, dotG.getY());
        assertEquals(Color.G, dotG.getColor());

        final List<Shape> neighbouringShapesG = shapeG.getNeighbouringShapes();
        assertNotNull(neighbouringShapesG);
        assertTrue(neighbouringShapesG.isEmpty());

        final Shape shapeR = shapes.get(1);
        final List<Dot> rDotList = shapeR.getDotList();
        assertEquals(2, rDotList.size());

        final Dot dotR1 = rDotList.get(0);
        assertEquals(11, dotR1.getX());
        assertEquals(22, dotR1.getY());
        assertEquals(Color.R, dotR1.getColor());

        final Dot dotR2 = rDotList.get(1);
        assertEquals(12, dotR2.getX());
        assertEquals(22, dotR2.getY());
        assertEquals(Color.R, dotR2.getColor());

        final List<Shape> neighbouringShapesR = shapeR.getNeighbouringShapes();
        assertNotNull(neighbouringShapesR);
        assertEquals(1, neighbouringShapesR.size());

        final Shape neighbour = neighbouringShapesR.get(0);
        final List<Dot> neighbourDotList = neighbour.getDotList();
        assertEquals(4, neighbourDotList.size());
        assertEquals(Color.B, neighbourDotList.get(0).getColor());
    }

    @Test
    public void validate() throws Exception {
        final File file = new File("src/test/resources/input1.txt");
        final String result = Shapes.validate(file);
        final String expected = readFile("src/test/resources/result1.txt");
        assertEquals(expected, result);
    }

    private static String readFile(final String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

}
