import com.google.inject.*;
import com.google.inject.name.Names;

public class GuiceModule implements Module{

    public void configure(Binder binder) {
        binder.bind(ImplementMe.class).toProvider(ImplementationProvider.class);
        binder.install(new ImplProvider());
        //binder.bind(ImplementMe.class).annotatedWith(Names.named("HI")).toProvider(ImplProvider.class);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule());
        //injector.getInstance(Key.get(ImplementMe.class, HI.class)).doSomething("world");
        injector.getInstance(Key.get(ImplementMe.class, Names.named("HI"))).doSomething("world");
        injector.getInstance(ImplementMe.class).doSomething("world!");
    }
}
