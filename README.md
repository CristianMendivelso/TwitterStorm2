Contador de Palabras Utilizando API de Twitter y Apache Storm
================

##### RAMA eketalhigh

Este repositorio contiene todo lo relacionado al proyecto: 
Contador de Palabras de Twitter Utilizando la Herramienta **Apache Storm** Basado en https://github.com/jalonsoramos/storm-word-count y utilizando las caracterísitcas de Streaming del mismo.

Además se presenta la implementación de la herramienta [Eketal](https://github.com/unicesi/eketal "Eketal") en este experimento.

Este es un repositorio que se utilizará para un proyecto de investigación de la **Escuela Colombiana de Ingeniería Julio Garavito**.

Se ha actualizado el proyecto para ser usado en apache storm 1.1.0, y se ha ampliado para ser usado no sólo en modo local si no también en modo cluster.
Además de lo anterior se ha implementado en el modo cluster 3 tipos de instrumentaciones con la herramienta [Eketal](https://github.com/unicesi/eketal "Eketal")

-**eketalhigh ** (Repositorio Para Correr en Modo Cluster Implementado Eketal De Media Frecuencia)

**Para Ejecutar Esta Aplicación Es Necesario:
**
Clonar el repositorio
Ir a la carpeta del repositorio y ejecutar el comando : 

mvn clean package

En el nodo nimbus ir a la carpeta de apache storm y ejecutar el comando: **bin/storm jar /[ruta a la carpeta contenedora]/TwitterStorm2/target/storm-word-count-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.autentia.tutoriales.WordCountTopology twitter2**

Para cambiar la cantidad de trabajadores solamente es editar la línea config.setNumWorkers(3); 
en la clase *WordCountTopology.java* .


En el **Modo Local**  la salida se genera por consola

En el **Modo Cluster** la salida se genera en un archivo .txt el cual se aconseja cambiar de ruta en la clase  **CountPrinterBolt** 


Cualquier sugerencia respecto al respositorio por favor añadir una *Issue* .

