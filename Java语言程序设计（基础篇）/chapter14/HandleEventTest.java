import javax.swing.*;
import java.awt.event.*;

public class HandleEventTest{
	public static void main(String[] args){
		JFrame frame = new HandleEvent();
		frame.setTitle("Handle Event");
		frame.setSize(200,150);
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class HandleEvent extends JFrame{
	public HandleEvent(){
		JButton jbtOK = new JButton("OK");
		JButton jbtCancel = new JButton("Cancel");

		JPanel panel = new JPanel();
		panel.add(jbtOK);
		panel.add(jbtCancel);
		add(panel);

		OKListenerClass okListener = new OKListenerClass();
		CancelListenerClass cancelListener = new CancelListenerClass();
		jbtOK.addActionListener(okListener);
		jbtCancel.addActionListener(cancelListener);
	}
}

class OKListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("OK button clicked");
	}
}

class CancelListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("Cancel button clicked");
	}
}