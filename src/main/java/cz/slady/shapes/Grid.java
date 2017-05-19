package cz.slady.shapes;

import java.util.*;

public class Grid {

    private final Map<Integer, Map<Integer, Dot>> map = new HashMap<>();

    public Grid(final List<Dot> dotList) {
        dotList.forEach(dot -> {
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

        if (x != Integer.MIN_VALUE) {
            addNeighbour(result, x - 1, y);
        }

        if (x != Integer.MAX_VALUE) {
            addNeighbour(result, x + 1, y);
        }

        if (y != Integer.MIN_VALUE) {
            addNeighbour(result, x, y - 1);
        }

        if (y != Integer.MAX_VALUE) {
            addNeighbour(result, x, y + 1);
        }

        return result;
    }

    private void addNeighbour(List<Dot> result, int x, int y) {
        final Dot dot = get(x, y);

        if (dot == null) {
            return;
        }

        result.add(dot);
    }

}
