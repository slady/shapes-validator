package cz.slady.shapes;

import java.util.ArrayList;
import java.util.List;

public class Validator implements Validation {

    private final List<Validation> validationList = new ArrayList<>();

    public Validator() {

    }

    @Override
    public void validate(final ValidationModel model) {
        validationList.stream().forEach(x -> x.validate(model));
    }

}
