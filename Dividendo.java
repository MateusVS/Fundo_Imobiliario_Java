public class Dividendo {
    private String Codigo;
    private double valor;
 
    public Dividendo() {
       this( "", 0.0);
    } 
 
    public Dividendo(String Codigo, double valor) {
       setCodigo(Codigo);
       setValor(valor);
    } 
 
    public void setCodigo( String Codigo ) {
       this.Codigo = Codigo;
    }
 
    public String getCodigo(){
       return this.Codigo;
    } 
 
    public void setValor ( Double valor ) {
       this.valor = valor;
    } 
 
    public double getValor() {
       return this.valor;
    }
 }