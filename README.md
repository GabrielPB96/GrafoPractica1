# **Práctica Grafos**
> Pantoja Bustamante Gabriel

El código base se encuentra en el paquete [***logic***](https://github.com/GabrielPB96/GrafoPractica1/tree/master/src/logic), la clase [***Main***](https://github.com/GabrielPB96/GrafoPractica1/tree/master/src/main/Main.java) en el paquete [***main***](https://github.com/GabrielPB96/GrafoPractica1/tree/master/src/main).

## **Implementación Base**

![Diagrama de Clases](./assets/diagramaG.png "Diagrama")

## **Métodos**
- [Número de Vertices](#número-de-vertices)
- [Número de Aristas](#número-de-aristas)
- [Existe Arista](#existe-arista)
- [Peso Arista](#peso-arista)
- [Insertar Arista](#insertar-arista)
- [Obtener Adyacentes](#obtener-adyacentes)
- [Dibujar Grafo](#dibujar-grafo)
- [Quitar Arista](#quitar-arista)
- [Es Grafo Completo](#es-grafo-completo)
- [Es Grafo Ciclo](#es-grafo-ciclo)
- [Es Grafo Rueda](#es-grafo-rueda)
- [Existe Bucle](#existe-bucle)

## **Lista de Adyacencia**

```java
  public class ListaAdyacencia implements Grafo{
    private HashMap<Integer, ArrayList<Vecino>> grafo;
    private boolean dirigido;
    private int cantVertices, cantAristas, cantLazos;
    private Verificador verificador;
  }
```

## **Número de Vertices.**

Retornar la variable que cuenta los Vertices.

## **Número de Aristas.**
Retornar la variable que cuenta las Aristas.

## **Existe Arista.**
Obtenemos los adyacentes del vertice origen, controlandoque    este exista, posteriormente verificamos si el verticedestino se   encuentra en los adyacentes del vertice origen.
## **Peso Arista.**
Obtenemos los adyacentes del vertice origen controlando queeste    existe. Buscamos el Vecino que coincida con elvertice destino y   obtenemos su peso.

## **Insertar Arista.**
Insertamos un nuevo elemento en la lista de adyacencia del vertice origen. Incrementamos el contador de aristas y si el     origen es igual al destino, incrementamos el contador de lazos.

## **Obtener Adyacentes.**
Retornar la lista asociada al vertice, si este noexiste,     devolvemos una lista vacia.

## **Dibujar Grafo.**

El paquete [***graphic***](https://github.com/GabrielPB96/GrafoPractica1/tree/master/src/graphic) contiene el graficador de grafos.

|              <center>Gráfico</center>          |  <center>Consola</center>     |
|-------------------------------|-------------|
| ![dibujo grafo](./assets/dibujoGrafo.png)   | ![mostrar grafo](./assets/outGrafo.png)   |


## **Quitar Arista.**


**Para los métodos restantes se créo una clase abstracta Verificador y dos subclases, VerificadorDirigido y VerificadorNoDirigido.**

![diagrama verificador](./assets/diagramaV.png)

## **Es Grafo Completo.**
Para que un grafo sea completo debe existir una arista para cada    par de vertices.
Para un grafo no dirigido esto se puede verificar usando   combinaciones, ya que la arista A-B es igual a B-A, las   combinaciones nos ayudan a no tomar en cuenta las aristas repetidas.
La cantidad de aristas debe ser igual a **_nC2_** donde n es la   cantidad de vertices.

![formula](./assets/f1.png)

Aplicando esta formula podemos verificar si un grafo es completo.
Para un grafo dirigido podemos hacer una pequeña modificación a     esta formula, si el grafo tiene dos aristas por cada par de     vertices este seria la cantidad maxima de aristas que puede     tener esto es ***2(nC2)***, y la cantidad minima de aristas que   puede tener y ser completo es **_nC2_**, entonces la cantidad de    aristas de un grafo dirigido debe estar entre estos dos valores   ***nC2 >= cantAristas <= 2(nC2)***.

## **Es Grafo Ciclo.**
Un grafo ciclo tiene la misma cantidad de vertices y aristas.

*Para un grafo dirigido verificados que las aristas tengan la misma dirección.*

## **Es Grafo Rueda.**

## **Existe Bucle.**


## **Resultados**
## Grafo 1

![grafo 1](./assets/grafo1.png)

## Grafo 2

![grafo 2](./assets/grafo2.png)

## Grafo 3

![grafo 3](./assets/grafo3.png)



