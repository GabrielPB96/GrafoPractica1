# Práctica Grafos
> Pantoja Bustamante Gabriel
## Implementación Base

![Diagrama de Clases](./assets/diagramaG.png "Diagrama")

## Métodos 
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

## Lista de Adyacencia

```java
  public class ListaAdyacencia implements Grafo{
    private HashMap<Integer, ArrayList<Vecino>> grafo;
    private boolean dirigido;
    private int cantVertices, cantAristas, cantLazos;
    private Verificador verificador;
  }
```

### Número de Vertices.

Devolvemos la variable que cuenta los Vertices.

### Número de Aristas.
Devolvemos la variable que cuenta las Aristas.

### Existe Arista.
Obtenemos los adyacentes del vertice origen, controlando que este exista, posteriormente verificamos si el vertice destino se encuentra en los adyacentes del vertice origen.

### Peso Arista.
Obtenemos los adyacentes del vertice origen controlando que este existe. Buscamos el Vecino que coincida con el vertice destino y obtenemos su peso.

### Insertar Arista.
Insertamos un nuevo elemento en la lista de adyacencia del vertice origen. Incrementamos el contador de aristas y si el origen es igual al destino, incrementamos el contador de lazos.

### Obtener Adyacentes.
Retornamos la lista asociada al vertice, si este no existe, devolvemos una lista vacia.

### Dibujar Grafo.

### Quitar Arista.


*Para los métodos restantes se créo una clase abstracta Verificador y dos subclases, VerificadorDirigido y VerificadorNoDirigido.*

![diagrama verificador](./assets/diagramaV.png)

### Es Grafo Completo.
Para que un grafo sea completo debe existir una arista para cada par de vertices.

Para un grafo no dirigido esto se puede verificar usando combinaciones, ya que la arista A-B es igual a B-A, las combinaciones nos ayudan a no tomar en cuenta las aristas repetidas.

La cantidad de aristas debe ser igual a *_nC2_* donde n es la cantidad de vertices.

![formula](./assets/f1.png)

Aplicando esta formula podemos verificar si un grafo es completo.

Para un grafo dirigido podemos hacer una pequeña modificación a esta formula, si el grafo tiene dos aristas por cada par de vertices este seria la cantidad maxima de aristas que puede tener esto es *_2(nC2)_*, y la cantidad minima de aristas que puede tener y ser completo es *_nC2_*, entonces la cantidad de aristas de un grafo dirigido debe estar entre estos dos valores *_nC2 >= cantAristas <= 2(nC2)_*.

### Es Grafo Ciclo.
Un grafo ciclo tiene la misma cantidad de vertices y aristas.

*Para un grafo dirigido verificados que las aristas tengan la misma dirección.*

### Es Grafo Rueda.

### Existe Bucle.

