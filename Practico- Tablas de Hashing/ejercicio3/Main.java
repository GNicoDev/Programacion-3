package ejercicio3;

/*
*  Ejercicio 3
 Se está desarrollando una aplicación que almacena los datos y el saldo de las tarjetas de
 compra de comida del comedor de una universidad. Cada cliente es identificado por su
 número de DNI, y se poseen además sus datos personales y de la carrera que estudia.
 CLIENTE: DNI, Nombre, Apellido, fecha de nacimiento, domicilio, CP ciudad de origen, saldo
 de la cuenta, nombre carrera estudia
 Se quiere:
 a) Dado un DNI de cliente, responder el saldo de su cuenta.
 b) Imprimir un listado de Nombre y Apellido de todos los clientes que tienen en su saldo
 de cuenta menos de un valor X dado.
 c) Dadouncódigo postal, listar todos los clientes que provengan de esa ciudad.
 Proponga y describa qué estructuras de datos utilizaría para responder eficientemente a los
 servicios pedidos. Muestre gráficamente cómo se relacionan.
*/

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ServiceComedor comedor = new ServiceComedorImpl();

        Cliente c1 = new Cliente("Juan", "Pérez", 12345678,
                LocalDate.of(2000, 5, 12), "Calle Falsa 123", 7600, 1500.0, "Ingeniería en Sistemas");

        Cliente c2 = new Cliente("Lucía", "Gómez", 23456789,
                LocalDate.of(1999, 3, 22), "Av. Siempreviva 742", 1900, 500.0, "Licenciatura en Matemática");

        Cliente c3 = new Cliente("Martín", "Lopez", 34567890,
                LocalDate.of(2001, 11, 30), "San Martín 2000", 5000, 0.0, "Arquitectura");

        Cliente c4 = new Cliente("Ana", "Fernández", 45678901,
                LocalDate.of(2002, 8, 5), "Mitre 450", 7600, 300.0, "Abogacía");

        Cliente c5 = new Cliente("Diego", "Ramírez", 56789012,
                LocalDate.of(1998, 1, 15), "Belgrano 999", 1400, 50.0, "Medicina");

        comedor.agregarCliente(c1);
        comedor.agregarCliente(c2);
        comedor.agregarCliente(c3);
        comedor.agregarCliente(c4);
        comedor.agregarCliente(c5);

       // comedor.imprimirCliente(56789012);
        comedor.listarClientesSaldoMenorA(500);

    }
}
