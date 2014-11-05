/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utn.resumiderobilletes.excepciones;

/**
 *
 * @author libanez
 */
public class ResumideroValidationException extends Exception  {
    
    private static final String ERROR = "Error de Validación: ";

    public ResumideroValidationException(String message) {
        super(ERROR + message);
    }

    public ResumideroValidationException(String message, Throwable cause) {
        super(ERROR + message, cause);
    }
    
}
