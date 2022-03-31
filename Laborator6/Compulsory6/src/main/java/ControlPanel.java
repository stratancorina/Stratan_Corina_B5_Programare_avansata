import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;

    JButton exitBtn = new JButton("Exit");
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        add(exitBtn);
        add(loadButton);
        add(saveButton);

        exitBtn.addActionListener(this::exitGame);

        loadButton.addActionListener(this::loadGame);
        saveButton.addActionListener(this::saveGame);


    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void createGame(ActionEvent actionEvent) {
    }

    private void saveGame(ActionEvent e) {
    }

    private void loadGame(ActionEvent e) {
    }


}
