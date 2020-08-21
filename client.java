import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.BorderLayout;

public class Client {

	public static void main(String[] args) {

		Font font = new Font("Arial", Font.PLAIN, 20);
		JFrame frame = new JFrame("Calculator");
		JPanel panel = new JPanel();
		JTextArea textArea = new JTextArea();
		
		CalculatorSum calculator = new CalculatorSum();
		
		textArea.setFont(new Font("Arial", Font.PLAIN, 45));
		textArea.setEditable(false);
		textArea.setBounds(10, 10, 430, 340);
		
		// Frame layout set to BorderedLayout
		panel.setLayout(null);
		
		panel.setPreferredSize(new Dimension(450, 600));
		panel.add(textArea);
		
		textArea.setVisible(true);
		frame.setVisible(true);
		panel.setVisible(true);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>(Arrays.asList(new JButton("0"),
				new JButton("1"), new JButton("2"), new JButton("3"), new JButton("4"),
				new JButton("5"), new JButton("6"), new JButton("7"), new JButton("8"),
				new JButton("9"), new JButton("/"), new JButton("*"), new JButton("-"),
				new JButton("+"), new JButton("Enter")));
		
		JButton clear = new JButton("CLEAR");
		
		for(int i = 0; i < buttons.size(); i++)
		{
			buttons.get(i).setFont(font);
		}
		clear.setFont(new Font("Arial", Font.PLAIN, 15));
		
		int width = 100;
		int height = 50;
		
		buttons.get(0).setBounds(10, 540, width, height);
		clear.setBounds(120, 540, width, height);
		buttons.get(14).setBounds(230, 540, width, height);
		buttons.get(13).setBounds(340, 540, width, height);
		
		buttons.get(1).setBounds(10, 480, width, height);
		buttons.get(2).setBounds(120, 480, width, height);
		buttons.get(3).setBounds(230, 480, width, height);
		buttons.get(12).setBounds(340, 480, width, height);
		
		buttons.get(4).setBounds(10, 420, width, height);
		buttons.get(5).setBounds(120, 420, width, height);
		buttons.get(6).setBounds(230, 420, width, height);
		buttons.get(11).setBounds(340, 420, width, height);
		
		buttons.get(7).setBounds(10, 360, width, height);
		buttons.get(8).setBounds(120, 360, width, height);
		buttons.get(9).setBounds(230, 360, width, height);
		buttons.get(10).setBounds(340, 360, width, height);
		
		for(int i = 0; i < buttons.size(); i++)
		{
			buttons.get(i).setVisible(true);
		}
		
		clear.setVisible(true);

		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				int index = buttons.indexOf(ae.getSource());
				if(ae.getSource() == buttons.get(0) || ae.getSource() == buttons.get(1) ||
						ae.getSource() == buttons.get(2) || ae.getSource() == buttons.get(3) ||
						ae.getSource() == buttons.get(4) || ae.getSource() == buttons.get(5) ||
						ae.getSource() == buttons.get(6) || ae.getSource() == buttons.get(7) ||
						ae.getSource() == buttons.get(8) || ae.getSource() == buttons.get(9)) 
				{
					if(calculator.ET == true)
					{
						calculator.clear();
						calculator.ET = false;
					}
					if(calculator.sign == 0) {
						calculator.addToFirstNum(calculator.numbers[index] + "");
						textArea.setText(calculator.firstNum);
					}else {
						calculator.addToSecondNum(calculator.numbers[index] + "");
						textArea.setText(calculator.secondNum);
					}
				}
				else if(ae.getSource() == buttons.get(10) || ae.getSource() == buttons.get(11) ||
						ae.getSource() == buttons.get(12) || ae.getSource() == buttons.get(13)) 
				{
					// 4 - Divide, 3 - Multiply, 2 - Subtract, 1 - Add
					if(calculator.ET == true) {
						calculator.ET = false;
					}
					if(index == 10){
						calculator.sign = 4;
					}
					else if(index == 11){
						calculator.sign = 3;
					}
					else if(index == 12){
						calculator.sign = 2;
					}
					else if(index == 13){
						calculator.sign = 1;
					}
				}
				else if(ae.getSource() == buttons.get(14))
				{
					// Enter
					if(calculator.firstNum.length() > 0 && calculator.secondNum.length() > 0) {
						if(calculator.secondNum_AsInteger() == 0 && calculator.sign == 4) {
							textArea.setText("Error");
							calculator.clear();
						}else {
							calculator.calculate();
							textArea.setText(Integer.toString(calculator.total));
							calculator.firstNum  = Integer.toString(calculator.total);
							calculator.secondNum = "";
							calculator.sign = 0;
							calculator.ET = true;
						}
					}
					else {
					}
				}
				else if(ae.getSource() == clear)
				{
					calculator.clear();
					textArea.setText(Integer.toString(calculator.total));
				}
			}
		};
		
		for(int i = 0; i < buttons.size(); i++)
		{
			buttons.get(i).addActionListener(action);
		}
		clear.addActionListener(action);
		
		for(int i = 0; i < buttons.size(); i++)
		{
			panel.add(buttons.get(i));
		}
		panel.add(clear);

		frame.getContentPane().add(panel);
		frame.pack();

		

	}

}
