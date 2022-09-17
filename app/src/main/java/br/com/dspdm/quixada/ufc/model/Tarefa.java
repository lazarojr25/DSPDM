package br.com.dspdm.quixada.ufc.model;

import java.util.Date;

public class Tarefa
{
    private static int geradorIds = 0;

    int id,status;
    String nomeTarefa;
    String descricaoTarefa;
    String statusTarefa;
    Date dataInicio;
    Date dataTermino;

    public Tarefa(String nomeTarefa, String descricaoTarefa, String statusTarefa, Date dataInicio, Date dataTermino) {
        this.nomeTarefa = nomeTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.statusTarefa = statusTarefa;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public Tarefa() {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public int getId() {
        return id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public String gettSatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(String statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nomeTarefa='" + nomeTarefa + '\'' +
                ", statusTarefa=' "+ statusTarefa+'\''+
                ", descricaoTarefa='" + descricaoTarefa + '\'' +
                '}';
    }
}
