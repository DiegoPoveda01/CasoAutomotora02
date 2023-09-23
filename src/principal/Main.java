package principal;

import controller.Automotora;
import vista.RegistrarCliente;
import vista.RegistrarVehiculo;
import vista.MostrarData;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	private static RegistrarCliente currentClientForm;

	public static void main(String[] args) {

		Automotora automotora = new Automotora();
		currentClientForm = new RegistrarCliente(automotora);
		currentClientForm.setVisible(true);
		currentClientForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				RegistrarVehiculo vehicleForm = new RegistrarVehiculo(automotora);
				vehicleForm.setVisible(true);

				vehicleForm.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						String clientesData = currentClientForm.getClientesData();
						String vehiculosData = vehicleForm.getVehiculosData();

						MostrarData dataWindow = new MostrarData("Clientes y Vehículos", clientesData + "\n" + vehiculosData);
						dataWindow.setVisible(true);
					}
				});
			}
		});
	}
	public static RegistrarCliente getCurrentClientForm() {
		return currentClientForm;
	}
}
