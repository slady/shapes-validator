package cz.slady.shapes;

public class Validator2Red implements Validation {

    @Override
    public void validate(ValidationModel model) {
        model.getShapesByColor(Color.R).stream().filter(
                shape -> shape.getNeighbouringShapes().size() > 1
        ).forEach(shape -> shape.setResult("More than one another adjacent structure"));
    }

}
