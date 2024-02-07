import java.awt.Color;
import java.awt.Graphics2D;

public class Othello extends GridGame {

  private static final Color BOARD = new Color(0, 0x9e, 0x0d);

  public Othello() {
    super(8, 8, 3);
    setBackground(Color.BLACK);
  }

  /*
   * This method will be called whenever you need to draw a cell. The Graphics2D
   * object is essentially the same one you used in the Flag but with a few more
   * methods. See:
   *
   * https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/java/awt/Graphics2D.html
   */
  public void paintCell(int row, int column, Graphics2D g) {
    g.setColor(BOARD);
    g.fillRect(0, 0, cellWidth(), cellHeight());
  }

  /*
   * This method will be called for you when the user clicks a cell in the grid.
   */
  public void cellClicked(int row, int col) {
    repaint();
  }
}
