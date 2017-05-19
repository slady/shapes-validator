package cz.slady.shapes;

import org.junit.Test;

import java.io.File;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void get() throws Exception {
        final File file = new File("src/test/resources/input1.txt");
        final List<Dot> dotList = Shapes.readDotList(file);
        final Grid grid = new Grid(dotList);

        final Dot dotG = grid.get(7, 22);
        assertEquals(7, dotG.getX());
        assertEquals(22, dotG.getY());
        assertEquals(Color.G, dotG.getColor());

        final Dot dotR1 = grid.get(11, 22);
        assertEquals(11, dotR1.getX());
        assertEquals(22, dotR1.getY());
        assertEquals(Color.R, dotR1.getColor());

        final Dot dotR2 = grid.get(12, 22);
        assertEquals(12, dotR2.getX());
        assertEquals(22, dotR2.getY());
        assertEquals(Color.R, dotR2.getColor());
    }

}
