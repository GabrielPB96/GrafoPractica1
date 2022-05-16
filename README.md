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
```java
  @Override
  public int getNumVertices() {
      return cantVertices;
  }
```

### Número de Aristas.
Devolvemos la variable que cuenta las Aristas.
```java
  @Override
  public int getNumAristas() {
      return cantAristas;
  }
```

### Existe Arista.
Obtenemos los adyacentes del vertice origen, controlando que este exista, posteriormente verificamos si el vertice destino se encuentra en los adyacentes del vertice origen.
```java
  @Override
  public boolean existeArista(int origen, int destino) {
      ArrayList<Vecino> adyO = grafo.get(origen);
      boolean existe = false;
      if (adyO != null) {
          for (int i=0; i<adyO.size() && !existe; i++) {
              existe = adyO.get(i).getValor() == destino;
          }
      }
      return existe;
  }
```

### Peso Arista.
Obtenemos los adyacentes del vertice origen controlando que este existe. Buscamos el Vecino que coincida con el vertice destino y obtenemos su peso.
```java
  @Override
  public double getPesoArista(int origen, int destino) throws Exception {
      ArrayList<Vecino> ady = grafo.get(origen);
      double peso = Double.MIN_VALUE;
      Vecino v = null;
      if (ady == null) throw new Exception("La arista no existe");
      for (int k = 0; k < ady.size() && v == null; k++) {
          if (ady.get(k).getValor() == destino) v = ady.get(k);
      }
      if (v != null) peso = v.getPeso();
      else throw new Exception("La arista no existe");
      return peso;
  }
```
### Insertar Arista.
Insertamos un nuevo elemento en la lista de adyacencia del vertice origen. Incrementamos el contador de aristas y si el origen es igual al destino, incrementamos el contador de lazos.
```java
  @Override
  public void insertarArista(int origen, int destino) {
      ArrayList<Vecino> ady = grafo.get(origen);
      ady.add(new Vecino(destino, Double.MIN_VALUE));
      if (!dirigido) {
          ArrayList<Vecino> ady2 = grafo.get(destino);
          ady2.add(new Vecino(origen, Double.MIN_VALUE));
      }
      if (origen == destino) cantLazos++;
      cantAristas++;
  }
```
### Obtener Adyacentes.
Retornamos la lista asociada al vertice, si este no existe, devolvemos una lista vacia.
```java
    @Override
    public ArrayList<Vecino> getAdyacentes(int vertice) {
        ArrayList<Vecino> ady = grafo.get(vertice);
        return (ady != null) ? ady : new ArrayList<>();
    }
```
### Dibujar Grafo.

### Quitar Arista.


*Para los métodos restantes se créo una clase abstracta Verificador y dos subclases, VerificadorDirigido y VerificadorNoDirigido.*

![diagrama verificador](./assets/diagramaV.png)

```java
public abstract class Verificador {
    protected Grafo grafo;

    public Verificador(Grafo grafo) {
        this.grafo = grafo;
    }
    public abstract boolean esCompleto();
    public abstract boolean esGrafoCiclo();
    public abstract boolean esGrafoRueda();

    protected boolean existeBucle() {
        ListaAdyacencia g = (ListaAdyacencia) grafo;
        HashMap<Integer, ArrayList<Vecino>> gM = g.getGrafo();
        for(Integer i : gM.keySet()) {
            ArrayList<Vecino> vecinos = gM.get(i);
            for(Vecino v : vecinos) {
                if(v.getValor() == i) return true;
            }
        }
        return false;
    }
}
```


### Es Grafo Completo.
Para que un grafo sea completo debe existir una arista para cada par de vertices.

Para un grafo no dirigido esto se puede verificar usando combinaciones, ya que la arista A-B es igual a B-A, las combinaciones nos ayudan a no tomar ecuenta las aristas repetidas.

La cantidad de aristas debe ser igual a *_nC2_* donde n es la cantidad de vertices.

![formula](./assets/f1.png)

Aplicando esta formula podemos verificar si un grafo es completo.

Para un grafo dirigido podemos hacer una pequeña modificación a esta formula, si el grafo tiene dos aristas por cada par de vertices este seria la cantidad maxima de aristas que puede tener esto es *_2(nC2)_*, y la cantidad minima de aristas que puede tener y ser completo es *_nC2_*, entonces la cantidad de aristas de un grafo dirigido debe estar entre estos dos valores *_nC2 >= cantAristas <= 2(nC2)_*.

### Es Grafo Ciclo. [métodos](#métodos)
Un grafo ciclo tiene la misma cantidad de vertices y aristas.

*Para un grafo no dirigido*
```java
  @Override
  public boolean esGrafoCiclo() {
      int nVertices = grafo.getNumVertices();
      int nAristas    = grafo.getNumAristas();
      if (nVertices <= 2 ) return false;
      return nVertices == nAristas;
  }
```

*Para un grafo dirigido verificados que las aristas tengan la misma dirección.*
```java
  @Override
  public boolean esGrafoCiclo() {
      int inicio = 0, v = inicio, anterior = grafo.getNumVertices()- 1;
      for(int i = 0; i < grafo.getNumVertices(); i++) {
          ArrayList<Vecino> vecinos = (ArrayList<Vecino>) grafogetAdyacentes(v);
          if(vecinos.size() > 2) return false;
          else{
              int aux = v;
              for (Vecino vecino : vecinos) {
                  if(vecino.getValor() != anterior){
                      aux = vecino.getValor();
                  }
              }
              anterior = v;
              v = aux;
          }
      }
      return inicio == v;
  }
```
### Es Grafo Rueda.

### Existe Bucle.

