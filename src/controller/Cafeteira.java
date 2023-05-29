package controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Cafeteira {
    private int qtdCafe,qtdAgua;
    private Status status;

    public Cafeteira(int qtdCafe, int qtdAgua, Status status) {
        this.qtdCafe = qtdCafe;
        this.qtdAgua = qtdAgua;
        this.status = status;
    }

    public Cafeteira() {
        this.qtdCafe = 0;
        this.qtdAgua = 0;
        this.status = Status.DESLIGADA;
    }
    
    public void ligar() {
        if(status.equals(Status.DESLIGADA)){
            status = Status.PRONTO;
            atualizarStatus();
        }
    }
    public void desligar() {
        if(!status.equals(Status.DESLIGADA)){
            status = Status.valueOf("DESLIGADA");
        }
    }

    public void encherCafe(int qtd) { 
        if(!status.equals(Status.DESLIGADA)){
            if(qtd > 0) qtdCafe += qtd;
            atualizarStatus();
        }     
    }
    
    public void encherAgua(int qtd) {
        if(!status.equals(Status.DESLIGADA)){
            if(qtd > 0) qtdAgua += qtd;
            atualizarStatus();
        }   
    }

    public boolean fazerCafe(int qtd) {
        if((qtd * 7) <= qtdCafe && (qtd *30) <= qtdAgua && status.equals(Status.PRONTO)){
            qtdCafe -= (qtd * 7);
            qtdAgua -= (qtd * 30);
            atualizarStatus();
            return true;
        }
        return false;
    }

    public String toLog() {        
        LocalTime data = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        return "Cafeteira: Cafe= " + qtdCafe + ", Agua= " + qtdAgua + ", Status= " + status + ", Data= " + data.format(formato) + "\n";
    }

    private void atualizarStatus() {
        if(qtdAgua <= 30) status = Status.REPOR_AGUA;
        else if(qtdCafe <= 7) status = Status.REPOR_CAFE;
        else status = Status.PRONTO;
    }

    private int numXicara(){
        return ((qtdAgua/30) < (qtdCafe/7))? (int)qtdAgua/30 :(int)qtdCafe/7;
    }

    public int getQtdCafe() {
        return qtdCafe;
    }
    public void setQtdCafe(int qtdCafe) {
        this.qtdCafe = qtdCafe;
        atualizarStatus();
    }
    public int getQtdAgua() {
        return qtdAgua;
    }
    public void setQtdAgua(int qtdAgua) {
        this.qtdAgua = qtdAgua;
        atualizarStatus();
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
        atualizarStatus();
    }
    @Override
    public String toString() {
        return "Cafeteira [qtdCafe=" + qtdCafe + ", qtdAgua=" + qtdAgua + ", status=" + status + ", é possível fazer "+ numXicara() +" Xícaras de café]";
    }
    
    
}
