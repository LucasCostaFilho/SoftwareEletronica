package Desenvolvimento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TerminalExperimentalRecibo {

    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ArrayList<Recibo> listaRecibos = new ArrayList<Recibo>();
        boolean loop = true;

        while (loop == true) {
            System.out.println("Digite [1] para criar um novo recibo");
            System.out.println("Digite [2] para listar os recibos cadastrados");
            System.out.println("Digite [3] para editar um recibo cadastrado");
            System.out.println("Digite [4] para emitir um recibo em especifico");
            System.out.println("Digite [5] para sair");

            int opcao = ler.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Digite o ID do recibo: ");
                    int idRecibo = ler.nextInt();
                    System.out.println("Digite o ID do serviço: ");
                    int idServico = ler.nextInt();
                    System.out.println("Digite o valor: ");
                    float valor = ler.nextFloat();
                    ler.nextLine();
                    System.out.println("Digite a data de pagamento. Use o formato (dd/mm/aaaa): ");
                    String dataPagamentoString = ler.nextLine();
                    try {
                        Date dataDePagamento = sdf.parse(dataPagamentoString);
                        Recibo recibo = new Recibo(idRecibo, idServico, valor, dataDePagamento);
                        listaRecibos.add(recibo);
                    } catch (java.text.ParseException e) {
                        System.out.println(
                                "Formato de data inválido. A data não foi definida.\nSe você quiser, poderá definir a data editando esse recibo.");
                        Date dataDePagamento = null;
                        Recibo recibo = new Recibo(idRecibo, idServico, valor, dataDePagamento);
                        listaRecibos.add(recibo);
                    }
                    break;

                case 2:
                    Recibo.listarRecibo(listaRecibos);
                    break;

                case 3:
                    Recibo.editarRecibo(listaRecibos);
                    break;

                case 4:
                    System.out.println("ID do recibo que deseja emitir: ");
                    int idDesejado = ler.nextInt();
                    Recibo.emitirRecibo(idDesejado, listaRecibos);
                    break;

                case 5:
                    System.out.println("Programa encerrado.");
                    loop = false;
                    break;
            }
        }

    }
}