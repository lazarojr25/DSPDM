package br.com.dspdm.quixada.ufc.model;

import java.util.Date;

public class Atividade
{
    private static int geradorIds = 0;

    int id;
    String assuntoAtividade;
    String statusAtividade;
    Date dataInicio;
    Date dataTermino;
    Tarefa tarefaPaiId;

    public Atividade(String assuntoAtividade, String statusAtividade, Date dataInicio, Date dataTermino)
    {
        this.assuntoAtividade = assuntoAtividade;
        this.statusAtividade = statusAtividade;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }


    public Tarefa getTarefaPaiId() {
        return tarefaPaiId;
    }

    public void setTarefaPaiId(Tarefa tarefaPaiId) {
        this.tarefaPaiId = tarefaPaiId;
    }

    public String getAssuntoAtividade() {
        return assuntoAtividade;
    }

    public void setAssuntoAtividade(String assuntoAtividade) {
        this.assuntoAtividade = assuntoAtividade;
    }

    public String getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(String statusAtividade) {
        this.statusAtividade = statusAtividade;
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
        return "Atividade{" +
                "id=" + id +
                ", assuntoAtividade='" + assuntoAtividade + '\'' +
                ", statusAtividade=' "+ statusAtividade+'\''+
                ", dataInicio='" + dataInicio + '\'' +
                ", dataTermino='" + dataTermino + '\'' +
                '}';
    }
}
