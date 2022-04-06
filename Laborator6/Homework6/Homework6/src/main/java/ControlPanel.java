import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.EventHandler;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class ControlPanel extends JPanel {
    final MainFrame frame;

    JButton exitBtn = new JButton("Exit");
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton resetButton = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveButton);
        add(loadButton);
        add(resetButton);
        add(exitBtn);
        
        exitBtn.addActionListener(this::exitGame);
        loadButton.addActionListener(this::loadGame);
        saveButton.addActionListener(this::saveGame);
        resetButton.addActionListener(this::resetGame);

    }


    private void resetGame(ActionEvent e){
            frame.getFrame().getContentPane().removeAll();
            frame.getFrame().repaint();
            frame.createAndShowGUI();
    }

    private void exitGame(ActionEvent e){
        System.exit(3);
    }

    private void saveGame(ActionEvent event) {
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Choose a directory to save your file");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                ImageIO.write(frame.canvas.image, "PNG",
                        new File(fileChooser.getSelectedFile() + "\\test.png"));
            }
        } catch (IOException exception) {
            System.err.println(exception);
        }
    }

    private void loadGame(ActionEvent event) {
        BufferedImage image = null;
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Select an image");
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG images", "png");
            fileChooser.addChoosableFileFilter(filter);

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                image = ImageIO.read(new File(fileChooser.getSelectedFile().getPath()));
                frame.canvas.loadImage(image);
            }
        } catch (IOException exception) {
            System.err.println(exception);
        }
    }

}
