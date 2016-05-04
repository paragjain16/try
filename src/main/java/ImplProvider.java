import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class ImplProvider implements Module{

    /*public void doSomething(String msg) {
        System.out.println("HI "+msg);
    }*/

    @Provides
    @Named("HI")
    //@HI
    public ImplementMe get() {
        return new ImplementMe() {
            public void doSomething(String msg) {
                System.out.println("Hi, "+msg);
            }
        };
    }

    public void configure(Binder binder) {
        //binder.bind(ImplProvider.class).annotatedWith(HI.class).toInstance(this);
    }
}
