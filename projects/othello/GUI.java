import javax.swing.*;
import java.awt.*;

public class GUI {

  public static final String TITLE = "Grid Game Demo";

  public static void main(String[] args) {
    JFrame frame = new JFrame(TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);

    JLabel player = new JLabel("Black's turn", SwingConstants.CENTER);

    frame.add(new Othello(player));
    frame.add(player, BorderLayout.SOUTH);

    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
}
