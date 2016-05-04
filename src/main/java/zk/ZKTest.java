package zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.BoundedExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceProvider;

public class ZKTest
{

  public static void main(String[] args)
  {
    CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                                                               .connectString("localhost")
                                                               .sessionTimeoutMs(3000)
                                                               .retryPolicy(new BoundedExponentialBackoffRetry(
                                                                   1000,
                                                                   45000,
                                                                   30
                                                               ))
                                                               .build();
    curatorFramework.start();
    ServiceDiscovery serviceDiscovery = ServiceDiscoveryBuilder.builder(Void.class)
                                                               .basePath("/druid/discovery")
                                                               .client(curatorFramework)
                                                               .build();

    try {
      serviceDiscovery.start();
      ServiceProvider brokerServiceProvider = serviceDiscovery.serviceProviderBuilder().serviceName("druid:broker").build();
      brokerServiceProvider.start();
      ServiceInstance serviceInstance = new ServiceInstance(
          "myservice",
          "myid",
          "localhost",
          2099,
          null,
          null,
          System.currentTimeMillis(),
          null,
          null
      );

      serviceDiscovery.registerService(serviceInstance);
      ServiceProvider myServiceProvider = serviceDiscovery.serviceProviderBuilder().serviceName("myservice").build();
      myServiceProvider.start();
      System.out.println(myServiceProvider.getInstance());
      System.out.println(brokerServiceProvider.getInstance());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
