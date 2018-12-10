package wage.display.javafx;
import java.text.DecimalFormat;

public class Wage{
    private double hour, rate, base, overtime, total, tax, net;
    private DecimalFormat df = new DecimalFormat("0.00");
    public Wage(double hour, double rate){
        this.hour = hour;
        this.rate = rate;
    }
    public double getBase(){
        base = hour>37.5?(37.5*rate) : (hour*rate);
        return base;
    }
    public double getOver(){
        overtime = hour > 37.5? (hour - 37.5)*1.5*rate : 0;
        return overtime;
    }
    public double getTotal(){
        total = base + overtime;
        return total;
        
    }
    public double getTax(){
        if(total<=1000){
            tax =0;
        }else if(total>1000 && total<=2000){
            tax = total*0.2;
        }else{
            tax = total*0.3;
        }    
        return tax;
    }
    public double getNet(){
        net = total - tax;
        return net;
        
    }
    public String toString(){
        String s = "Base pay is $ "+ df.format(getBase())+"\nOvertime pay is $ "+df.format(getOver())+
        "\nTotal pay is $ "+df.format(getTotal())+"\nTax deducted is $ "+df.format(getTax())+
        "\nNet pay is $ "+df.format(getNet());
        return s;
        }
}
