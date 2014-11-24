/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Luciano
 */
public class DateUtil {
    
    
    public static String toStringDate(Date fecha){
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
        return df.format(fecha);
    }
    
}
