package com.github.cbuschka.gcp_datastore_dynamic_namespace_poc;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class Thing
{
	@Id
	private String key;

	private String name;

	public Thing()
	{
	}

	public Thing(String key, String name)
	{
		this.key = key;
		this.name = name;
	}
}
