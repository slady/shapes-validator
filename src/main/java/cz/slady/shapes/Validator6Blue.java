package cz.slady.shapes;

import java.util.Collection;

public class Validator6Blue implements Validation {

    @Override
    public void validate(ValidationModel model) {
        final Collection<Shape> blueShapes = model.getShapesByColor(Color.B);
        if (blueShapes.size() > 2) {
            blueShapes.forEach(shape -> shape.setResult("More than two blue structures in the grid"));
        }
    }

}
