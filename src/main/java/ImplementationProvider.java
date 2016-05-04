import com.google.inject.Provider;

public class ImplementationProvider implements ImplementMe, Provider<ImplementMe>{

    public void doSomething(String msg) {
        System.out.println("Hello "+msg);
    }

    public ImplementMe get() {
        return this;
    }
}
