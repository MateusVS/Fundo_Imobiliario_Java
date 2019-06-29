import java.io.IOException;
import java.util.Scanner;

public class FundoImobiliario {
    public static void main(String[] args) throws IOException {
        Imobiliario imobiliario = new Imobiliario();

        int opcao; 
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("******   Bem-vindo ao Fundo Imobiliario   ******");
            System.out.println("------------------------------------------------");
            System.out.println("****** Selecione uma das seguintes opcoes ******");
            System.out.println("------------------------------------------------");
            System.out.println("|                                              |");  
            System.out.println("|  1 - Efetuar cadastro                        |");  
            System.out.println("|                                              |");
            System.out.println("|  2 - Editar dados pessoais                   |"); 
            System.out.println("|                                              |");
            System.out.println("|  3 - Movimentar conta via TED                |"); 
            System.out.println("|                                              |");
            System.out.println("|  4 - Ler cotações do dia                     |");
            System.out.println("|                                              |");
            System.out.println("|  5 - Compra/Venda de cotas                   |"); 
            System.out.println("|                                              |");
            System.out.println("|  6 - Ler dividendos do mes                   |"); 
            System.out.println("|                                              |");          
            System.out.println("|  10 - Visualizar dados de usuario    (prov)  |"); 
            System.out.println("|                                              |");   
            System.out.println("|  11 - Salvar informacoes de usuario  (prov)  |"); 
            System.out.println("|                                              |");   
            System.out.println("|  12 - Visualizar lista de FII`s      (prov)  |"); 
            System.out.println("|                                              |");
            System.out.println("|  13 - Visualizar cotas de usuario    (prov)  |"); 
            System.out.println("|                                              |");                
            System.out.println("|  0 - Sair do sistema                         |");
            System.out.println("------------------------------------------------");
            System.out.println("                                                "); 
            System.out.println("************************************************");
            System.out.println("                                                ");

            opcao = input.nextInt();

            if (opcao == 1) {
                System.out.println("\n");
                imobiliario.CadastrarInvestidor();
            }

            if (opcao == 2){
                System.out.println("\n");
                imobiliario.Editar();
            }

            if (opcao == 3) {
                System.out.println("\n");
                imobiliario.Movimenta();
            }

            if (opcao == 4){
                System.out.println("\n");
                imobiliario.Ler();
            }

            if (opcao == 5) {
                imobiliario.Compra();    
            }

            if (opcao == 6) {
                imobiliario.div();
            }
            
            if (opcao == 10){
                imobiliario.Exibe();
            }

            if (opcao == 11){
                imobiliario.Salva();
            }

            if (opcao == 12){
                imobiliario.Exibe2();
            }

            if (opcao == 13) {
                imobiliario.myCotas();
            }

            if (opcao == 0) {
                System.out.println("\n **** Encerrando sistema, ate mais *****");    
            }
            
        } while (opcao != 0); 
        input.close();

    }
}