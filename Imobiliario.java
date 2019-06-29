import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

public class Imobiliario{

    Scanner input = new Scanner(System.in);
    
    public List<Investidor> cliente = new ArrayList<Investidor>();
    public List<FII> fii = new ArrayList<FII>();//Array de Cotas disponiveis para compra
    public List<FII> Cotas = new ArrayList<FII>();//Array de cotas que foram compradas pelo usuário
    public List<Dividendo> dividendos = new ArrayList<Dividendo>();

    public void CadastrarInvestidor(){
        Investidor investidor = new Investidor();
        System.out.println("Para cadastrar um novo cliente, preencha os dados a seguir: ");
        System.out.println("                                                "); 
        System.out.println("Informe o nome do investidor: ");
        investidor.setNome(input.next());
        System.out.println("                                                "); 
        boolean valido = false;
        do{
            System.out.println("Informe o numero do CPF: ");
            String novoCpf = input.next();
            if(!this.validaCpf(novoCpf)) {
                System.out.println("CPF inválido. Tente novamente!\n");
            }
            else {
                investidor.setCpf(novoCpf);
                valido = true;
                System.out.println("\n");
            }
        }while(valido == false);        
        System.out.println("Informe o nome do banco: ");
        investidor.setNomeBanco(input.next());
        System.out.println("                                                "); 
        System.out.println("Informe o numero da conta: ");
        investidor.setNConta(input.next());
        System.out.println("                                                "); 
        System.out.println("Informe o numero da agencia: ");
        investidor.setAgencia(input.nextInt());
        System.out.println("                                                "); 
        System.out.println("Informe o valor do saldo: ");   
        double saldo = 0.0;
        saldo = input.nextDouble();
        do{
            if (saldo <= -1.0) {
                System.out.println("Impossivel trabalhar com saldo negativo\nInforme novo saldo: ");
                saldo = input.nextDouble();
            } else {
                investidor.setSaldo(saldo);                
            }
        }while(saldo <= -1.0);


        cliente.add(investidor);
    }

	public void Exibe(){

        for (Investidor visualiza : cliente){
            System.out.println("Nome: " + visualiza.getNome());
            System.out.println("CPF: " + visualiza.getCpf());
            System.out.println("Nome do Banco: " + visualiza.getNomeBanco());
            System.out.println("Numero da Conta: " + visualiza.getNConta());
            System.out.println("Numero da agencia: " + visualiza.getAgencia());
            System.out.println("Valor do saldo: " + visualiza.getSaldo());
            System.out.println("Valor do saldo do fundo imobiliario: " + visualiza.getSaldoFundo());
       }

    }

