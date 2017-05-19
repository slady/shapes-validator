package cz.slady.shapes;

public class ValidatorOK implements Validation {

    @Override
    public void validate(final ValidationModel model) {
        model.getShapes().stream().forEach(shape -> shape.setResult("OK"));
    }

}
