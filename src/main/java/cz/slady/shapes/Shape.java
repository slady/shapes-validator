package cz.slady.shapes;

import java.util.ArrayList;
import java.util.List;

public class Shape {

    private final List<Dot> dotList = new ArrayList<>();

    public void add(Dot dot) {
        dot.setParent(this);
        dotList.add(dot);
    }

    public List<Dot> getDotList() {
        return dotList;
    }

}
