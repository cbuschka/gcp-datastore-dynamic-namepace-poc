package com.github.cbuschka.gcp_datastore_dynamic_namespace_poc;

public class NamespaceContext {

  private static final /* Inheritable? */ ThreadLocal<NamespaceContext> threadLocalContextHolder = new ThreadLocal<>();

  private String namespace;

  private NamespaceContext(String namespace) {
    this.namespace = namespace;
  }

  public static void runWith(String namespace, Runnable r) {
    NamespaceContext prev = null;
    try {
      prev = threadLocalContextHolder.get();
      threadLocalContextHolder.set(new NamespaceContext(namespace));
      r.run();
    } finally {
      if (prev != null) {
        threadLocalContextHolder.set(prev);
      } else {
        threadLocalContextHolder.remove();
      }
    }
  }

  public static String getCurrentNamespace() {
    var context = threadLocalContextHolder.get();
    if (context == null) {
      throw new IllegalStateException("No namespace context set.");
    }
    return context.namespace;
  }

}
