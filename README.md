# Spanner - OpenCensus Example

### About Cloud Spanner

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
