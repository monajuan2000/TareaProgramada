package proyecto.sismoit.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class Servicio {
    
    
   @Autowired
    private JavaMailSender javaMailSender;
   
    
    public void enviarEmail(String to, String body, String topic){
        log.info("*****************Creando correo********************************"); 
        String mensaje = fecha();
        SimpleMailMessage nuevoMensaje = new SimpleMailMessage();
        nuevoMensaje.setFrom("jmona9919@gmail.com");
        nuevoMensaje.setTo(to);
        nuevoMensaje.setSubject(topic);
        nuevoMensaje.setText(body + "\n" + mensaje);
        this.javaMailSender.send(nuevoMensaje);
        log.info("*****************Enviando correo********************************");
    }
    private static String fecha(){
        log.info("*****************Formato de fecha (min,seg,milisegundos)*********");
        Date fecha = new Date();
        DateFormat formato1 = new SimpleDateFormat("mm:ss.SSS");
        DateFormat formato2 = new SimpleDateFormat("SSS");
        String fechaFormato1 = formato1.format(fecha);
        String fechaFormato2 = formato2.format(fecha);
        log.info("*****************"+fechaFormato1+"(min,seg,milisegundos)*********");
        log.info("*****************"+fechaFormato2+"(misegundos)*********");
        String mensaje = calcularParMilisegundos(fechaFormato2);
        mensaje = fechaFormato2+ " " +mensaje;
        return mensaje;
    }
    private static String calcularParMilisegundos(String fechaFormato){
        int fechaInt = Integer.parseInt(fechaFormato);
        if(fechaInt %2 ==0){
            log.info("la hora en milisegundos es par.");
            String mensaje = ", la hora en milisegundos es par.";
            return mensaje;
        }else{
             log.info("la hora en milisegundos es impar.");
             String mensaje = ", la hora en milisegundos es impar.";
             return mensaje;
        }
    } 
}
