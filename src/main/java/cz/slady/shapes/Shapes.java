package cz.slady.shapes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Shapes {

    public static String validate(final File inputFile) throws IOException {
        final List<Dot> dotList = readDotList(inputFile);
        final Grid grid = new Grid(dotList);
        final List<Shape> shapeList = createShapes(dotList, grid);
        final ValidationModel model = new ValidationModel(shapeList);
        final Validator validator = new Validator();
        validator.validate(model);
        return dotListToString(dotList);
    }

    public static List<Shape> createShapesFromInputFile(File inputFile) throws FileNotFoundException {
        final List<Dot> dotList = readDotList(inputFile);
        final Grid grid = new Grid(dotList);
        return createShapes(dotList, grid);
    }

    public static List<Dot> readDotList(final File inputFile) throws FileNotFoundException {
        final Scanner scanner = new Scanner(inputFile);
        scanner.useDelimiter(",");

        final List<Dot> result = new ArrayList<>();

        while (scanner.hasNextLine()) {
            final int x = scanner.nextInt();
            final int y = scanner.nextInt();
            final String rest = scanner.nextLine();
            final char colorChar = rest.charAt(1);
            final String comment = rest.substring(3);
            final Dot dot = new Dot(x, y, colorChar, comment);
            result.add(dot);
        }

        return result;
    }

    public static List<Row> convertDotListToRowList(final List<Dot> dotList) {
        final Map<Integer, Row> rowMap = new HashMap<>();

        for (final Dot dot : dotList) {
            final int y = dot.getY();
            rowMap.computeIfAbsent(y, x -> new Row(y));
            rowMap.get(y).add(dot);
        }

        final List<Row> sortedRowCollection = new ArrayList<>(rowMap.values());
        sortedRowCollection.sort(Comparator.comparingInt(Row::getRow));
        sortedRowCollection.forEach(Row::sort);

        return sortedRowCollection;
    }

    private static List<Shape> createShapes(final List<Dot> dotList, final Grid grid) {
        final List<Shape> result = dotList.stream().filter(dot -> dot.getParent() == null).map(
                dot -> createShapeFloodFill(dot, grid)).collect(Collectors.toList());
        findNeighbouringShapes(result, grid);

        return result;
    }

    private static Shape createShapeFloodFill(final Dot dot, final Grid grid) {
        final Shape shape = new Shape();
        final Color c = dot.getColor();

        Collection<Dot> neighbourList = Collections.singletonList(dot);

        while (!neighbourList.isEmpty()) {
            neighbourList.forEach(shape::add);
            neighbourList = neighbourList.stream().flatMap(
                d -> grid.getNeighbours(d).stream().filter(
                        f -> f.getParent() == null && f.getColor() == c)).distinct().collect(Collectors.toList());
        }

        return shape;
    }

    private static void findNeighbouringShapes(final List<Shape> shapeList, final Grid grid) {
        shapeList.forEach(shape ->
            shape.setNeighbouringShapes(
                shape.getDotList().stream().flatMap(
                    dot -> grid.getNeighbours(dot).stream().filter(f -> f.getColor() != dot.getColor()))
                        .map(Dot::getParent).distinct().collect(Collectors.toList())));
    }

    private static String dotListToString(final List<Dot> dotList) {
        final StringBuilder buf = new StringBuilder();
        dotList.forEach(dot -> buf.append(dot.toString() + '\n'));
        return buf.toString();
    }

}
