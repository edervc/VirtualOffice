package com.evcvirtualofficelanguages.virtualofficeforlanguages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataHelper {

    private GregorianCalendar gc;
    private Date dataParaManipular;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public DataHelper() {
    }

    public DataHelper(Date data){
        this.gc = new GregorianCalendar();
        this.gc.setTime(data);
        this.dataParaManipular = data;
    }

    public DataHelper(String data){
        try {
            this.gc = new GregorianCalendar();
            this.gc.setTime(formatter.parse(data));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Date getData(){
        return this.dataParaManipular;
    }

    public void adicionarDias(int quantidade){
        adicionar(quantidade, Calendar.DAY_OF_MONTH);
    }

    public void adicionarMeses(int quantidade){
        adicionar(quantidade, Calendar.MONTH);
    }

    public void adicionarAnos(int quantidade){
        adicionar(quantidade, Calendar.YEAR);
    }

    private void adicionar(int quantidade, int tipoCampo){
        gc.add(tipoCampo, quantidade);
        dataParaManipular = gc.getTime();
    }

    public int getMinutos(){
        return getCampo(Calendar.MINUTE);
    }

    public int getHoras(){
        return getCampo(Calendar.HOUR);
    }

    private int getCampo(int tipoCampo){
        return gc.get(tipoCampo);
    }

    public Integer comparar(String data){
        try {
            return comparar(formatter.parse(data));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public int comparar(Date data){
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return gc.compareTo(c);
    }

    public String getAsString(){
        return formatter.format(dataParaManipular);
    }

}