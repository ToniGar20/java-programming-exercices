package Practice3.solucionCajero;

public class TarjetaDebito extends Tarjeta {

    private double saldo;

    public TarjetaDebito() {
    }

    public TarjetaDebito(String nif, int pin, String nombre, String apellido, double saldo) {
        super(nif, pin, nombre, apellido);
        this.setSaldoDisp(saldo);
    }
    
    public TarjetaDebito(TarjetaDebito t1) {
        super((Tarjeta) t1);
        this.setSaldoDisp(t1.getSaldoDisp());
    }
    
    public double getSaldoDisp() {
        return saldo;
    }

    public void setSaldoDisp(double saldo) {
        this.saldo = saldo;
    }

    public void aumentaSaldoDisp(double saldo) {
        this.setSaldoDisp(this.getSaldoDisp()+saldo);
    }

    @Override
    public void disminuirSaldoDisp(double saldo) {
        this.setSaldoDisp(this.getSaldoDisp()-saldo);
    }

    @Override
    public void mostrarTarjeta() {
        //un metodo para comprobar la evolución de los saldos de tarjetas 
        //y cajero.
        super.mostrarTarjeta();
        System.out.println("Tarjeta de débito:");
        System.out.println("Saldo: " + this.getSaldoDisp());
    }    
}