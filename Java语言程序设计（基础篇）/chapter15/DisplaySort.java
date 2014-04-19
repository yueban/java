import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class DisplaySort extends JFrame{
	public static void main(String[] args){
		DisplaySort frame = new DisplaySort();
	}

	private int[] num = new int[50];
	private int index = 0;
	private int minIndex;

	public DisplaySort(){
		randomSort();
		SortPanel sortPanel = new SortPanel();
		add(sortPanel);
		setTitle("DisplaySort");
		setBackground(Color.BLACK);
		setSize(300,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		sortPanel.sort();
	}

	public void randomSort(){
		int size = 0;
		while(size < num.length){
			int temp = (int)(Math.random() * num.length + 1);
			if(!isStored(temp,size)){
				num[size++] = temp;
			}
		}
	}

	public boolean isStored(int n,int size){
		if(size == 0){
			return false;
		}
		for(int i = 0;i < size;i++){
			if(num[i] == n){
				return true;
			}
		}
		return false;
	}

	class SortPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			int height = getHeight();
			int width = 300;
			int widthBase = width / num.length;
			int heightBase = (height - 20) / num.length;
			for(int i = 0;i < num.length;i++){
				if(i == index){
					g.setColor(Color.RED);
				}else if(i == minIndex){
					g.setColor(Color.GREEN);
				}else{
					g.setColor(Color.BLUE);
				}
				if(index >= num.length - 1){
					g.setColor(Color.BLUE);
				}
				g.fillRect(i * widthBase, height - heightBase * num[i], widthBase, heightBase * num[i]);
			}

		}

		public void sort(){
			Timer timer = new Timer();
			timer.schedule(new SortTimer(),1000,200);
		}
	}

	class SortTimer extends TimerTask{
		private int count = num.length;
		public void run(){
			if(index < count){
				minIndex = index;
				for(int j = index;j < num.length;j++){
					if(num[minIndex] > num[j]){
						minIndex = j;
					}
				}
				repaint();
				new Timer().schedule(new TimerTask() {   
					public void run() {
						if(minIndex != index){
						int temp = num[index];
						num[index] = num[minIndex];
						num[minIndex] = temp;
						}
						index++;
						this.cancel();
					}},50);
			}else{
				this.cancel();
			}
		}
	}
}

