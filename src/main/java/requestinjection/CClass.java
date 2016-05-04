package requestinjection;

import com.google.inject.Inject;

/**
 * Created by pjain11 on 4/25/16.
 */
public class CClass
{
  @Inject
  String injectable;

  public String getInjectable() {
    return injectable;
  }
}
