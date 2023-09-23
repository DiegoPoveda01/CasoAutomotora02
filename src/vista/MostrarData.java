package vista;

import javax.swing.*;
import java.awt.*;

public class MostrarData extends JFrame {
    private JTextArea displayArea;

    public MostrarData(String title, String data) {
        setTitle(title);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        displayArea = new JTextArea(data);
        displayArea.setEditable(false);

        add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }
}
