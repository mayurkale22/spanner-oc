package com.example.spanner;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/spanner")
public class PersonController {

	private Spanner spanner;
	private DatabaseClient dbClient;
	String instanceId = "demo";
	String databaseId = "hello_spanner";
	String table = "Players";

	PersonController() {
		// Instantiate the client.
		SpannerOptions options = SpannerOptions.getDefaultInstance();
		spanner = options.getService();
		// And then create the Spanner database client.
		String projectId = options.getProjectId();
		dbClient = spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));

		//BasicSetup.enableOpenCensus();
	}

	@GetMapping(path="/", produces = "application/json")
	public List<Person> getPerson() {
		List<Person> list = new ArrayList<>();
		try (ResultSet resultSet = dbClient
			.singleUse()
			.read(
				table,
				KeySet.all(), // Read all rows in a table.
				Arrays.asList("first_name", "last_name", "uuid"))) {
			while (resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getString(0));
				person.setName(resultSet.getString(1));
				person.setEmail(resultSet.getString(2));
				list.add(person);
			}
		}
		return list;
	}

	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public Person addPerson(@RequestBody Person p) {
		List<Mutation> mutations =
			Collections.singletonList(Mutation.newInsertBuilder(table)
				.set("id")
				.to(UUID.randomUUID().toString())
				.set("name")
				.to(p.getName())
				.set("email")
				.to(p.getEmail())
				.build());
		dbClient.write(mutations);
		return p;
	}
}
