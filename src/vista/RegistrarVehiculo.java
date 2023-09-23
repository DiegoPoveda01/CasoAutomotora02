package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.Automotora;
import model.Vehiculo;
import principal.Main;

public class RegistrarVehiculo extends JFrame {
    private JTextField nombreField;
    private JTextField anoField;
    private JTextField precioField;
    private JTextField kmField;
    private JTextField colorField;
    private JTextField marcaField;
    private ArrayList<Vehiculo> vehiculosList;
    private Automotora automotora;

    public RegistrarVehiculo(Automotora automotora) {
        this.automotora = automotora;
        setTitle("Registro de Vehículo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        vehiculosList = new ArrayList<>();

        panel.add(new JLabel("Nombre del vehículo:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Año del vehículo:"));
        anoField = new JTextField();
        panel.add(anoField);

        panel.add(new JLabel("Precio del vehículo:"));
        precioField = new JTextField();
        panel.add(precioField);

        panel.add(new JLabel("Kilómetros recorridos:"));
        kmField = new JTextField();
        panel.add(kmField);

        panel.add(new JLabel("Color del vehículo:"));
        colorField = new JTextField();
        panel.add(colorField);

        panel.add(new JLabel("Marca del vehículo:"));
        marcaField = new JTextField();
        panel.add(marcaField);

        JButton agregarVehiculoButton = new JButton("Agregar Vehículo");
        panel.add(agregarVehiculoButton);

        agregarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVehiculo();
            }
        });

        add(panel);
    }

    private void agregarVehiculo() {
        String nombre = nombreField.getText().trim();
        String ano = anoField.getText().trim();
        String precio = precioField.getText().trim();
        String km = kmField.getText().trim();
        String color = colorField.getText().trim();
        String marca = marcaField.getText().trim();

        if (nombre.isEmpty() || ano.isEmpty() || precio.isEmpty() || km.isEmpty() || color.isEmpty() || marca.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene la información faltante.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Vehiculo vehiculo = new Vehiculo(nombre, ano, precio, km, color, marca);
        try{
        vehiculosList.add(vehiculo);
        automotora.agregarVehiculo(vehiculo);
        JOptionPane.showMessageDialog(this, "Vehículo agregado exitosamente.");
        int choice = JOptionPane.showOptionDialog(
                this,
                "¿Qué deseas hacer a continuación?",
                "Opciones",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Agregar otro vehiculo", "Mostrar datos"},
                "Agregar otro vehiculo");

            if (choice == 0) {
                clearFields();
            } else if (choice == 1) {
                dispose();
            }

        } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

        clearFields();
    }

    private void clearFields() {
        nombreField.setText("");
        anoField.setText("");
        precioField.setText("");
        kmField.setText("");
        colorField.setText("");
        marcaField.setText("");
    }
    public String getVehiculosData() {
        StringBuilder data = new StringBuilder("Vehículos:\n");
        for (Vehiculo vehiculo : vehiculosList) {
            data.append("Nombre : ").append(vehiculo.getNombre()).append(", Año: ").append(vehiculo.getAño()).append(", Precio: ").append(vehiculo.getPrecio()).append(", Kilómetros recorridos: ").append(vehiculo.getKmRecorridos()).append(", Color: ").append(vehiculo.getColor()).append(", Marca: ").append(vehiculo.getMarca()).append("\n");
        }
        return data.toString();
    }
}
