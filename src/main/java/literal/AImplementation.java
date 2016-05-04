package literal;

import com.google.inject.TypeLiteral;

public class AImplementation implements AInterface {
    public TypeLiteral getType() {
        return new TypeLiteral<AImplementation>(){};
    }
}
