
# ESCUELA COLOMBIANA DE INGENIERÍA
**Concurrencia, Paralelismo y Computacion de Alto Desempeño**

## JavaThreadsMemoriaCompartida

![image](https://user-images.githubusercontent.com/31891276/168431717-5b670f9f-8f68-4c01-99f2-fb2293bec127.png)


![image](https://user-images.githubusercontent.com/31891276/168431768-fad622c7-e46d-4682-a2de-7320a9fd43a6.png)


**Se piensa hacer una implementación de Java Threads basado en memoria compartida y con primitivas sincronización.**

Se plantea la construcción de cuatro clases:  

+ JugadorEscribe
+ JugadorLee
+ Recurso y por último una clase con el programa principal.

Se Construirá un arreglo bidimensional dispuesto en filas y columnas que representará la rejilla compartida por los procesos.  

**El clase jugador** extends threads,genera caracteres, es decir permite la escritura en el juego, establece a un posible usuario jugando en la terminal y almacena dichos caracteres en el recurso.

**Clase lector** extends threads, identificará las posiciones en la matriz producidas por los jugadores y los introducirá en una memoria de imagen simulada del juego, cuyo tamaño se establece de antemano. 

**Clase recurso** Implementa el recurso al que se quiere acceder se garantiza la sincronización pero solo habrá un escritor, permite el acceso concurrente de lectores.
