/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
/**
 *
 * @author UPS
 */
public class VentanaPrincipal extends JFrame {
    private JLabel celsiusLabel;
    private JLabel fahrenheitLabel;
    private JButton convertirButton;
    private JTextField celsiusTextField;
    
    public void addConvertirButtonActionListener(ActionListener listener){
        convertirButton.addActionListener(listener);
    }
    
    public String getCelsius(){
        return celsiusTextField.getText();
    }
    
    public void setFahrenheit(int fahr){
        fahrenheitLabel.setText(fahr + " Fahrenheit");
    }
    
    public VentanaPrincipal(){
        setSize(400, 200);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        
        celsiusTextField = new JTextField("");
        celsiusTextField.setBounds(5,5,100,30);
        add(celsiusTextField);
        
        celsiusLabel = new JLabel("Celsius");
        celsiusLabel.setBounds(110, 5, 100, 30);
        add(celsiusLabel);
        
        convertirButton = new JButton("Convertir");
        convertirButton.setBounds(5, 40, 100, 30);
        add(convertirButton);
        
        fahrenheitLabel = new JLabel("Fahrenheit");
        fahrenheitLabel.setBounds(110, 40, 100, 30);
        add(fahrenheitLabel);
    }
}
