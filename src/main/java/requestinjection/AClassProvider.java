package requestinjection;

import com.google.inject.Inject;

/**
 * Created by pjain11 on 4/25/16.
 */
public class AClassProvider
{
  private String injectable;

  @Inject
  public AClassProvider(String injectable) {
    this.injectable = injectable;
  }

  public AClass getAClass(){
    return new AClass(injectable);
  }
}
