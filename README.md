jBPM Model Classpath
====================

This project is used to serve as an example, and playground for solutions, for a classpath issue in jBPM. Take the represented use case:

Maven artifacts
* awesome-app : parent project managing dependency versions
* awesome-model : model jar containing common classes
* awesome-kjar : kjar containing business processes
* awesome-web-app : client war used to create business processes

This app is responsible for starting a process to determine the party at fault in an accident. This process starts with an `Accident` object. Over time many accidents are logged and, as any software project does, the model classes change. Specifically the `Accident` class gets updated. There is only one version of the awesome-web-app deployed at any given time but there are business processes that have been started with various versions of the model jar. How can the client application interact with those business processes?
