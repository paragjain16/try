package mapbinder;

import com.google.inject.*;
import com.google.inject.util.Types;

import java.util.Map;
import java.util.function.BiConsumer;

public class TryInject {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ModuleOne(), new ModuleTwo());
        injector.getAllBindings().forEach(
                new BiConsumer<Key<?>, Binding<?>>() {
                    public void accept(Key<?> key, Binding<?> binding) {
                        //System.out.println(key);
                        //System.out.println(binding);
                    }
                }
        );

        Map implsMap = (Map<String, Provider<ImplementMe>>) injector.getInstance(Key.get(Types.mapOf(String.class, ImplementMe.class)));
        ((ImplementMe)implsMap.get("one")).doSomething("world");
    }
}
