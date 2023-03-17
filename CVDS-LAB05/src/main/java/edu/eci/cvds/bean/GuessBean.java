package edu.eci.cvds.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Random;

@ManagedBean(name = "GuessBean")
/**
 * @author Santiago Naranjo Melo
 */
@SessionScoped
//@SessionScoped
public class GuessBean {
    private int numeroAdivinar;
    private int intentos;
    private int acomulado;
    private String estado;
    private int numeroUsuario;
    private String intentosFallidos;

    public GuessBean(){
        restart();
    }

    public void guess(int numero){
        if(estado != "Gano" && numero>=0 && numero <=15 && acomulado > 0){
            intentos++;
            if(numero==numeroAdivinar){
                estado="Gano";
            }else{
                acomulado -= 10000;
                estado="Fallo";
                intentosFallidos += " " + String.valueOf(numero)+",";
            }
        }
    }

    public void restart(){
        Random rand = new Random();
        numeroAdivinar = rand.nextInt(16);
        acomulado = 100000;
        intentos = 0;
        estado = "adivinar un numero entre el 0 y el 15";
        intentosFallidos= "";
    }

    public String getIntentosFallidos(){
        return intentosFallidos;
    }

    public void setIntentosFallidos(String intentosF){
        intentosFallidos=intentosF;
    }

    public int getNumeroAdivinar(){
        return numeroAdivinar;
    }

    public int getIntentos(){
        return intentos;
    }

    public int getAcomulado(){
        return acomulado;
    }

    public String getEstado(){
        return estado;
    }

    public void setNumeroAdivinar(int numero){
        numeroAdivinar = numero;
    }

    public void setIntentos(int intentos){
        this.intentos= intentos;
    }

    public void setAcomulado(int acomumlado){
        this.acomulado = acomulado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public void setNumeroUsuario(int numero){
        numeroUsuario = numero;
    }
    public int getNumeroUsuario(){
        return numeroUsuario;
    }

}