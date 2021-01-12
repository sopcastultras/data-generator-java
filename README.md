### Example of automation using CLI

### Requirements:

* [GraalVM](https://www.graalvm.org/reference-manual/native-image)

### Build a Native Image:
```gradlew clean nativeImage```

### Get Help:
```./build/graal/main RUN --help```

### Generate data file:
```./build/graal/main RUN --filename file.xml --datatype xml --count 3```  