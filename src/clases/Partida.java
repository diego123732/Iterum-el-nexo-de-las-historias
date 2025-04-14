package clases;

import java.time.Duration;
import java.time.LocalDateTime;

import utilidades.ManipulacionBD;

public class Partida {

    private PersonajePrinc personajePrincipalPartida;
    private final LocalDateTime FECHA_INICIO_PARTIDA;
    private LocalDateTime fechaFinalPartida;
    private int dineroTotalPartida;
    private double dañoTotalPartida;
    private Duration duracionPartida;

    

    public void setDuracionPartida(Duration duracionPartida) {
        this.duracionPartida = duracionPartida;
    }

    public Partida() {
        this.personajePrincipalPartida = null;
        this.FECHA_INICIO_PARTIDA = LocalDateTime.now();
        this.fechaFinalPartida = FECHA_INICIO_PARTIDA;
        this.dineroTotalPartida = 15;
        this.dañoTotalPartida = 0;
        this.duracionPartida = Duration.between(FECHA_INICIO_PARTIDA, fechaFinalPartida);
        ManipulacionBD.PrimerGuardarDatos(this);
    }

    public PersonajePrinc getPersonajePrincipalPartida() {
        return personajePrincipalPartida;
    }

    public void setPersonajePrincipalPartida(PersonajePrinc personajePrincipalPartida) {
        this.personajePrincipalPartida = personajePrincipalPartida;
    }

    public LocalDateTime getFechaInicioPartida() {
        return FECHA_INICIO_PARTIDA;
    }

    public LocalDateTime getFechaFinalPartida() {
        return fechaFinalPartida;
    }

    public void setFechaFinalPartida(LocalDateTime fechaFinalPartida) {
        this.fechaFinalPartida = fechaFinalPartida;
    }

    public int getDineroTotalPartida() {
        return dineroTotalPartida;
    }

    public void setDineroTotalPartida(int dineroTotalPartida) {
        this.dineroTotalPartida = dineroTotalPartida;
    }

    public double getDañoTotalPartida() {
        return dañoTotalPartida;
    }

    public void setDañoTotalPartida(double dañoTotalPartida) {
        this.dañoTotalPartida = dañoTotalPartida;
    }
    
    public LocalDateTime getFECHA_INICIO_PARTIDA() {
        return FECHA_INICIO_PARTIDA;
    }

    public Duration getDuracionPartida() {
        return duracionPartida;
    }

    
}
