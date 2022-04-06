import javax.swing.*;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import static java.awt.BorderLayout.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(800, 800));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);


        //arrange the components in the container (frame)

        getContentPane().add(configPanel, BorderLayout.NORTH);
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        //invoke the layout manager
        pack();


    }
    public JRootPane getFrame() {
        return null;
    }

    public void createAndShowGUI() {
    }
}