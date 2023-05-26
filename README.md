# StarLobby
Copyright &copy; 2023 by CreeperBuildings, PhastixTV, ProJakob, JustCody

### Do not claim this plugin as yours



     _____ ______   ____  ____   _       ___   ____   ____   __ __ 
    / ___/|      | /    ||    \ | |     /   \ |    \ |    \ |  |  |
    (   \_ |      ||  o  ||  D  )| |    |     ||  o  )|  o  )|  |  |
    \__  ||_|  |_||     ||    / | |___ |  O  ||     ||     ||  ~  |
    /  \ |  |  |  |  _  ||    \ |     ||     ||  O  ||  O  ||___, |
    \    |  |  |  |  |  ||  .  \|     ||     ||     ||     ||     |
    \___|  |__|  |__|__||__|\_||_____| \___/ |_____||_____||____/



## Features: (All Features are configurable in config.yml)
- Custom Join and Leave Messages
- Custom Scoreboard (also per-permission!)
- Custom Tablist 
- Server Navigation
- Player Hider
- Join Signs (With CloudNET-Signs Support)
- Custom /help Command
- /gm Command
- /vanish Command
- /hub, /l, /lobby Command
- MySQL Support
- Bungee-Cord Support
- [CloudNET-Support](https://cloudnetservice.eu/de/)
- Full documented Developer-API

## Wiki
You will find help for installation and the developer-API including the Java-Docs in the [Wiki](docs/general)!

## Support
If you need support you can join on our Discord-Server: [Click me!](https://discord.gg/TuuFSU5mDD)

## Developer API
First, add the Maven Repository:
```XML
<repository>
  <id>cbmc-repository-starlobby</id>
  <name>CodeBlocksMC Repository</name>
  <url>http://play.codeblocksmc.de:8181/starlobby</url>
</repository>
```
Alternatively, you can use Gradle:
```KOTLIN
maven {
url = uri("http://play.codeblocksmc.de:8181/starlobby")
}
```

Now, add StarLobby as a dependency:
```XML
<dependency>
  <groupId>de.creeperbuildings</groupId>
  <artifactId>StarLobby</artifactId>
  <version>1.0</version>
</dependency>
```
Or with Gradle:
```KOTLIN
implementation("de.creeperbuildings:StarLobby:1.0")
```