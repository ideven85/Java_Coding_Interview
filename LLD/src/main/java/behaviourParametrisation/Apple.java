package behaviourParametrisation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Apple {

    private String color;

    private int weight;

    @Override
    public String toString() {
        return "Apple has color: " + getColor() + " with weight: " + getWeight();

    }
}
