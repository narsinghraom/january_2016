package example.readexcel;

import java.text.DecimalFormat;
class AddZeroz
{
    public static void main(String [] args)
    {
        int x=127;
        DecimalFormat df = new DecimalFormat("00000");
        System.out.println(df.format(x));
    }
}