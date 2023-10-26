<!---
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-->
# JaCoCo Example

This example project is related to a blog article which describes the configuration 
to use JaCoCo in your [Apache Maven project][apache-maven].

This example project is related to the blog post:

* https://blog.soebes.io/posts/2023/10/2023-10-26-maven-jacoco-configuration/

## Requirements

* JDK21+
* Apache Maven 3.8+

The given code example can easily being changed to work with JDK version less than 17,
because you can simply replace the given `record` in the example with a usual 
final class implemented in the classical way. 

## JaCoCo Report

To create a full JaCoCo coverage report you could start via:

```bash
mvn clean verify
```

Creating a report which covers only the unit tests can be achieved by:

```bash
mvn clean verify -DskipITs
```

If you like to have the integration test reports only:

```bash
mvn clean verify -DskipUTs
```


[apache-maven]: https://maven.apache.org