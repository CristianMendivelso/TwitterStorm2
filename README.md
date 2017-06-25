storm-word-count
================

Contador de Palabras de Twitter Utilizando la Herramienta Apache Storm Basado en https://github.com/jalonsoramos/storm-word-count y utlizando las caracterísitcas de Streaming del mismo.

Este es un repositorio que se utilizará para un proyecto de investigación de la Escuela Colombiana de Ingeniería Julio Garavito

Se ha actualizado el proyecto para ser usado en apache storm 1.1.0, y se ha ampliado para ser usado no sólo en modo local si no también en modo cluster.

Actualmente el repositorio contiene 2 ramas:

-Master (Para Correr En Modo Local)
-Cluster (Para Correr En Modo Cluster)

Rama Cluster: Para Ejecutar Esta Aplicación Es Necesario:

Clonar el repositorio
Ir a la carpeta del repositorio y ejecutar el comando : mvn clean package assembly:single
En el nodo nimbus ir a la carpeta de apache storm y bin/storm jar /home/ubuntu/experimentos/TwitterStorm2/target/storm-word-count-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.autentia.tutoriales.WordCountTopology twitter2

Para cambiar la cantidad de trabajadores solamente es editar la línea config.setNumWorkers(3); en WordCountTopology.java
