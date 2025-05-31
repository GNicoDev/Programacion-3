package Ejercicio2;

public class ObjetoLaberinto {
    private Integer valor;
    private Boolean norte, sur, este, oeste;


    public ObjetoLaberinto(Integer valor, Boolean norte, Boolean sur, Boolean este, Boolean oeste) {
        this.valor = valor;
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Boolean getNorte() {
        return norte;
    }

    public void setNorte(Boolean norte) {
        this.norte = norte;
    }

    public Boolean getSur() {
        return sur;
    }

    public void setSur(Boolean sur) {
        this.sur = sur;
    }

    public Boolean getEste() {
        return este;
    }

    public void setEste(Boolean este) {
        this.este = este;
    }

    public Boolean getOeste() {
        return oeste;
    }

    public void setOeste(Boolean oeste) {
        this.oeste = oeste;
    }
}
