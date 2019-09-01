# generator-microservices

<!---
[![start with why](https://img.shields.io/badge/start%20with-why%3F-brightgreen.svg?style=flat)](http://www.ted.com/talks/simon_sinek_how_great_leaders_inspire_action)
--->
[![GitHub release](https://img.shields.io/github/release/elbosso/generator-microservices/all.svg?maxAge=1)](https://GitHub.com/elbosso/generator-microservices/releases/)
[![GitHub tag](https://img.shields.io/github/tag/elbosso/generator-microservices.svg)](https://GitHub.com/elbosso/generator-microservices/tags/)
[![GitHub license](https://img.shields.io/github/license/elbosso/generator-microservices.svg)](https://github.com/elbosso/generator-microservices/blob/master/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/elbosso/generator-microservices.svg)](https://GitHub.com/elbosso/generator-microservices/issues/)
[![GitHub issues-closed](https://img.shields.io/github/issues-closed/elbosso/generator-microservices.svg)](https://GitHub.com/elbosso/generator-microservices/issues?q=is%3Aissue+is%3Aclosed)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/elbosso/generator-microservices/issues)
[![GitHub contributors](https://img.shields.io/github/contributors/elbosso/generator-microservices.svg)](https://GitHub.com/elbosso/generator-microservices/graphs/contributors/)
[![Github All Releases](https://img.shields.io/github/downloads/elbosso/generator-microservices/total.svg)](https://github.com/elbosso/generator-microservices)
[![Website elbosso.github.io](https://img.shields.io/website-up-down-green-red/https/elbosso.github.io.svg)](https://elbosso.github.io/)

## Overview

This project offers some of the test data generators i wrote as micro serices via http. One can use it either by just creating and starting the jar file by issuing the command

```
mvn compile package
```

and then starting the resulting monolithic jar file by issuing

```
$JAVA_HOME/bin/java -jar target/generator-microservices-<version>-jar-with-dependencies.jar
```
Alternatively one could just start the server using maven by  issuing

```
mvn compile exec:java
```

In both cases, the server starts on port 7000 - just point your browser to it and you see an overview of available generators together with their paths and possible parameters.

However the recommended mode of using this is to use the provided Dockerfile and docker-compose.yml file in src/main/resources. It is probably better to actually use a proxy solution like traefik (the docker-compose is already prepared for this) or similar
solutions so the services are actually accessible with a sound hostname and some default port.
