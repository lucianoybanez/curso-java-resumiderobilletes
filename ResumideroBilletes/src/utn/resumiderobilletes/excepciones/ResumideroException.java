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
public class ResumideroException extends RuntimeException {

    public ResumideroException(String message) {
        super(message);
    }

    public ResumideroException(String message, Throwable cause) {
        super(message, cause);
    }

}
