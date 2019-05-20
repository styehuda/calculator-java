package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Panels extends JFrame implements ActionListener {
    
    Calculator calc = new Calculator();
    
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    
    JButton c1 = new JButton("1");
    JButton c2 = new JButton("2");
    JButton c3 = new JButton("3");
    JButton c4 = new JButton("4");
    JButton c5 = new JButton("5");
    JButton c6 = new JButton("6");
    JButton c7 = new JButton("7");
    JButton c8 = new JButton("8");
    JButton c9 = new JButton("9");
    JButton c0 = new JButton("0");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton multi = new JButton("*");
    JButton div = new JButton("%");
    JButton point = new JButton(".");
    JButton res = new JButton("=");
    
    JTextArea text = new JTextArea("0");
    
    public Panels(){
        super("Calculator");
        panel.setLayout(new GridLayout(4,4));
        JButton [] buttons = {c1,c2,c3,plus,c4,c5,c6,minus,c7,c8,c9,multi,c0,point,res,div};
        
        for (int i=0; i<buttons.length; i++){
            panel.add(buttons[i]);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Serif",Font.BOLD,32));
        }
        
        text.setEditable(false);
        text.setFont(new Font("Serif",Font.BOLD,32));
        text.setBackground(Color.lightGray);

        add(text,BorderLayout.NORTH);
        add(panel,BorderLayout.SOUTH);
        panel.setPreferredSize(new Dimension(350,350));
        setSize(350,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        String result = calc.setResult(e.getActionCommand());
        text.setText(result);
    }
}
