class Investidor{
    private String nome;
    private String cpf;
    private String nomeBanco;
    private int agencia;
    private String nConta;
    private double saldo;
    private double saldoFundo;

    public Investidor(String nome, String cpf, String nomeBanco, int agencia, String nConta, double saldo, double saldoFundo){
        this.nome = nome;
        this.cpf = cpf;
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.nConta = nConta;
        this.saldo = saldo;
        this.saldoFundo = saldoFundo;
    }

    public Investidor(){
        nome = "";
        cpf = "";
        nomeBanco = "";
        agencia = 0;
        nConta = "";
        saldo = 0.0;
        saldoFundo = 0.0;
    }
  
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setNomeBanco(String nomeBanco){
        this.nomeBanco = nomeBanco;
    }

    public String getNomeBanco(){
        return this.nomeBanco;
    }

    public void setAgencia(int agencia){
        this.agencia = agencia;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setNConta(String nConta){
        this.nConta = nConta;
    }

    public String getNConta(){
        return this.nConta;
    }
        
    public void setSaldo(double getSaldo){
        this.saldo = getSaldo;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldoFundo(double saldoFundo){
        this.saldoFundo = saldoFundo;
    }

    public double getSaldoFundo(){
        return this.saldoFundo;
    }

}
