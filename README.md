# SkyAPI

SkyAPI is an ligthwight open source api. At the moment there is only one API module developed. For documentation you can read the **wiki entry** or use the java docs.

## Functions/Modules
At the moment there is only the simple to use Inventory API implemented.
##Implementing the API
There is actually one supported way to implement this API to your Plugin.
### Maven
Repository:
```xml
<repository>
	<id>hufeisen-games-repo</id>
	<url>http://repo.hufeisen-games.de/maven2</url>
</repository>
```
Dependency:
```xml
<dependency>
	<groupId>de.hufeisen-games.repo</groupId>
	<artifactId>SkyAPI</artifactId>
	<version>VERSION</version>
</dependency>
```
You have to replace VERSION with the Version you will use(current 1.2). You have to put the API into the plugin folder or use the maven shade plugin.

## Getting Started
At first you have to enable the API and the modules.
```java
new SkyAPI(this, APIMODULES);
```
You have to replace APIMODULES with the modules you want to activate. Currently there is only the InventoryAPI. Here you have another example:
```java
new SkyAPI(this, API.Inventory);
```
You are now able to create a new SkyInventory! For more documentation you can read the **wiki**.
## Roadmap
I am already working on an Scoreboard API. Feel free to contribute to the project an report bugs in the issue section. Here is a short list of planned modules:
- Scoreboard
- Holograms
- Database
- NPCs
