# Planeación estudiante A

## Datos de entrada

* Distancia de ida en kilómetros (`Double`).
* Condición de vuelo:

    * `"normal"`
    * `"lluvia"`
    * `"emergencia"`

## Resultado o efecto esperado

* Obtener la distancia total de la misión considerando ida y regreso.
* Calcular el tiempo base de vuelo a partir de la distancia total.
* Obtener el tiempo final de vuelo según la condición de vuelo:

    * `"normal"`: mantener el tiempo base.
    * `"lluvia"`: aumentar el tiempo base un `20%`.
    * `"emergencia"`: reducir el tiempo base un `10%`.
* Mostrar en pantalla la distancia total, el tiempo base y el tiempo final.

## Pseudocódigo

1. Solicitar la distancia de ida en `Double`.
2. Llamar a la función para calcular la distancia total.
3. Calcular el tiempo base utilizando la distancia total.
4. Solicitar la condición de vuelo.
5. Si la condición es `"normal"`, mantener el tiempo base.
6. Si la condición es `"lluvia"`, aumentar el tiempo base un `20%`.
7. Si la condición es `"emergencia"`, reducir el tiempo base un `10%`.
8. Mostrar la distancia total.
9. Mostrar el tiempo base.
10. Mostrar el tiempo final.

## Funciones a aplicar

### Funciones de una sola línea

* `calcularDistanciaTotal()`: calcula la distancia total multiplicando la distancia de ida por `2`.
* `calcularTiempoBase()`: calcula el tiempo base dividiendo la distancia total entre `2`.
* `calcularTiempoFinal()`: determina el tiempo final mediante `when`, dependiendo de la condición de vuelo.

### Funciones lambda

* `ajusteLluvia`: recibe el tiempo base y aumenta su valor un `20%`.
* `ajusteEmergencia`: recibe el tiempo base y reduce su valor un `10%`.

### Funciones de orden superior

* `aplicarAjuste()`: recibe un valor numérico y una función lambda como parámetros, y ejecuta dicha función sobre el valor recibido.
* `calcularTiempoFinal()` utiliza `aplicarAjuste()` para realizar el ajuste correspondiente según la condición de vuelo.

## Casos de prueba

### Caso de prueba 1

**Datos de entrada:**

* Distancia de ida: `10 km`
* Condición: `"lluvia"`

**Resultado esperado:**

* Distancia total: `20 km`
* Tiempo base: `10 minutos`
* Tiempo final: `12 minutos`

**Efecto esperado:**
El programa debe calcular el recorrido de ida y regreso y aumentar el tiempo base un `20%` debido a la condición de lluvia.

### Caso de prueba 2: caso límite

**Datos de entrada:**

* Distancia de ida: `0 km`
* Condición: `"normal"`

**Resultado esperado:**

* Distancia total: `0 km`
* Tiempo base: `0 minutos`
* Tiempo final: `0 minutos`

**Efecto esperado:**
El programa debe aceptar el valor mínimo de distancia y realizar los cálculos correctamente sin producir errores.

