package com.github.cbuschka.gcp_datastore_dynamic_namespace_poc;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.KeyFactory;
import java.lang.reflect.Method;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class NamespaceContextAwareDatastoreWrapper {

  public static Datastore wrap(Datastore datastore) {

    return (Datastore) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
        new Class[]{Datastore.class},
        new InvocationHandler() {
          @Override
          public Object invoke(Object o, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("newKeyFactory")) {
              String namespace = NamespaceContext.getCurrentNamespace();
              KeyFactory origKeyFactory = datastore.newKeyFactory();
              origKeyFactory.setKind("dummy");
              IncompleteKey dummyKey = origKeyFactory.newKey();
              return new KeyFactory(dummyKey.getProjectId(), namespace);
            }

            return method.invoke(o, args);
          }
        });
  }
}
