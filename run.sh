#!/usr/bin/env bash
mvn package
clear
java -cp ./target/towerdefense-1.0-SNAPSHOT.jar com.towerdefense.launcher.Launcher