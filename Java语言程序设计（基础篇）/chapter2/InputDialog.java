import javax.swing.JOptionPane;

public class InputDialog{
	public static void main(String[] args){
		String a = JOptionPane.showInputDialog("Please enter something!");
		JOptionPane.showMessageDialog(null,"Thanks for entering: " + a);
		String b = JOptionPane.showInputDialog(null,"Please enter something","This is a InputDialog",JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(null,"Thanks again for enter: " + b,"This is a MessageDialog",JOptionPane.INFORMATION_MESSAGE);
	}
}