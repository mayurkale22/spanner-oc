# Spanner - OpenCensus Example

## About Cloud Spanner

[Cloud Spanner](https://cloud.google.com/spanner/) is a fully managed, mission-critical, 
relational database service that offers transactional consistency at global scale, 
schemas, SQL (ANSI 2011 with extensions), and automatic, synchronous replication 
for high availability.

Be sure to activate the Cloud Spanner API on the Developer's Console to
use Cloud Spanner from your project.

See the [Spanner client lib docs](https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/spanner/package-summary.html) to learn how to
interact with Cloud Spanner using this Client Library.

### Prerequisites
Please refer to the [getting
started](https://cloud.google.com/spanner/docs/getting-started/java/) guide.

### Authentication
See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

### To build the example
```bash
$ mvn clean package
```

### To Run the example
```bash
$ mvn exec:java -Dexec.mainClass=com.example.spanner.App
```

Go to http://localhost:8080/spanner/ and, start sending read request.

## OpenCensus agent

The `ocagent` can be run directly from sources, binary, or a Docker image. Here will try from the sources.

### Cloning source
Open up a new shell to get the OpenCensus agent
```bash
git clone https://github.com/census-instrumentation/opencensus-service.git && cd opencensus-service
```

### Building it
```bash
make agent
```
which will place the binary in the bin folder in your current working directory

### Running it
```bash
./bin/ocagent_darwin --config=/conf/config.yaml
```

