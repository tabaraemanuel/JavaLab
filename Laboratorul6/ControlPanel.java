import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton loadBtn = new JButton("Load");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        this.add(saveBtn);
        this.add(resetBtn);
        this.add(loadBtn);
        this.add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);
    }

    private void reset(ActionEvent e){
        this.frame.canvas.createOffscreenImage();
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("../images/saved_image.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }

    private void load(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile;
            selectedFile = fileChooser.getSelectedFile();
            FileToImage image = new FileToImage(selectedFile);
            image.setPreferredSize(new Dimension(300,300));
            frame.add(image);
            frame.revalidate();;
        }
    }
}


     class FileToImage extends JPanel {
            private BufferedImage convertedImage;

        public FileToImage(File newImageFile)
        {
            try {
                convertedImage = ImageIO.read(newImageFile);
            } catch (IOException e){
                e.printStackTrace();}
        }

         public void paintComponent(Graphics g) {
             super.paintComponent(g);
             g.drawImage(convertedImage, 0, 0, 300, 300, this);
         }

    }




