package cz.slady.shapes;

import java.util.stream.Collectors;

public class Validator5Yellow implements Validation {

    @Override
    public void validate(final ValidationModel model) {
        model.getShapesByColor(Color.Y).stream().filter(
                shape -> shape.getDotList().stream().map(dot -> dot.getX()).collect(Collectors.toSet()).size() > 1
                && shape.getDotList().stream().map(dot -> dot.getY()).collect(Collectors.toSet()).size() > 1
        ).forEach(
                shape -> shape.setResult("Not linear"));
    }

}
