# Schema Inference for NoSQL Databases

NoSQL databases are becoming increasingly more popular due to their undeniable advantages in the context of storing and processing *big data*, mainly horizontal scalability and the lack of a requirement to define a data schema upfront. In the absence of explicit schema, however, an implicit schema inherent to the stored data still exists and can be *inferred*. Once inferred, a schema is of great value to the stakeholders and database maintainers. Nevertheless, the problem of schema inference is non-trivial and is still the subject of ongoing research. We explore the many aspects of NoSQL schema inference and data modeling, analyze a number of existing schema inference solutions in terms of their inner workings and capabilities, point out their shortcomings, and devise (1) a novel horizontally scalable approach based on the *Apache Spark* platform and (2) a new *NoSQL Schema* metamodel capable of modeling i.a. inter-entity referential relationships and deeply nested JSON constructs. We
then experimentally evaluate the newly designed approach along with the preexisting solutions with respect to their functional and performance capabilities.

## How to run

After downloading the repository, first make the gradle wrapper script executable:

```shell
$ chmod +x gradlew
```

Afterwards you can run all the implemented approaches using the following command:

```shell
$ ./gradlew run
```

Alternatively you can run the approaches selectively using:

```shell
$ ./gradlew :<approach>:run
```

The available approaches are `sevilla`, `baazizi`, `canovas`, and `frozza`.

Use the following command to run only the new (our) approach:

```shell
$ ./gradlew :run
```

---
NOTE: You can also just use `gradle` instead of `./gradlew`, if you have [Gradle](https://gradle.org/install/) installed and on PATH.

---

## Configuring parameters

Run parameters can be configured using [Gradle properties](https://docs.gradle.org/current/userguide/build_environment.html#sec:gradle_configuration_properties). These can be either modified in the `gradle.properties` files in repository root and in each of the subproject directories, or specified on the command line using the following syntax:

```
-P<key>=<value>
```

`<key>` can either be `allApproaches.<parameter>` to set the parameter for all approaches at once, or `<approach>.<parameter>`, in which case the parameter is set for the specified approach only. (Use `schemaInference.<parameter>` to set run parameters of our new approach.) The meanings of different parameters are explained in the following table:

### Common

| Parameter        | Meaning                                                             | Default value                 | Applicable approaches          |
| ---------------- | ------------------------------------------------------------------- | ----------------------------- | ------------------------------ |
| `mongoHost`      | The hostname of a running MongoDB server containing the input data. | `localhost`                   | all                            |
| `dbName`         | The name of the database containing the input data.                 | `inference(Extended)?`        | all                            |
| `outputFile`     | The path where the result of the inference will be stored.          | `build/schema.(txt,xml,json)` | all                            |
| `collectionName` | The name of the document collection containing the input data.      | `articles`                    | `baazizi`, `canovas`, `frozza` |
| `sparkMaster`    | The master URL for the Spark cluster.                               | `local[*]`                    | `baazizi`, `schemaInference`   |

---
**NOTE**

Based on the provided master URL, the Spark driver can function in a local or server mode. In local mode, the driver starts a number of threads in the local JVM to act as workers and no Spark server is necessary. In server mode, the driver uses the provided Spark master URL to connect to a standalone Spark cluster, which then handles the data processing. Refer to the [documentation](https://spark.apache.org/docs/latest/submitting-applications.html#master-urls) for more details.

---

### Sevilla

| Parameter      | Meaning                                                                            | Default value  |
| -------------- | ---------------------------------------------------------------------------------- | -------------- |
| `mapReduceDir` | The path to a directory containing the necessary `map.js` and `reduce.js` scripts. | `mapreduce/v2` |

### Baazizi

| Parameter     | Meaning                                                                                   | Default value |
| ------------- | ----------------------------------------------------------------------------------------- | ------------- |
| `equivalence` | The equivalence relation to use for the type reduction. Can be `k` (kind) or `l` (label). | `k`           |

### Canovas

| Parameter | Meaning                                                    | Default value |
| --------- | ---------------------------------------------------------- | ------------- |
| `jsonDir` | The path to a directory where the JSON data will be saved. | `json`        |

### Frozza

| Parameter          | Meaning                                                         | Default value           |
| ------------------ | --------------------------------------------------------------- | ----------------------- |
| `inferrerUrl`      | The URL where the schema inference tool is running.             | `http://localhost:3000` |
| `inferrerEmail`    | The email to use for authentication into the inference tool.    | `admin@example.com`     |
| `inferrerPassword` | The password to use for authentication into the inference tool. | `administrator`         |

## Frozza et al. approach

Due to its implementation as a web tool in Node.js, the Frozza et al. approach requires more setup than the other approaches.

1. Install Node.js either through your favorite package manager, or [here](https://nodejs.org/en/download/). `node` and `npm` must be available on PATH.
2. Use `./gradlew :frozza:start` to start the inference server. The server is available on `localhost:4200`. Please note that it can take up to a minute to start.
3. Register an account in the inference server.
4. Run the inference using `./gradlew :frozza:run`.
   * Provide the account credentials using [parameters](#frozza) `frozza.inferrerEmail` and `frozza.inferrerPassword`.
5. Stop the inference server using `./gradlew :frozza:stop` when you're done using it.

### Windows

The implementation depends on package `node-gyp` to work. `node-gyp` is notoriously difficult to install on Windows due to dependency on Windows SDK and build tools. Before running the Frozza et al. approach on Windows, you must install the `windows-build-tools` package using:

```shell
$ npm install --global --production windows-build-tools --vs2015
```

If this doesn't help, follow [further `node-gyp` troubleshooting tips here](https://spin.atomicobject.com/2019/03/27/node-gyp-windows/).
