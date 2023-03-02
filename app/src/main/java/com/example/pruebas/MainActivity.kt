package com.example.pruebas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    private fun calculadora(n1: Int, n2: Int, fn: (Int, Int)->Int): Int {
    return fn(n1,n2);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        fun inChile(a: Float): Boolean{
            return a >= 1.62f
        }
        fun inEspania(a: Float): Boolean{
            return a >= 1.65f
        }

        var jose: Person = Person( "José",  "765839-9", 1.62f, 83.5f)
        if (jose.checkPolicia(::inChile)) println("${jose.name} puede ser policía en Chile")
        if (jose.checkPolicia(::inEspania)) println("${jose.name} puede ser policía en España")


        //funciones de alcance scopes
        //un bloque de código que opera sobre un mismo elemento. para hacer más legible el cambio
        jose.let{
            it.altura = 1.90f
        }

        //siguiente función de alcance scope
        jose.apply {
            this.peso = 77f
        }

        //construyendo un objeto pasandole datos al constructor y haciendo cambios con apply
        var Karen = Person("Karen", "876543920", 1.65f, 72f).apply{
            altura = 1.7f
            peso = 56f
        }.also {
            //also sirve para seguir ejecutando cambios
            it.rut = "78474637364"
        }

        //construyendo un objeto pasandole datos al constructor y haciendo cambios con run
        var Alicia = Person("Alicia", "68789587", 1.55f, 62f).run{
            altura = 1.60f
            peso = 63f
        }

        //Construyendo un objeto pasandole datos al constructor y haciendo cambios con with
        var Tomas = with(Person("Tomas", "76849875", 1.63f, 56.2f)){
            this.altura = 1.65f
            this.peso = 57.2f

            "Tomas es muy alto"
        }

        //Operador Elvis ?:
        var pais:String? = "Rusia"
        //si es null ejecutamos lo que está a la derecha del operador
        pais = pais?.uppercase() ?: "Desconocido"
        println(pais)

        var ciudad:String? = null
        //si es null ejecutamos lo que está a la derecha del operador
        pais = ciudad?.uppercase() ?: "Desconocido"
        println(ciudad)

        //declaración de variable vacía se usa lateinit para inicializar el valor más tarde
        lateinit var cadena: String
        //para un tipo de dato primitivo como un boolean no funciona lateinit ya que se debe asignar un valor
        //lateinit var resi: Boolean

        //otro metodo para declarar una variable vacía es lazy
        val calle: String by lazy { "Nueva" }

        var direccion = "$pais - $ciudad - $calle"
        println(direccion)


        fun suma(x: Int, y: Int) : Int { return x+y}
        fun resta(x: Int, y: Int) : Int {return x-y}
        fun multiplicar(x: Int, y:Int) : Int {return x*y}
        fun dividir(x: Int, y:Int) : Int {return x/y}

        println("La suma de 80 y 20 es ${calculadora(80, 20, ::suma)}")
        println("La resta de 80 y 20 es ${calculadora(80, 20, ::resta)}")
        println("La multiplicación de 80 y 20 es ${calculadora(80, 20, ::multiplicar)}")
        println("La división de 80 y 20 es ${calculadora(80, 20, ::dividir)}")
        println("La potencia de 2 elevado a 5 con lambda es ${calculadora(2,5) { x, y ->
            var valor = 1
            for (i in 1..y) valor *= x
            valor
        }
        }")

        /*errores*/
        /* NullPointerException : Apuntar a un objeto null. propiedad o método de un objeto que no existe.
        *   ArithmeticException: Dividir entre cero
        *  SecurityException: Acceder a un archivo para escribir cuando es solo de lectura
        *  ArrayIndexOutOfBoundException: Acceder a un índice de un array que no existe. ejemplo 9 y el array solo tiene 8
        *  Todos heredan de la clase padre Exception
        *  */


        /* Guardar el resultado del try en una variable */
        fun valor_del_try(a: Int, b:Int): Any{ //de tipo any ya que no se especifica si es string o int
            var resultado=

        try{
            println("División 5/0 = ${a/b}")
            a/b
        }catch(e: Exception){
            println("División no permitida")
        }finally{
            println("Pase lo que pase se ejecuta el finally")
        }
            return resultado
        }

                var res1 = valor_del_try(10, 2) //ejecutar bloque try
                println(res1)

                var res2 = valor_del_try(10, 0) //ejecutar bloque CATCH
                println(res2.toString())

                //manejar throws exceptions - mensajes personalizados
        //cuando hay un throw la aplicación se detiene
        /*
                var password: String = "1234"
                if(password.length < 6){
                    throw Exception("Password muy corta")
                }else{
                    println("Password segura")
                }
    */
            fun recorrerArray(array: IntArray, fn: (Int) -> Unit){
                for(i in array)
                    fn(i)
            }

            var array1 = IntArray(10){5}
            println("array1: ") ; intArrayOf()
            var array2 = IntArray(10 ) {it*2}
            println(" array2 "); Arrays.toString(array2);

                //lambda
                println("La suma de 80 y 20 es ${calculadora(80, 20, {x: Int, y: Int -> x+y})}")
                }





}


