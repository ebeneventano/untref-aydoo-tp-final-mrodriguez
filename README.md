Procesador Estadístico
================================

Para recompilar la aplicación a JAR puede usar el script jar.sh

```shell
# sh jar.sh
```

## Funcionamiento

El directorio puede ser absoluto o relativo.

### Modo OnDemand

```shell
# java -jar procesadorEstadistico.jar /directorio/de/entradas
```
```shell
# java -jar procesadorEstadistico.jar /directorio/de/entradas --on-demand
```

#### Ejemplo
```shell
# java -jar procesadorEstadistico.jar entradas/
```

### Modo Daemon

```shell
# java -jar procesadorEstadistico.jar directorio/de/entradas -d
```
```shell
# java -jar procesadorEstadistico.jar directorio/de/entradas --daemon
```

#### Ejemplo
```shell
# java -jar procesadorEstadistico.jar entradas/ -d
```

#### Jar con cambios implementados por Emmanuel Benenventano
Se agregó un .jar llamado procesador-ebeneventano-mrodriguez.jar que se corre de la misma manera que lo explicado anteriormente.

#### Documentacion
Se agrega un archivo llamado "documentacion.txt", ubicado en la carpeta docs, que contiene el resultado de la medición y las mejoras aplicadas.

IMPORTANTE: Se debe respetar el órden de los triggers.
