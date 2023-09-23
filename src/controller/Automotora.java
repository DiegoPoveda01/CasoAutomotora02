package controller;

import java.util.ArrayList;
import model.Vehiculo;
import model.Cliente;

public class Automotora {
public ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	public void agregarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}
}