package multiset;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.util.Set;
import java.util.function.Consumer;

public class TryGuice {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ModuleOne(), new ModuleTwo());
        Set<MultiImpl> multiImplSet =  injector.getInstance(Key.get(new TypeLiteral<Set<MultiImpl>>(){}));
        multiImplSet.forEach(new Consumer<MultiImpl>() {
            public void accept(MultiImpl multi) {
                System.out.println(multi);
            }
        });

    }
}
