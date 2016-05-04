package requestinjection;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Created by pjain11 on 4/25/16.
 */
public class TestModule implements Module
{
  public void configure(Binder binder)
  {
    binder.bind(String.class).toInstance("Injected");

    AClass aClass = new AClass("something");
    //binder.requestInjection(aClass);
    binder.bind(AClass.class).toInstance(aClass);
  }

  public static void main(String[] args)
  {
    Injector injector = Guice.createInjector(new TestModule());
    System.out.println(injector.getInstance(AClassProvider.class).getAClass().getInjectable());
    System.out.println("C "+injector.getInstance(CClass.class).getInjectable());

    System.out.println("A "+injector.getInstance(AClass.class).getInjectable());
    System.out.println("B "+injector.getInstance(BClass.class).getInjectable());

  }
}
