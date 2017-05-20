package cz.slady.shapes;

import java.util.stream.Collectors;

public class Validator7Average implements Validation {

    @Override
    public void validate(final ValidationModel model) {
        model.getShapes().stream().collect(Collectors.groupingBy(Shape::getColor)).entrySet().stream().filter(
                map -> (map.getValue().size() * 5) <= map.getValue().stream().mapToInt(shape -> shape.getDotList().size()).sum()
        ).forEach(map -> map.getValue().forEach(shape -> shape.setResult("Average number of cells per structure is not less than 5")));
    }

}
