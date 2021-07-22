package proyecto.sismoit.tareas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import proyecto.sismoit.model.Servicio;


@Slf4j
@Component
public class Programadas {
    
    @Autowired
    private Servicio servicio;

    @Scheduled(fixedRate = 3600000)
    public void EnviarCoreos() {
        servicio.enviarEmail("contacto@sismoit.com", "Hola desde Spring.", "Tarea programada cada  1 hora");
    }
}
