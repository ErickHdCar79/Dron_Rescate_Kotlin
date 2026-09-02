# Planeación estudiante A

## Datos de entrada

- Distancia de ida.
- Peso de la carga.
- Tiempo de vuelo.
- Condición de vuelo.

## Requerimientos

- Calcular la distancia total.
- Calcular el tiempo de vuelo total.

## Seudocódigo

1. Solicitar la distancia de ida en `int`.
2. Llamar a la función para calcular la distancia total.
3. Solicitar la condición de vuelo.
4. Si la condición de vuelo es `"normal"`, continuar con el paso 5
5. Realizar el cálculo del tiempo de vuelo total, ir al paso 10.
6. Si la condicion de vuelo es `"lluvia"`, ir al paso 7.
7. Relizar el calculo de tiempo total de vuelo y aumentarlo un 20%. Ir al psao 10. 
8. Si la condición de vuelo es `"emergencia"`, ir al paso 9.
9. Relizar el calculo de tiempo total de vuelo y quitarle un 10%. Ir al psao 10.
10. Mostrar los datos.
## Funciones a aplicar
