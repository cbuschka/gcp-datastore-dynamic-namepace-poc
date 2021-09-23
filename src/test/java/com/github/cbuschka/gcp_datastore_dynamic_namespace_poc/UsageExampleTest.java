package com.github.cbuschka.gcp_datastore_dynamic_namespace_poc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UsageExampleTest {

  @Autowired
  private ThingRepository thingRepository;

  @Test
  void testNamespace1() {
    NamespaceContext.runWith("namespace1", () -> {
      var aThing = new Thing(UUID.randomUUID().toString(), "Yoyodine Frobulator");
      thingRepository.save(aThing);
    });
  }

  @Test
  void testNamespace2() {
    NamespaceContext.runWith("namespace2", () -> {
      var aThing = new Thing(UUID.randomUUID().toString(), "Yoyodine Frobulator");
      thingRepository.save(aThing);
    });
  }
}
