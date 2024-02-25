# Getting Started

This is a simple REST API endpoint that provides a list of GitHub repositories list of given usernames.

### Requirments

* Java 21
* Gradle

### Usage

**IMPORTANT** :
Because this API using GitHub API with non-authenticated user, please be aware about request limit.

Before usage, you will have to run API endpoint server by:

```bash
gradle build # compile projets files ( run only first time )
gradle bootRun # running Spring app
```

in other terminal tab you can run now below command:

```bash
curl -H "Content-Type: application/json" http://localhost:8080/list_repository/przemosk
```
