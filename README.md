# AREP_TallerDisponibilidadyDesempeno
Se realizó la implementación de un programa el cual realiza el ordenamiento de una lista de String utilizando el algoritmo merge sort.

## Pre-requisitos
* [MAVEN](https://maven.apache.org/) - Administrador de dependencias.
* [GIT](https://git-scm.com/) - Control de versiones.
Para estar seguro de las versiónes que posee de maven, git y de java ejecute los siguientes comandos:
```
mvn -version  
git --version  
java -version  
```
## Instalación 
Para descargar el proyecto desde GitHub ejecute la siguiente linea:
```
https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno.git
```

## Ejecutar
Dentro del directorio AREP_TallerDisponibilidadyDesempeno, desde la consola de comandos para compilar ejecutamos la siguiente linea:
```
mvn package
```
Para ejecutar el proyecto de manera local desde la consola de comandos ejecutamos la siguiente linea y desde un navegador buscamos `localhost:4567/` :
```
java -cp target/classes;target/dependency/* edu.escuelaing.arep.app.App
```

## Ejecutando las pruebas
Para correr las pruebas ejecutamos la siguiente linea:
```
mvn test
```

## Tutorial
1. Creamos una instancia EC2:
![EC2](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/EC2.jpg)

2. Instalamos docker en la maquina:
```
sudo yum install docker
sudo service docker start
sudo usermod -a -G docker ec2-user
```
-Reiniciamos la maquina para que se guarde la configuración del usuario

3. Descargamos la imagen de dockerhub:
```
docker pull carlosmurilloi/tallerdisponibilidad:latest
```
4. Ejecutar un contenedor con la imagen ya instalada
```
docker run -dp 80:6000 --name sortstring carlosmurilloi/tallerdisponibilidad:latest
```
5. Creamos una AMI de la instancia de la maquina EC2:
![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/image0.jpg)
![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/image1.png)
6. Creamos una configuración de lanzamiento con la AMI anteriormente creada:
![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/config0.jpg)
  - Escribimos el nombre que le queremos poner a la configuración.
  - Seleccionamos la AMI que queremos integrar.
  - Seleccionamos el tipo de instancia t2.micro
  ![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/config1.png)
  - Seleccionamos el mismo grupo de seguridad de la instancia anterior.
  ![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/config2.png)
7. Creamos el grupo de autoescalamiento:
![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/scaling0.jpg)
  - Escribimos el nombre que le queremos poner al grupo de seguridad.
  - Seleccionamos la configuración de lanzamiento que creamos anteriormente.
  ![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/scaling1.png)
  - Seleccionamos que se adhiera a la plantilla.
  - Seleccionamos dos de las subredes que nos oferece por defecto.
  ![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/scaling2.png)
  - Cambiamos la capacidad máxima a 4 y la capacidad recomendad a 3.
  ![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/scaling3.png)
  - Agregamos una politica de escalado con la condicion de que si excede el 80% de la cpu cree una nueva instacia.
  ![](https://github.com/Camu10/AREP_TallerDisponibilidadyDesempeno/blob/main/images/scaling4.png)


## Construido con
* [MAVEN](https://maven.apache.org/) - Administrador de dependencias.
* [GIT](https://git-scm.com/) - Control de versiones.
* [JUNIT](https://junit.org/junit5/) - Framework para realizar y automatizar pruebas.
* [SPARK](http://sparkjava.com/) - Framework para el desarrollo de aplicaciones web.
* CIRCLECI - Plataforma para realizar la integración continua. [![CircleCI](https://circleci.com/gh/Camu10/AREP_LAB2.svg?style=svg)](https://app.circleci.com/pipelines/github/Camu10/AREP_LAB2)
* [AWS](https://aws.amazon.com/es/console/) - Computación en la nube.
* [DOCKER](https://www.docker.com/) - Tecnología para el uso de contenedores.
* JAVA - Lenguaje de programación.

## Autor
* **Carlos Murillo** - [Camu10](https://github.com/Camu10)

## Licencia
Este proyecto está bajo la Licencia GNU(General Public License) - mira el archivo [LICENSE](LICENSE) para detalles.
