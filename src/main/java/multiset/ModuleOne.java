package multiset;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.multibindings.Multibinder;

public class ModuleOne implements Module {

    public void configure(Binder binder) {
        Multibinder<MultiImpl> multibinder = Multibinder.newSetBinder(binder, MultiImpl.class);
        multibinder.addBinding().to(StringImpl.class);
    }
}
