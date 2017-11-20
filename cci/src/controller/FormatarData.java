/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gabri
 */
public class FormatarData {

    public static void main(String args[]) {
        String txtdataBR = "20/11/2017";
        String txtdtBR = "20-11-2017";

        String txtdataUS = "2017/11/20";
        String txtdtUS = "2017-11-20";

        String txthora = "15:43";

        System.out.println(completarHora(txthora));
        System.out.println("\n-------------------------------------------\n");

        System.out.println(juntarDataHora(txtdtUS, txthora));
        System.out.println("\n-------------------------------------------\n");

        System.out.println("Data e Hora Atual:\n");
        GettingCurrentDateAndTime();
        System.out.println("\n-------------------------------------------\n");

        System.out.println("Data formatada com SimpleDateFormat:\n");
        DateFormattingUsingSimpleDateFormat();
        System.out.println("\n-------------------------------------------\n");

        System.out.println("Data formatada usando printf:\n");
        DateFormattingUsingPrintf();
        System.out.println("\n-------------------------------------------\n");

        System.out.println("Data formatada usando printf segundo exemplo:\n");
        DateFormattingUsingPrintfSegundo();
        System.out.println("\n-------------------------------------------\n");

        System.out.println("Data formatada usando printf terceiro exemplo:\n");
        DateFormattingUsingPrintfTerceiro();
        System.out.println("\n-------------------------------------------\n");

        System.out.println("Parsing de String para Date:\n");
        ParsingStringsIntoDates();
        System.out.println("\n-------------------------------------------\n");
        
        System.out.println("Converter Date.Util para Date.SQL:\n");
        ConvertUtilDateToSqlDate();
        System.out.println("\n-------------------------------------------\n");
    }

    public static void GettingCurrentDateAndTime() {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date using toString()
        System.out.println(date.toString());
    }

    public static void DateFormattingUsingSimpleDateFormat() {
        Date dNow = new Date();
        SimpleDateFormat ft
                = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println("Current Date: " + ft.format(dNow));
    }

    public static void DateFormattingUsingPrintf() {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date
        String str = String.format("Current Date/Time : %tc", date);

        System.out.printf(str);
    }

    public static void DateFormattingUsingPrintfSegundo() {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date
        System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);
    }

    public static void DateFormattingUsingPrintfTerceiro() {
        // Instantiate a Date object
        Date date = new Date();

        // display formatted date
        System.out.printf("%s %tB %<te, %<tY", "Due date:", date);
    }

    public static void ParsingStringsIntoDates() {
        //20-11-2017 Parses as Fri May 10 00:00:00 BRT 26
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String data = "2017-11-20";
        String input = data.isEmpty() ? "1818-11-11" : data;

        System.out.print(input + " Parses as ");
        Date t;
        try {
            t = ft.parse(input);
            System.out.println(t);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }
    }

    public static void ConvertUtilDateToSqlDate() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("utilDate:" + utilDate);
        System.out.println("sqlDate:" + sqlDate);
    }

    public static String completarHora(String hora) {
        return hora.concat(":00");
    }

    public static String juntarDataHora(String data, String hora) {
        String datahora = data + " " + completarHora(hora);
        return datahora;
    }
}
