package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.Automotora;
import model.Cliente;
import principal.Main;

public class RegistrarCliente extends JFrame {
    private JTextField nombreField;
    private JTextField direccionField;
    private JTextField telefonoField;
    private JTextField emailField;
    private JTextField rutField;
    private ArrayList<Cliente> clientesList;
    private Automotora automotora;

    public RegistrarCliente(Automotora automotora) {
        this.automotora = automotora;
        setTitle("Registro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        clientesList = new ArrayList<>();

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        panel.add(nombreLabel);
        panel.add(nombreField);
        JLabel direccionLabel = new JLabel("Dirección:");
        direccionField = new JTextField();
        panel.add(direccionLabel);
        panel.add(direccionField);
        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoField = new JTextField();
        panel.add(telefonoLabel);
        panel.add(telefonoField);
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        panel.add(emailLabel);
        panel.add(emailField);
        JLabel rutLabel = new JLabel("RUT:");
        rutField = new JTextField();
        panel.add(rutLabel);
        panel.add(rutField);

        JButton agregarClienteButton = new JButton("Agregar Cliente");
        panel.add(agregarClienteButton);

        agregarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });

        add(panel);
    }

    private void agregarCliente() {
        String nombre = nombreField.getText().trim();
        String direccion = direccionField.getText().trim();
        String telefono = telefonoField.getText().trim();
        String email = emailField.getText().trim();
        String rut = rutField.getText().trim();

        if (nombre.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene la información faltante", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "El email no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nombre, direccion, telefono, email, rut);
        try {
            automotora.agregarCliente(cliente);
            clientesList.add(cliente);

            JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente.");

            int choice = JOptionPane.showOptionDialog(
                    this,
                    "¿Qué deseas hacer a continuación?",
                    "Opciones",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Agregar otro cliente", "Agregar vehículos"},
                    "Agregar otro cliente");

            if (choice == 0) {
                Main.getCurrentClientForm().clearFields();
                Main.getCurrentClientForm().setVisible(true);
            } else if (choice == 1) {
                dispose();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void clearFields() {
        nombreField.setText("");
        direccionField.setText("");
        telefonoField.setText("");
        emailField.setText("");
        rutField.setText("");
    }
    private boolean isValidEmail(String email) {
        return email.contains("@");
    }

    public String getClientesData() {
        StringBuilder data = new StringBuilder("Clientes:\n");
        for (Cliente cliente : clientesList) {
      data.append("Nombre: ").append(cliente.getNombre()).append(", Dirección: ").append(cliente.getDireccion()).append(", Teléfono: ").append(cliente.getNumeroTelefonico()).append(", Email: ").append(cliente.getEmail()).append(", RUT: ").append(cliente.getRut()).append("\n");
        }
        return data.toString();
    }
}
