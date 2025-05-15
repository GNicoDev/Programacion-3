package ejercicio3;

public interface ServiceComedor {
    public void agregarCliente(Cliente cliente);

   // public void eliminarCliente(Integer dniCliente);
  //  public void modificarCliente(Integer dni, Cliente clienteNuevo);

    public Cliente obtenerCliente(Integer dniCliente);
    public void imprimirCliente(Integer dniCliente);
    public double obtenerSaldo(Integer dniCliente);
    public void listarClientesSaldoMenorA(double saldo);
    public void listarClientesConCP(int CP);

}
