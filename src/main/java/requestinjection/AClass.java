package requestinjection;

import com.google.inject.Inject;

/**
 * Created by pjain11 on 4/25/16.
 */
public class AClass
{

  @Inject
  String injectable;

  public AClass(String injectable) {
    this.injectable = injectable;
  }

  public String getInjectable() {
    return injectable;
  }

}
