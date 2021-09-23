package com.github.cbuschka.gcp_datastore_dynamic_namespace_poc;

import com.google.cloud.spring.autoconfigure.datastore.DatastoreProvider;
import com.google.cloud.spring.data.datastore.core.convert.DatastoreServiceObjectToKeyFactory;
import com.google.cloud.spring.data.datastore.core.convert.ObjectToKeyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NamespaceContextAwareDatastoreConfiguration {

  @Bean
  public ObjectToKeyFactory objectToKeyFactory(DatastoreProvider datastore) {
    return new DatastoreServiceObjectToKeyFactory(
        () -> NamespaceContextAwareDatastoreWrapper.wrap(datastore.get()));
  }
}
