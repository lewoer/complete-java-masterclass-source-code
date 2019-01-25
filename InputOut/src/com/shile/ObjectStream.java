package com.shile;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 21:34 2019/1/21
 */
public class ObjectStream {
    static final String dataFile = "invoicedata";
    static final BigDecimal[] prices = {
            new BigDecimal("19.99"),
            new BigDecimal("9.99"),
            new BigDecimal("15.99"),
            new BigDecimal("3.99"),
            new BigDecimal("4.99")};
    static final int[] units = {12, 8, 13, 29, 50};
    static final String[] descs = {"Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain"};

    public static void main(String[] args) throws IOException,ClassNotFoundException{
        // readObject不会返回期望的对象类型，cast到正确的类型可能引发ClassNotFoundException
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            out.writeObject(Calendar.getInstance());
            for (int i = 0; i < prices.length; i++) {
                out.writeObject(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        }
        BigDecimal total = null;
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            BigDecimal price;
            int unit;
            String desc;
            boolean eof = false;
           total = new BigDecimal(0);
            Calendar date = (Calendar) in.readObject();

            System.out.format ("日期为 %tA, %<tB %<te, %<tY:%n", date);

            while (!eof) {
                price = (BigDecimal) in.readObject();
                unit = in.readInt();
                desc = in.readUTF();
                System.out.format("You ordered %d units of %s at $%.2f%n",
                        unit, desc, price);
                total = total.add(price.multiply(new BigDecimal(unit)));
            }
        } catch (EOFException eof) {

        }catch (ClassNotFoundException cnfe) {
            cnfe.getMessage();
        }
        System.out.format("For a TOTAL of: $%.2f%n", total);
    }
}
