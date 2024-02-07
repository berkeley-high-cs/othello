import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI {

  public static final String TITLE = "Grid Game Demo";

  public static void main(String[] args) {
    JFrame frame = new JFrame(TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);

    JLabel label = new JLabel("", SwingConstants.CENTER);
    JCheckBox checkbox = new JCheckBox();
    Box b = new Box(BoxLayout.X_AXIS);
    b.add(Box.createHorizontalGlue());
    b.add(new JLabel("Show legal moves: "));
    b.add(checkbox);
    b.add(Box.createHorizontalStrut(10));

    frame.add(new Othello(label, checkbox));
    frame.add(label, BorderLayout.SOUTH);
    frame.add(b, BorderLayout.NORTH);

    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
}
