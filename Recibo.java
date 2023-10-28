package Desenvolvimento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Recibo {
    private int idRecibo;
    private int idServico;
    private float valor;
    private Date dataDePagamento;
    private Date dataDeEmissao;

    // Construtor

    public Recibo(int idRecibo, int idServico, float valor, Date dataDePagamento) {
        this.idRecibo = idRecibo;
        this.idServico = idServico;
        this.valor = valor;
        this.dataDePagamento = dataDePagamento;
        this.dataDeEmissao = new Date();
    }

    // Getters

    public int getIdRecibo() {
        return idRecibo;
    }

    public int getIdServico() {
        return idServico;
    }

    public float getValor() {
        return valor;
    }

    public Date getDataDePagamento() {
        return dataDePagamento;
    }

    public Date getDataDeEmissao() {
        return dataDeEmissao;
    }

    // Setters

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setDataDePagamento(Date dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public void setDataDeEmissao(Date dataDeEmissao) {
        this.dataDeEmissao = dataDeEmissao;
    }

    // Métodos

    public static void emitirRecibo(int idDesejado, ArrayList<Recibo> listaRecibos) {
        boolean encontrado = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (listaRecibos.isEmpty()) {
            System.out.println("Nenhum recibo cadastrado.");
        } else {
            for (Recibo recibo : listaRecibos) {
                if (recibo.getIdRecibo() == idDesejado) {
                    System.out.println("Recibo encontrado:");
                    System.out.println("-------------------------------");
                    System.out.println("ID do Recibo: " + recibo.getIdRecibo());
                    System.out.println("ID do Serviço: " + recibo.getIdServico());
                    System.out.println("Data de Pagamento: " + sdf.format(recibo.getDataDePagamento()));
                    System.out.println("Valor: " + recibo.getValor());
                    System.out.println("Data de Emissão: " + sdf.format(recibo.getDataDeEmissao()));
                    System.out.println("-------------------------------\n");
                    encontrado = true;
                    break;
                }
            }
        }

    }

    public static void editarRecibo(ArrayList<Recibo> listaRecibos) {
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean encontrado = false;
        Recibo reciboEditar = null;

        if (listaRecibos.isEmpty()) {
            System.out.println("Nenhum recibo cadastrado.");
        } else {
            listarRecibo(listaRecibos);

            System.out.println("Qual o ID do recibo que deseja editar?");
            int idEditar = ler.nextInt();

            for (Recibo recibo : listaRecibos) {
                if (recibo.getIdRecibo() == idEditar) {
                    reciboEditar = recibo;
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                // Edição do ID do serviço
                System.out.println("Novo ID do Serviço: ");
                int novoId = ler.nextInt();
                reciboEditar.setIdServico(novoId);

                // Edição do valor
                System.out.println("Novo valor: ");
                float novoValor = ler.nextFloat();
                reciboEditar.setValor(novoValor);

                // Edição da data de pagamento
                System.out.println("Nova data de pagamento: ");
                ler.nextLine();
                String novaDataString = ler.nextLine();
                try {
                    java.util.Date novaData = sdf.parse(novaDataString);
                    reciboEditar.setDataDePagamento(novaData);
                } catch (java.text.ParseException e) {
                    System.out.println("Formato de data inválido. A data não foi alterada.");
                }

                System.out.println("Recibo editado!");

            } else {
                System.out.println("Recibo não existe.");
            }
        }
    }

    public static void listarRecibo(ArrayList<Recibo> listaRecibos) {

        if (listaRecibos.isEmpty()) {
            System.out.println("Nenhum recibo cadastrado.");
        } else {
            System.out.println("Recibos cadastrados: ");
            for (Recibo recibo : listaRecibos) {
                System.out.println("-------------------------------");
                System.out.println("ID do recibo: " + recibo.getIdRecibo());
                System.out.println("ID do Servico: " + recibo.getIdServico());
                System.out.println("Data de pagamento: " + recibo.getDataDePagamento());
                System.out.println("Valor: " + recibo.getValor());
                System.out.println("Data de emissao: " + recibo.getDataDeEmissao());
                System.out.println("-------------------------------\n");
            }
        }
    }

}