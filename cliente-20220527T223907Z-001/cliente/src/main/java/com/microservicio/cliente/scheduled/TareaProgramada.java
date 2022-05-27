package com.microservicio.cliente.scheduled;


import com.microservicio.cliente.service.IInversionService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class TareaProgramada
 * @date 12-05-2022
 */
@Component
public class TareaProgramada {

    private final IInversionService iInversionService;

    public TareaProgramada(IInversionService iInversionService) {
        this.iInversionService = iInversionService;
    }

    /**
     *Metodo que se ejecuta automaticamente todos los dias a las 00:05
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @class TareaProgramada
     * @date 12-05-2022
     */
   // @Scheduled(cron = "0 25 15 ? * mon-fri")
    @Modifying
   // @Scheduled(fixedRate = 10000)
    //@Scheduled(cron = "0 45 17 ? * mon-fri")
    @Scheduled(fixedRate = 60000)
    public void CalcularSaldoProductos() {
        this.iInversionService.calcularRendimientos();
        System.out.println("tarea programada");
    }
}
