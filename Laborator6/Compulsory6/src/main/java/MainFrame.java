import javax.swing.*;

import java.awt.*;

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
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.configPanel = new ConfigPanel(this);
        this.controlPanel = new ControlPanel(this);
        this.canvas = new DrawingPanel(this);

        //arrange the components in the container (frame)

        getContentPane().add(configPanel,BorderLayout.NORTH);
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        //invoke the layout manager
        pack();





    }
}