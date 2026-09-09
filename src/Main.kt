fun calcularDistanciaTotal(distanciaIda: Double): Double =
    distanciaIda * 2.0

fun calcularTiempoBase(distanciaTotal: Double): Double =
    distanciaTotal / 2.0

val ajusteLluvia: (Double) -> Double = { valor ->
    valor * 1.20
}

val ajusteEmergencia: (Double) -> Double = { valor ->
    valor * 0.90
}

fun aplicarAjuste(
    valorBase: Double,
    ajuste: (Double) -> Double
): Double = ajuste(valorBase)

fun calcularTiempoFinal(
    tiempoBase: Double,
    condicion: String,
    ajusteLluvia: (Double) -> Double,
    ajusteEmergencia: (Double) -> Double
): Double =
    when (condicion.lowercase()) {
        "normal" -> tiempoBase
        "lluvia" -> ajusteLluvia(tiempoBase)
        "emergencia" -> ajusteEmergencia(tiempoBase)
        else -> tiempoBase
    }

fun main() {
    println("SIMULADOR DE MISIÓN DE RESCATE")
    println()

    print("Distancia de ida (km): ")
    val distanciaIda = readln().toDouble()

    print("Condición de vuelo (normal, lluvia, emergencia): ")
    val condicion = readln()

    val distanciaTotal = calcularDistanciaTotal(distanciaIda)
    val tiempoBase = calcularTiempoBase(distanciaTotal)

    val tiempoFinal = calcularTiempoFinal(tiempoBase, condicion, ajusteLluvia, ajusteEmergencia)

    println()
    println("RESULTADO")
    println("Distancia total: $distanciaTotal km")
    println("Tiempo base: $tiempoBase minutos")
    println("Tiempo final: $tiempoFinal minutos")
}
