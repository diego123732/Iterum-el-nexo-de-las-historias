package clases;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;

import historias.Historia;
import utilidades.ManipulacionBD;

public class Partida {

    private PersonajePrinc personajePrincipalPartida;
    private final LocalDateTime FECHA_INICIO_PARTIDA;
    private LocalDateTime fechaFinalPartida;
    private LocalTime horaInicioPartida;
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
        this.duracionPartida = Duration.ZERO;
        this.horaInicioPartida = LocalTime.now();
    }

    public Partida (LocalDateTime fechaInicioPartida, int dineroTotalPartida, double dañoTotalPartida, Duration duracionPartidaGuardada) {
        this.personajePrincipalPartida = null;
        this.FECHA_INICIO_PARTIDA = fechaInicioPartida;
        this.fechaFinalPartida = FECHA_INICIO_PARTIDA;
        this.dineroTotalPartida = dineroTotalPartida;
        this.dañoTotalPartida = dañoTotalPartida;
        this.duracionPartida = duracionPartidaGuardada;
        this.horaInicioPartida = LocalTime.now();
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
        this.duracionPartida = duracionPartida.plus(Duration.between(this.horaInicioPartida, LocalTime.now()));
        return duracionPartida;
    }

    public LocalTime getHoraInicioPartida() {
        return horaInicioPartida;
    }
    public void setHoraInicioPartida(LocalTime horaInicioPartida) {
        this.horaInicioPartida = horaInicioPartida;
    }    
}
