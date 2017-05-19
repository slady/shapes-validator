package cz.slady.shapes;

import java.util.*;

public class Grid {

    private final Map<Integer, Map<Integer, Dot>> map = new HashMap<>();

    public Grid(final Collection<Row> rowList) {
        for (final Row row : rowList) {
            final Map<Integer, Dot> rowMap = new HashMap<>();
            map.put(row.getRow(), rowMap);

            final List<Dot> dotList = row.getSortedDotList();
            for (final Dot dot : dotList) {
                rowMap.put(dot.getX(), dot);
            }
        }
    }

    public Grid(final List<Dot> dotList) {
        dotList.stream().forEach(dot -> {
            final int y = dot.getY();
            map.computeIfAbsent(y, HashMap::new);
            map.get(y).put(dot.getX(), dot);
        });
    }

    public Dot get(final int x, final int y) {
        final Map<Integer, Dot> rowMap = map.get(y);

        if (rowMap == null) {
            return null;
        }

        return rowMap.get(x);
    }

    public Collection<Dot> getNeighbours(Dot dot) {
        final List<Dot> result = new ArrayList<>();
        final int x = dot.getX();
        final int y = dot.getY();
        final Color c = dot.getColor();

        if (x != Integer.MIN_VALUE) {
            addNeighbour(result, c, x - 1, y);
        }

        if (x != Integer.MAX_VALUE) {
            addNeighbour(result, c, x + 1, y);
        }

        if (y != Integer.MIN_VALUE) {
            addNeighbour(result, c, x, y - 1);
        }

        if (y != Integer.MAX_VALUE) {
            addNeighbour(result, c, x, y + 1);
        }

        return result;
    }

    private void addNeighbour(List<Dot> result, Color c, int x, int y) {
        final Dot dot = get(x, y);

        if (dot == null || dot.getParent() != null) {
            return;
        }

        result.add(dot);
    }

}
