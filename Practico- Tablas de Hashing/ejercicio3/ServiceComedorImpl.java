package ejercicio3;

import java.util.LinkedList;

public class ServiceComedorImpl implements ServiceComedor {
    private GrowingSeparateChainingHashTable<Integer,Cliente> clientes;

    private final static int M = 20;
    public ServiceComedorImpl() {
        clientes= new GrowingSeparateChainingHashTable<Integer,Cliente>(M);
    }
    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.insertar(cliente.getDni(),cliente);
    }

    @Override
    public Cliente obtenerCliente(Integer dniCliente) {
        return clientes.obtenerElemento(dniCliente);
    }

    @Override
    public void imprimirCliente(Integer dniCliente) {
        clientes.showValue(dniCliente);
    }

    @Override
    public double obtenerSaldo(Integer dniCliente) {
        Cliente cliente = clientes.obtenerElemento(dniCliente);
        return cliente!=null ? cliente.getSaldo() : 0;
    }

    @Override
    public void listarClientesSaldoMenorA(double saldo) {
        LinkedList<Nodo<Integer,Cliente>>[] tabla = clientes.getTableCopia();
        for (int i = 0 ; i< clientes.obtenerTamanioTabla() ; i++){
            for (Nodo<Integer, Cliente> nodoBalde : tabla[i]) {
                Cliente cliente = nodoBalde.value;
                if (cliente.getSaldo()<saldo){
                    imprimirCliente(cliente.getDni());
                }
            }

        }
    }


    @Override
    public void listarClientesConCP(int CP) {
        LinkedList<Nodo<Integer,Cliente>>[] tabla = clientes.getTableCopia();
        for (int i = 0 ; i< tabla.length ; i++){
            for (Nodo<Integer, Cliente> nodoBalde : tabla[i]) {
                Cliente cliente = nodoBalde.value;
                if (cliente.getCP().equals(CP)){
                    imprimirCliente(cliente.getDni());
                }
            }

        }
    }
}
