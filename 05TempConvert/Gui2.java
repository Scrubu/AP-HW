import java.awt.event.*;
import javax.swing.*;
import java.awt.*; //needed for pane
public class Gui2 extends JFrame implements ActionListener{
    private Container pane;
    private JButton Farenheit,Celcius;
    private JLabel l;
    private JTextField text;
    private Container buttons;
    private Container textyStuff;


    public Gui2() {
				this.setTitle("Farenheit Converter");
				this.setSize(600,100);
				this.setLocation(100,100);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
				pane = this.getContentPane();
				pane.setLayout(new GridLayout(2,1));

				l = new JLabel("Temperature:",null,JLabel.CENTER);
				Farenheit = new JButton("Farenheit to Celcius");
				Celcius = new JButton("Celcius to Farenheit");
				text = new JTextField(40);
			        

                                // make the buttons call the actionListener
				Farenheit.setActionCommand("toFarenheit");
				Farenheit.addActionListener(this);
				Celcius.setActionCommand("toCelcius");
				Celcius.addActionListener(this);

				buttons = new Container();
				buttons.setLayout(new FlowLayout());
				buttons.add(Celcius);
				buttons.add(Farenheit);
			        
 				
				textyStuff = new Container();
				textyStuff.setLayout(new FlowLayout());
				textyStuff.add(l);
				textyStuff.add(text);

				//add the 2 containers
				pane.add(textyStuff);
				pane.add(buttons);
				
		}
                                    //look at which command is being executed, and choose an action
		public void actionPerformed(ActionEvent e){
				String action = e.getActionCommand();
				//System.out.println(action);
				if(action.equals("toFarenheit")){
				    String s = text.getText();
				    double total= Double.parseDouble(s);
					
				    s=""+(total+33.8);
				   
						
				    text.setText(s);
				}
				if(action.equals("toCelcius")){
				    String s = text.getText();
				    double total= Double.parseDouble(s);
					
				    s=""+(total-33.8);
						
				    text.setText(s);
				}
		}

    public static void main(String[] args) {
				Gui2 g = new Gui2();
				g.setVisible(true);
    }

}
