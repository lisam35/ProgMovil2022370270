//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    //Menu
    while (true) {
        println("\nMenú de Opciones:")
        println("1. Sumar tres números")
        println("2. Ingresar nombre completo")
        println("3. Calcular tiempo vivido")
        println("4. Salir")
        print("Seleccione una opción: ")

        //Al ingresar un numero ejecuta la opcion seleccionada
        when (scanner.nextInt()) {
            1 -> sumarNumeros()
            2 -> ingresarNombre()
            3 -> calcularTiempoVivido()
            4 -> { //muestra mensaje y finaliza el programa
                println("Saliendo del programa...")
                return
            }
            else -> println("Opción no válida, intente de nuevo.") //Solo permite 1,2,3 y 4
        }
    }
}

//Solicita tres numeros y muestra la suma
fun sumarNumeros() {
    val scanner = Scanner(System.`in`)
    print("Ingrese el primer número: ")
    val num1 = scanner.nextDouble()
    print("Ingrese el segundo número: ")
    val num2 = scanner.nextDouble()
    print("Ingrese el tercer número: ")
    val num3 = scanner.nextDouble()
    val suma = num1 + num2 + num3
    println("La suma de los números es: $suma")
}

//Solicita el nombre y muestra un saludo con el nombre
fun ingresarNombre() {
    val scanner = Scanner(System.`in`)
    print("Ingrese su nombre completo: ")
    val nombre = scanner.nextLine()
    println("Hola, $nombre!")
}

//Pide la fecha de nacimiento y calcula el tiempo vivido
fun calcularTiempoVivido() {
    val scanner = Scanner(System.`in`)
    print("Ingrese su fecha de nacimiento (YYYY-MM-DD): ")
    val fechaNacimiento = LocalDate.parse(scanner.nextLine())
    val fechaActual = LocalDate.now()
    val periodo = Period.between(fechaNacimiento, fechaActual)
    val diasTotales = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual)
    val horas = diasTotales * 24
    val minutos = horas * 60
    val segundos = minutos * 60

    println("Tiempo vivido desde $fechaNacimiento hasta hoy:")
    println("- ${periodo.years} años, ${periodo.months} meses, ${periodo.days} días")
    println("- Total en días: $diasTotales")
    println("- Total en horas: $horas")
    println("- Total en minutos: $minutos")
    println("- Total en segundos: $segundos")
}
