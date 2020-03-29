import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        JLabel sideLabel = new JLabel("Number of sides:");
        String[] valueList = { "Random", "Black"};
        colorCombo = new JComboBox(valueList);
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        sidesField.setVisible(true);
        sidesField.addChangeListener(e -> sideLabel.setText(((JSpinner)e.getSource()).getValue().toString()));
        add(sideLabel);
        add(sidesField);
        add(colorCombo);
    }



    public JSpinner getSidesField() {
        return sidesField;
    }
}
