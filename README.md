Procesador Estadístico
================================

Para recompilar la aplicación a JAR puede usar el script jar.sh

```shell
# sh jar.sh
```

## Funcionamiento

### Modo OnDemand

```shell
# java -jar procesadorEstadistico.jar directorio/de/entradas
```

El directorio puede ser absoluto o relativo.

### Modo Daemon

```shell
# java -jar procesadorEstadistico.jar directorio/de/entradas -d
```
