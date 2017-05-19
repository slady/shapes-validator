package cz.slady.shapes;

public class Validator1Green implements Validation {

    @Override
    public void validate(final ValidationModel model) {
        model.getShapesByColor(Color.G).stream().filter(
                shape -> shape.getNeighbouringShapes().stream().filter(f -> f.getColor() == Color.B).count() == 0
        ).forEach(shape -> {
            shape.setResult("No adjacent blue structure");
        });
    }

}
