import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class DrawArc{
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.add(new ArcsPanel());
		frame.setTitle("DrawArc");
		frame.setSize(250,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ArcsPanel extends JPanel{
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(xCenter,yCenter) * 0.8);

		int x = xCenter - radius;
		int y = yCenter - radius;

		g.fillArc(x, y, 2 * radius, 2 * radius, 0, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 90, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 180, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 270, 30);
	}
}