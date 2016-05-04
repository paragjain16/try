package mapbinder;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.multibindings.MapBinder;


public class ModuleOne implements Module {
    public void configure(Binder binder) {
        MapBinder.newMapBinder(binder, String.class, ImplementMe.class).addBinding("one").to(ImplOne.class);
    }
}
