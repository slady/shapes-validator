package cz.slady.shapes;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationModel {

    private final List<Shape> shapeList;

    public ValidationModel(final List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public Collection<Shape> getShapesByColor(final Color color) {
        return shapeList.stream().filter(shape -> shape.getColor() == color).collect(Collectors.toList());
    }

    public List<Shape> getShapes() {
        return shapeList;
    }

}
