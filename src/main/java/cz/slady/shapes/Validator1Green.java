package cz.slady.shapes;

public class Validator1Green implements Validation {

    @Override
    public void validate(final ValidationModel model) {
        model.getShapesByColor(Color.G).stream().filter(
                shape -> shape.getNeighbouringShapes().stream().filter(f -> f.getColor() == Color.B).count() == 0
        ).forEach(shape -> {
            shape.getDotList().stream().forEach(dot -> dot.setResult("No adjacent blue structure"));
        });
    }

}
