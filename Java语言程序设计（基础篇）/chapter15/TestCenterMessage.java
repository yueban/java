import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Color;

public class TestCenterMessage{
	public static void main(String[] args){
		JFrame frame = new JFrame();
		CenterMessage centerMessage = new CenterMessage();
		centerMessage.setBackground(Color.WHITE);
		centerMessage.setFont(new Font("Californian FB",Font.BOLD,30));
		frame.add(centerMessage);
		frame.setTitle("TestCenterMessage");
		frame.setSize(300,150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class CenterMessage extends JPanel{
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		FontMetrics fm = g.getFontMetrics();
		int stringWidth = fm.stringWidth("Welcome to Java");
		int stringAscent = fm.getAscent();
		int xCoordinate = getWidth() / 2 - stringWidth / 2;
		int yCoordinate = getHeight() / 2 - stringAscent / 2;
		g.drawString("Welcome to Java", xCoordinate, yCoordinate);
	}
}