    public void Editar(){
        System.out.println("Informe o cpf do usuario a ser editado: \n");   
        String cpf = input.next();

        for (Investidor x: cliente){
            String cpfEdit = x.getCpf();
            if (cpfEdit.equals(cpf)) {
                System.out.println("\nInforme o novo nome do usuario: \n");    
                String newNome = input.next();
                x.setNome(newNome);
                boolean valido = false;
                do{
                    System.out.println("Informe o novo numero do CPF: ");
                    String novoCpf = input.next();
                    if(!this.validaCpf(novoCpf)) {
                        System.out.println("CPF inválido. Tente novamente!\n");
                    }
                    else {
                        x.setCpf(novoCpf);
                        valido = true;
                        System.out.println("\n");
                    }
                }while(valido == false);      
                System.out.println("\nInforme o novo nome do banco: \n");    
                String newBanco = input.next();
                x.setNomeBanco(newBanco);
                System.out.println("\nInforme o novo numero da conta: \n");    
                String newConta = input.next();
                x.setNConta(newConta);
                System.out.println("\nInforme o novo numero da agencia: \n");    
                int newAgencia = input.nextInt();
                x.setAgencia(newAgencia);
                System.out.println("\nInforme o novo valor do saldo da conta: \n");    
                double newSaldo = input.nextDouble();
                x.setSaldo(newSaldo);
            }
        }
    }
	public void Movimenta() {
        System.out.println("Informe o cpf do usuario: \n");
        String cpf = input.next();           

        for (Investidor x: cliente){
            String cpfEdit = x.getCpf();
            if (cpfEdit.equals(cpf)) {
                int opcao;
                do {
                    System.out.println("******   Selecione uma das opcoes abaixo   ******");
                    System.out.println("-------------------------------------------------");
                    System.out.println("|   1 - Depositar em minha conta bancaria       |");
                    System.out.println("|   2 - Sacar em minha conta bancaria           |");
                    System.out.println("|   3 - Depositar em meu fundo imobiliario      |");
                    System.out.println("|   4 - Recuperar valor do meu fundo imobiliario|");
                    System.out.println("|   0 - Retornar ao menu anterior               |");
                    System.out.println("-------------------------------------------------");
                    opcao = input.nextInt();

                    switch(opcao) {

                        case 1:
                            System.out.println("Informe o valor a ser depositado na conta de "+ x.getNome() + ":\n");
                            double valor = 0.0;
                            do{
                                valor = input.nextDouble();
                                if (valor <= 0) {
                                    System.out.println("Valor invalido, tente novamente: \n");
                                }
                            }while(valor <= 0);
                            double saldo = x.getSaldo();
                            double total = valor + saldo;
                    
                            x.setSaldo(total);
                            System.out.println("Valor atualizado com sucesso, novo saldo e de: R$" + x.getSaldo());
                            break;

                        case 2:
                            System.out.println("Informe o valor a ser sacado na conta de "+ x.getNome() + ":\n");
                            double valor2 = 0.0;
                            double total2;
                            do {
                                do {
                                    valor2 = input.nextDouble();
                                    System.out.println("Valor invalido, tente novamente: \n");
                                }while(valor2 <= 0);

                                double saldo2 = x.getSaldo();
                                total2 = saldo2 - valor2;
                                if (total2 < 0 ) {
                                    System.out.println("Operacao impossivel, saldo negativo\nInforme novo valor: ");
                                }
                            } while (total2 <= 0 );
                            x.setSaldo(total2);
                            System.out.println("Valor atualizado com sucesso, novo saldo e de: R$" + x.getSaldo());
                            break;
                        
                            case 3:
                            System.out.println("Informe o valor a ser depositado no fundo imobiliario de "+ x.getNome() + ":\n");
                            double valor3 = 0.0; 
                            double totalBanco = 0.0;
                            do {
                                do{
                                    valor3 = input.nextDouble();
                                    if (valor3 <= 0) {
                                        System.out.println("Valor invalido, tente novamente: \n");
                                    }
                                }while(valor3 <= 0);

                                    double saldoBanco = x.getSaldo();
                                    totalBanco = saldoBanco - valor3;
                                    if (totalBanco < 0 ) {
                                        System.out.println("Operacao impossivel, saldo negativo\nInforme novo valor: ");
                                    }
                            } while (totalBanco <= 0 );
                            double saldo3 = x.getSaldoFundo();
                            double total3 = valor3 + saldo3;
                    
                            x.setSaldoFundo(total3);
                            x.setSaldo(totalBanco);
                            System.out.println("Valor atualizado com sucesso, novo saldo da conta bancaria e de: R$" + x.getSaldo());
                            System.out.println("Valor atualizado com sucesso, novo saldo do fundo imobiliario e de: R$" + x.getSaldoFundo());
                            break;
                        
                        case 4 :
                            System.out.println("Informe o valor a ser recuperado do fundo imobiliario de "+ x.getNome() + ":\n");
                                double valor4 = 0.0;
                                double total4;
                                double totalBanco2;
                                do {
                                    do {
                                        valor4 = input.nextDouble();
                                        System.out.println("Valor invalido, tente novamente: \n");
                                    }while(valor4 <= 0);
    
                                    double saldo4 = x.getSaldoFundo();
                                    total4 = saldo4 - valor4;
                                    if (total4 < 0 ) {
                                        System.out.println("Operacao impossivel, saldo negativo\nInforme novo valor: ");
                                    }

                                    double saldoBanco2 = x.getSaldo();
                                    totalBanco2 = saldoBanco2 + valor4;
                                    if (totalBanco2 < 0 ) {
                                        System.out.println("Operacao impossivel, saldo negativo\nInforme novo valor: ");
                                    }
                                } while (total4 <= 0 );

                                x.setSaldoFundo(total4);
                                x.setSaldo(totalBanco2);
                                System.out.println("Valor atualizado com sucesso, novo saldo da conta bancaria e de: R$" + x.getSaldo());
                                System.out.println("Valor atualizado com sucesso, novo saldo do fundo imobiliario e de: R$" + x.getSaldoFundo());
                                break;

                        default:
                            System.out.println("Opção inválida!\n");
                            break;
                    }
                } while (opcao != 0);
            
            }
        }
    }

    public boolean validaCpf(String novoCpf) {
        String regex = "(?!(\\d)\\1{10})\\d{11}";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(novoCpf);
        return mat.matches();
	}

