public class FII {
   private String Nome;
   private String Codigo;
   private double valor_cota;
   private double total;
   private int qtdd;

   public FII() {
      this( "", "", 0.0, 0.0, 0 );
   } 

   public FII(String Nome, String codigo, double valor_cota, double total, int qtdd ) {
      setNome(Nome);
      setCodigo(Codigo);
      setValorCota(valor_cota);
      setTotal(total);
      setQtdd(qtdd);
   } 
   
   public void setNome( String Nome ) {
        this.Nome = Nome;
   }

   public String getNome(){
        return this.Nome;
   }

   public void setCodigo( String Codigo ) {
      this.Codigo = Codigo;
   }

   public String getCodigo(){
      return this.Codigo;
   } 

   public void setValorCota ( Double valor_cota ) {
      this.valor_cota = valor_cota;
   } 

   public double getValorCota() {
      return this.valor_cota;
   }

   public void setTotal (Double total){
       this.total = total;
   }

   public double getTotal(){
       return this.total;
   }

   public void setQtdd (int qtdd){
       this.qtdd = qtdd;
   }

   public int getQtdd(){
       return this.qtdd;
   }
}