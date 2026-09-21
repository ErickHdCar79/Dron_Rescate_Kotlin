
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
        "lluvia" -> aplicarAjuste(tiempoBase, ajusteLluvia)
        "emergencia" -> aplicarAjuste(tiempoBase, ajusteEmergencia)
        else -> tiempoBase
    }

fun calcularConsumoBateria(
    distanciaTotal: Double,
    pesoCarga: Double,
    consumoExtra: Double = 0.0
): Double {
    val consumoDistancia = distanciaTotal * 4.0
    val consumoPeso = pesoCarga * 2.0
    return consumoDistancia + consumoPeso + consumoExtra
}

// 2. Funciones de una sola expresión para cálculo y validación de batería
fun calcularBateriaFinal(
    bateriaInicial: Double,
    consumo: Double
): Double = bateriaInicial - consumo

fun tieneReservaSuficiente(
    bateriaFinal: Double,
    reservaMinima: Double = 15.0
): Boolean = bateriaFinal >= reservaMinima

fun main() {
    println("SIMULADOR DE MISIÓN DE RESCATE")
    println()

    // --- ENTRADA DE DATOS ---
    print("Distancia de ida: ")
    val distanciaIda = readln().toDoubleOrNull() ?: 0.0

    print("Peso de la carga: ")
    val pesoCarga = readln().toDoubleOrNull() ?: 0.0

    print("Batería disponible: ")
    val bateriaDisponible = readln().toDoubleOrNull() ?: 0.0

    print("Tipo de carga: ")
    val tipoCarga = readln()

    print("Condición: ")
    val condicion = readln()

    val distanciaTotal = calcularDistanciaTotal(distanciaIda)
    val tiempoBase = calcularTiempoBase(distanciaTotal)
    val tiempoEstimado = calcularTiempoFinal(tiempoBase, condicion, ajusteLluvia, ajusteEmergencia)

    val consumoExtraCalculado = when (condicion.lowercase()) {
        "lluvia" -> 10.0
        "emergencia" -> 5.0
        else -> 0.0
    }

    // Llamada utilizando argumentos con nombre
    val consumoEstimado = calcularConsumoBateria(
        distanciaTotal = distanciaTotal,
        pesoCarga = pesoCarga,
        consumoExtra = consumoExtraCalculado
    )

    val bateriaAlRegresar = calcularBateriaFinal(bateriaDisponible, consumoEstimado)
    val reservaSuficiente = tieneReservaSuficiente(bateriaFinal = bateriaAlRegresar, reservaMinima = 15.0)

    // La decisión depende exclusivamente de si se conserva la reserva mínima de 15%
    val decision = if (reservaSuficiente && bateriaAlRegresar >= 0.0) {
        "MISIÓN AUTORIZADA"
    } else {
        "MISIÓN NO AUTORIZADA"
    }
}