	public void Salva() throws IOException {
        FileWriter arq = new FileWriter("info.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        for (Investidor y : cliente){
            gravarArq.printf("\n\n\n---------------------------------------------\n");
            gravarArq.printf("\nNome: " + y.getNome());
            gravarArq.printf("\nCPF: " + y.getCpf());
            gravarArq.printf("\nNome do Banco: " + y.getNomeBanco());
            gravarArq.printf("\nNumero da Conta: " + y.getNConta());
            gravarArq.printf("\nNumero da agencia: " + y.getAgencia());
            gravarArq.printf("\nValor do saldo: " + y.getSaldo());
            gravarArq.printf("\nValor do saldo do fundo imobiliario: " + y.getSaldoFundo());
            gravarArq.printf("\n---------------------------------------------\n\n\n");
       }
       arq.close();
       System.out.println("Dados salvos com sucesso !");

	}

    public void Ler() throws FileNotFoundException {
            String dia = "";
            int opcao;

            do {            
            System.out.println("|Selecione quais cotas deseja ler|");
            System.out.println("| 1- Primeiro dia                |");
            System.out.println("| 2- Segundo dia                 |");
            System.out.println("| 3- Terceiro dia                |");
            System.out.println("| 0- Voltar ao menu anterior     |");           
            System.out.println("--------------------------------");
            opcao = input.nextInt();
            
            if (opcao == 1) {
                dia = "dia1";
            } else if (opcao == 2) {
                dia = "dia2";
            } else if (opcao == 3){
                dia = "dia3";
            }              
            fii.clear();
            try{
        
                BufferedReader br = new BufferedReader(new FileReader(dia));
                while(br.ready()){
                    FII FII = new FII();
                    FII.setNome(br.readLine());
                    FII.setCodigo(br.readLine());
                    FII.setValorCota(Double.parseDouble(br.readLine()));
                    fii.add(FII);


                }
                br.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
            for (FII var : fii) {
                String cd = var.getCodigo();
                double valor = var.getValorCota();
                for (FII x : Cotas) {
                    if (cd.equals(x.getCodigo())) {
                        x.setValorCota(valor);
                        x.setTotal(x.getQtdd() * valor);
                    }
                }
            }
            Exibe2();
   } while (opcao != 0);
        
    }

    public void Exibe2(){

        for (FII visualiza : fii){
            System.out.println("------------------------------");
            System.out.println("Nome: " + visualiza.getNome());
            System.out.println("Codigo: " + visualiza.getCodigo());
            System.out.println("Valor: " + visualiza.getValorCota());
        }
    
    }

    public void Compra(){
        int opcao;
        do {
            System.out.println("******   Selecione uma das opcoes abaixo   ******");
            System.out.println("-------------------------------------------------");
            System.out.println("|   1 - Comprar cotas de fundo imobiliario      |");
            System.out.println("|   2 - Ver minhas cotas                        |");
            System.out.println("|   3 - Vender cotas de meu fundo imobiliario   |");
            //System.out.println("|   4 - Recuperar valor do meu fundo imobiliario|");
            System.out.println("|   0 - Retornar ao menu anterior               |");
            System.out.println("-------------------------------------------------");
            opcao = input.nextInt();  

            switch (opcao) {
                case 1:
                    String codigo;
                    System.out.println("Informe o codigo de uma das opcoes abaixo para comprar cotas:\n");
                    Exibe2();
                    codigo = input.next();
                    for (FII i : fii) {
                        String cd = i.getCodigo();
                        if (codigo.equals(cd)) {
                            System.out.println("Deseja realmente comprar cotas de " + i.getNome() +" ?\n");
                            System.out.println("1 - Sim\n");
                            System.out.println("2 - Não, retornar ao menu anterior");
                            int escolha;
                            escolha = input.nextInt();
                            switch (escolha) {
                                case 1:
                                    double saldo = 0.0;
                                    for (Investidor var : cliente) {
                                        saldo =  var.getSaldoFundo();
                                    }
                                    System.out.println("Informe o numero de cotas que deseja comprar: \n");
                                    int qtd = input.nextInt();
                                    double preco = i.getValorCota();
                                    double aux = preco * qtd;
                                    double total = saldo - aux;
                                    
                                    if (total >= 0) {
                                        String cod = i.getCodigo();

                                        if (cod.equals(cd)) {
                                            int x = i.getQtdd();
                                            double z = i.getTotal();
                                            Cotas.remove(i);
                                            x = x + qtd;
                                            z = z + aux;
                                            i.setQtdd(x);
                                            i.setTotal(z);
                                            Cotas.add(i);
                                        }else{
                                            i.setQtdd(qtd);
                                            i.setTotal(aux);
                                            Cotas.add(i);
                                        }
                                        for (Investidor y : cliente) {
                                            y.setSaldoFundo(total);    
                                            saldo = y.getSaldoFundo(); 
                                        }

                                        System.out.println("Parabens, voce adquiriu " + qtd + " cotas de " + i.getNome());
                                        System.out.println("Seu novo saldo do fundo imobiliario e de: R$" + saldo);
                                    }else {
                                        System.out.println("Saldo do fundo imobiliario insuficiente para realizar essa compra");
                                    }                            
                            }
                        }           
                    }
                    break;

               case 2:
                    myCotas();
                    break;
                
                case 3:
                    System.out.println("Para vender alguma de suas cotas, informe o codigo do FII de acordo com a lista:\n");
                    myCotas();
                    System.out.println("\n");
                    String x = input.next();
                    
                    for (FII var : Cotas) {
                        String cd = var.getCodigo();
                        if (x.equals(cd)) {
                            System.out.println("Deseja realmente vender cotas de "+ var.getNome() + " ?");
                            System.out.println("  1 - Sim\n  2 - Nao, retornar ao menu anterior");
                            int y = input.nextInt();

                            if (y == 1) {
                                int quant = 1, qtd = 0;
                                do{
                                    System.out.println("Informe a quantidade de cotas que deseja vender: ");
                                    quant = input.nextInt();
                                    qtd = var.getQtdd();

                                    if (qtd >= quant) {
                                        int z = qtd - quant;
                                        double valor = var.getValorCota();
                                        var.setQtdd(z);
                                        double valor2 = valor * quant;
                                        double saldo = var.getTotal();
                                        if (valor2 <= saldo) {
                                            double valor3;
                                            if (z == 0 ) {
                                                valor3 = 0;   
                                            } else {
                                                valor3 = saldo - valor2;         
                                               // System.out.println("Valor: "+ valor + "\nValor2: " + valor2 + "\nValor3: " + valor3);                                   
                                            }

                                            var.setTotal(valor3);
                                            for (Investidor v : cliente) {
                                                double saldoFundo = v.getSaldoFundo();
                                                double saldoFundo2 = saldoFundo + valor;
                                                v.setSaldoFundo(saldoFundo2);
                                                System.out.println("Venda efetuada com sucesso, saldo do FII atualizado, novo valor de R$" + v.getSaldoFundo());
                                            }
                                           System.out.println("Cotas atualizadas: ");
                                           myCotas();
                                        } else {
                                            System.out.println("Valor final acima do esperado, impossivel realizar venda");
                                        }
                                    } else {
                                        System.out.println("O valor informado e maior do que o numero de cotas que voce possui");
                                    }

                                }while (quant>qtd);                                
                                
                            } else {
                                Compra();
                            }
                        }                       
                    }
                    break;
            
                default:
                    System.out.println("Opcao invalida, tente novamente");
                    break;
            }
        
        }while(opcao != 0);
    }

    public void myCotas() {
        for (FII visualiza : Cotas){
            System.out.println("------------------------------");
            System.out.println("Nome: " + visualiza.getNome());
            System.out.println("Codigo: " + visualiza.getCodigo());
            System.out.println("Valor: " + visualiza.getValorCota());
            System.out.println("Quantidade: " + visualiza.getQtdd());   
            System.out.println("Total: " + visualiza.getTotal());
        }
    }

	public void div() throws FileNotFoundException{
        //Dividendo d = new Dividendo();
        try{
            BufferedReader b = new BufferedReader(new FileReader("dividendo1"));
            while(b.ready()){
                Dividendo dv = new Dividendo();
                dv.setCodigo(b.readLine());
                String a = b.readLine();
                dv.setValor(Double.parseDouble(a));
                dividendos.add(dv);
            }
            b.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        String cd;//codigo dividendo
        double valor;
        String codigo; //codigo usuario
        for (Dividendo var : dividendos) {
            cd = var.getCodigo();
            valor = var.getValor();
            for (FII x : Cotas) {
                codigo = x.getCodigo();

                if (codigo.equals(cd)) {
                    System.out.println("\n---------------------------");
                    System.out.println("Nome da cota: " + x.getNome());
                    System.out.println("Valor do dividendo: " + var.getValor());
                    for (Investidor y : cliente) {
                        double saldo = y.getSaldoFundo();
                        double valor2 = valor * x.getQtdd();
                        double saldo2  = saldo + valor2;
                        y.setSaldoFundo(saldo2);
                        System.out.println("Saldo atualizado de acordo com novos dividendos, novo saldo do FII e de: R$" + y.getSaldoFundo());
                    }
                }
            }
        }

	}
}