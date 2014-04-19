import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlCircle2 extends JFrame{
	public static void main(String[] args){
		ControlCircle2 frame = new ControlCircle2();
		frame.setTitle("ControlCircle2");
		frame.setSize(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public ControlCircle2(){
		JPanel panel = new JPanel();
		panel.add(jbtEnlarge);
		panel.add(jbtShrink);
		jbtEnlarge.addActionListener(new JButtonClickListener());
		jbtShrink.addActionListener(new JButtonClickListener());

		this.add(canvas,BorderLayout.CENTER);
		this.add(panel,BorderLayout.SOUTH);
	}

	private JButton jbtEnlarge = new JButton("Enlarge");
	private JButton jbtShrink = new JButton("Shrink");
	private CirclePanel canvas = new CirclePanel();

	class JButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == jbtEnlarge){
				canvas.enlarge();
			}else if(e.getSource() == jbtShrink){
				canvas.shrink();
			}
		}
	}

	class CirclePanel extends JPanel{
		private int radius = 5;

		public void enlarge(){
			radius++;
			repaint();
		}

		public void shrink(){
			radius--;
			repaint();
		}

		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
		}
	}
}