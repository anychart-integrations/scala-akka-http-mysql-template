[<img src="https://cdn.anychart.com/images/logo-transparent-segoe.png?2" width="234px" alt="AnyChart - Robust JavaScript/HTML5 Chart library for any project">](https://anychart.com)
Scala Akka Http basic template
=========================

This example shows how to run Anychart library with the Scala programming language using Akka Http and MySQL.

### Running
To use this sample you must have Java, Scala, SBT and Mysql installed,
if you do not have Java, please, visit [Java download page](https://java.com/download/);
if you do not have Scala, please, visit [Scala official site](http://www.scala-lang.org/);
if you do not have SBT, please, visit [SBT official site](http://www.scala-sbt.org/);
if you do not have MySQL, please, visit [MySQL download page](https://dev.mysql.com/downloads/installer/) and follow [instructions](http://dev.mysql.com/doc/refman/5.7/en/installing.html)

To check your Java installation, run following command in command line:
```
$ java -version
java version "1.8.0_111"        # sample output
Java(TM) SE Runtime Environment (build 1.8.0_111-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)
```
To check your Scala installation, run following command in command line:
```
$ scala -version
Scala code runner version 2.12.0 -- Copyright 2002-2016, LAMP/EPFL and Lightbend, Inc.     # sample output
```
To check your SBT installation, run following command in command line:
```
$ sbt help
[info] Set current project to user (in build file:/home/user/)...  # sample output
```
To check your MySQL installation, run following command in command line:
```
$ mysql --version
mysql  Ver 14.14 Distrib 5.5.52, for debian-linux-gnu (x86_64) using readline 6. # sample output
```

To start this example run commands listed below.

Clone the repository from github.com to your workspace folder:

```
$ git clone git@github.com:anychart-integrations/scala-akka-http-mysql-template.git
```

Navigate to the repository folder:
```
$ cd scala-akka-http-mysql-template
```

Set up MySQL database, use -u -p flags to provide your user name and password:
```
$  mysql < database_backup.sql
```

Run app:
```
$ sbt run
```

Open browser at http://localhost:8080/


## Workspace
Your workspace should look like:
```
scala-akka-http-mysql-template/
    project/
        project/
        target/
        build.properties
        plugins.sbt
    src/
        main/
            java/
            resources/
                static/
                    css/
                        style.css       # css style
                templates/
                    index.beard         # html template
            scala/
                Main.scala              # main scala app code
        test/
        ...
    target/
    .gitignore
    build.sbt                           # sbt application settings
    database_backup.sql                 # use this file to set your MySQL database
    LICENSE
    README.md
```

## Technologies
Platform - [Java](https://java.com/)<br />
Language - [Scala](http://www.scala-lang.org/)<br />
Database - [MySQL](https://www.mysql.com/)<br />
Web - [Akka Http](http://doc.akka.io/docs/akka-stream-and-http-experimental/1.0-M2/scala/http/)<br />
Template engine - [Beard](https://github.com/zalando/beard)<br />
Build tool - [SBT](http://www.scala-sbt.org/)

## Further Learning
* [Documentation](https://docs.anychart.com)
* [JavaScript API Reference](https://api.anychart.com)
* [Code Playground](https://playground.anychart.com)
* [Technical Support](https://anychart.com/support)

## License
[© AnyChart.com - JavaScript charts](http://www.anychart.com). Released under the [Apache 2.0 License](https://github.com/anychart-integrations/scala-akka-http-mysql-template/blob/master/LICENSE).
