package com.github.cbuschka.gcp_datastore_dynamic_namespace_poc;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThingRepository extends DatastoreRepository<Thing, UUID>
{
}
