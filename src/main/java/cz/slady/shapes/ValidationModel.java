package cz.slady.shapes;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidationModel {

    private final List<Shape> shapeList;
    private final Map<Color, List<Shape>> colorShapeListMap;

    public ValidationModel(final List<Shape> shapeList) {
        this.shapeList = shapeList;
        this.colorShapeListMap = shapeList.stream().collect(Collectors.groupingBy(Shape::getColor));
    }

    public Collection<Shape> getShapesByColor(final Color color) {
        return colorShapeListMap.get(color);
    }

    public List<Shape> getShapes() {
        return shapeList;
    }

}
