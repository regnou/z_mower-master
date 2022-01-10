## Synopsis

Exercise from Xebia to test my coding skills.

## Installation

For development with a log level `DEBUG`:
```sh
$ mvn -Pdev install
```

For production with a log level `INFO`:
```sh
$ mvn -Pprod install
```

## Running

There is multiple way to run this application. You can run it as a simple command line application with argument.

```sh
$ java -jar target/mow-it-now-1.2.7.RELEASE.jar --inputFile=/your/path/instruction.txt --outputFile=/your/path/result.txt
```

You can use an externalized configuration file with the following properties:

```
inputFile=/your/path/instruction.txt
outputFile=/your/path/result.txt
```

And run it with:

```sh
$ java -jar target/mow-it-now-1.2.7.RELEASE.jar --spring.config.location=/your/path/application.properties
```

If you don't arguments arguments, it will use the default **application.properties** of `src/main/resources`.

## Tests

To run the tests, use :
```sh
$ mvn test
```
