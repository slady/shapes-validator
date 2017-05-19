package cz.slady.shapes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Row {

    private final List<Dot> dotList = new ArrayList<>();

    private final int row;

    private List<Dot> sortedDotList;

    public Row(final int row) {
        this.row = row;
    }

    public void add(final Dot dot) {
        dotList.add(dot);
    }

    public int getRow() {
        return row;
    }

    public void sort() {
        sortedDotList = new ArrayList<>(dotList);
        sortedDotList.sort(Comparator.comparingInt(Dot::getX));
    }

    public List<Dot> getSortedDotList() {
        return sortedDotList;
    }

}
