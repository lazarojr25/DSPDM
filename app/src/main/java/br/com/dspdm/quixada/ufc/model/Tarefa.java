package br.com.dspdm.quixada.ufc.model;

import java.util.Date;

public class Tarefa
{
    Integer id;
    String nomeTarefa;
    String status;
    Date dataInicio;
    Date dataTermino;


    public Tarefa(String nomeTarefa, String status, Date dataInicio, Date dataTermino) {
        this.nomeTarefa = nomeTarefa;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public Integer getId() {
        return id;
    }


    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nomeTarefa='" + nomeTarefa + '\'' +
                ", status='" + status + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                '}';
    }
}
