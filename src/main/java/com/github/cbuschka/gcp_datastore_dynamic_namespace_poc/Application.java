package com.github.cbuschka.gcp_datastore_dynamic_namespace_poc;

import com.google.cloud.spring.data.datastore.repository.config.EnableDatastoreRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDatastoreRepositories
public class Application
{
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(Application.class, args).close();
	}
}
