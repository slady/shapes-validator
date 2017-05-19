package cz.slady.shapes;

public class Validator3Yellow implements Validation {

    @Override
    public void validate(ValidationModel model) {
        model.getShapesByColor(Color.Y).stream().filter(
                shape -> shape.getNeighbouringShapes().stream().filter(s -> s.getColor() == Color.G).count() > 0
        ).forEach(shape -> shape.setResult("Has an adjacent green structure"));
    }

}
