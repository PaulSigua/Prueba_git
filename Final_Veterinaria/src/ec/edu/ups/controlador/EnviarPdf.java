/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
//Opcional
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class EnviarPdf {
    
    private String correo = "sebas8022002@gmail.com";
    
    private String password = "dtwxyodrxsckwzal";
    
    public EnviarPdf() {
    }
    
    public void enviar(String correoDestino, String mensajeDeTexto, String ruta,String nombreFile) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", correo);
            p.setProperty("mail.smtp.auth", "true");
            Session s = Session.getDefaultInstance(p);
            
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensajeDeTexto);
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
            adjunto.setFileName(nombreFile);
            
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            m.addBodyPart(adjunto);
            
            
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(correo));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
            mensaje.setSubject("Facturación Electronica Clinica Veterinaria");
            mensaje.setContent(m);
            
            Transport t = s.getTransport("smtp");
            t.connect(correo, password);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog(null, "Mensaje enviado");
        } catch (MessagingException e) {
            
        }
    }
}
