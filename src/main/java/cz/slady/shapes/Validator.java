package cz.slady.shapes;

import java.util.ArrayList;
import java.util.List;

public class Validator implements Validation {

    private final List<Validation> validationList = new ArrayList<>();

    public Validator() {
        validationList.add(new Validator1Green());
        validationList.add(new ValidatorOK());
    }

    @Override
    public void validate(final ValidationModel model) {
        validationList.stream().forEach(x -> x.validate(model));
    }

}
