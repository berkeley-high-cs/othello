import javax.swing.JFrame;

public class GUI {

  public static final String TITLE = "Grid Game Demo";

  public static void main(String[] args) {
    JFrame frame = new JFrame(TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.add(new Othello());
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
}
