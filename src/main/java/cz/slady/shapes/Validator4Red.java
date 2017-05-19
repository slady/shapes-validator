package cz.slady.shapes;

public class Validator4Red implements Validation {

    @Override
    public void validate(final ValidationModel model) {
        model.getShapesByColor(Color.R).stream().filter(
                shape -> shape.getDotList().size() > 5
        ).forEach(shape -> shape.setResult("Consists of more than 5 cells"));
    }

}
