package ejercicio3;

import java.time.LocalDate;
import java.util.Date;

public class Cliente {
    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fechaNacimiento;
    private String domicilio;
    private Integer CP;
    private Double saldo;
    private String carreraUniversitaria;

    public Cliente(String nombre, String apellido, Integer dni, LocalDate fechaNacimiento,
                 String domicilio, Integer CP, Double saldo, String carreraUniversitaria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.CP = CP;
        this.saldo = saldo;
        this.carreraUniversitaria = carreraUniversitaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getCP() {
        return CP;
    }

    public void setCP(Integer CP) {
        this.CP = CP;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getCarreraUniversitaria() {
        return carreraUniversitaria;
    }

    public void setCarreraUniversitaria(String carreraUniversitaria) {
        this.carreraUniversitaria = carreraUniversitaria;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", fechaNacimiento=" + fechaNacimiento +
                ", domicilio='" + domicilio + '\'' +
                ", CP=" + CP +
                ", saldo=" + saldo +
                ", carreraUniversitaria='" + carreraUniversitaria + '\'' +
                '}';
    }
}
