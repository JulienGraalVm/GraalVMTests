# About
This repository is made to perform some test with Spring boot and GraalVM

# Prerequisites
GRAALVM_HOME is set to latest version of GraalVM, installed with sdkman! to benefit from latest options.
Currently:
```shell
native-image 24 2025-03-18
GraalVM Runtime Environment Oracle GraalVM 24-dev+13.1 (build 24+13-jvmci-b01)
Substrate VM Oracle GraalVM 24-dev+13.1 (build 24+13, serial gc, compressed references)
```

JAVA_HOME is set to a GraalVM JDK, installed with sdkman!.
Currently:
```shell
java version "21.0.4" 2024-07-16 LTS
Java(TM) SE Runtime Environment Oracle GraalVM 21.0.4+8.1 (build 21.0.4+8-LTS-jvmci-23.1-b41)
Java HotSpot(TM) 64-Bit Server VM Oracle GraalVM 21.0.4+8.1 (build 21.0.4+8-LTS-jvmci-23.1-b41, mixed mode, sharing)
```

Maven is managed with sdkman! also.
Currently:
```shell
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Java version: 21.0.4, vendor: Oracle Corporation, runtime: 
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.15.0-122-generic", arch: "amd64", family: "unix"
```