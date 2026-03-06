package soal1;

public class Commission extends Hourly
{
    private double totalSales;
    private final double commissionRate;

    public Commission (String eName, String eAddress, String ePhone,
                   String socSecNumber, double rate, double commRate)
    {
        super (eName, eAddress, ePhone, socSecNumber, rate);
        commissionRate = commRate;
        totalSales = 0;
    }

    public void addSales (double Sales)
    {
        totalSales += Sales;
    }


    public String toString()
    {
        String result = super.toString();
        result += "\nTotal sales: " + totalSales;
        return result;
    }

    public double pay()
    {
        double payment = super.pay() + (commissionRate * totalSales);
        totalSales = 0;
        return payment;
    }
}
