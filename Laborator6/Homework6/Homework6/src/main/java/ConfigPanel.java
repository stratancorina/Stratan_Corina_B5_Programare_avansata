import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerRows;
    JSpinner spinnerCols;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        label = new JLabel("Grid size:");
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        createButton = new JButton("Create");
        //create spinners for rows and cols, and the button

        //...TODO
        add(label); //JPanel uses FlowLayout by default
        add(spinnerRows);
        add(spinnerCols);
        add(createButton);

        createButton.addActionListener(e->{
            this.revalidate();
        });




    }




}
