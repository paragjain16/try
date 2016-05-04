package requestinjection;

import com.google.inject.Inject;

/**
 * Created by pjain11 on 4/25/16.
 */
public class BClass
{
  private String injectable;

  @Inject
  public BClass(String injectable) {
    this.injectable = injectable;
  }

  public String getInjectable() {
    return injectable;
  }
}
