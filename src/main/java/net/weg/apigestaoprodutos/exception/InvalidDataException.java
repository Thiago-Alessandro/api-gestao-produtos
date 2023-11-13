package net.weg.apigestaoprodutos.exception;

public class InvalidDataException extends RuntimeException{

    public InvalidDataException(){
        super("Dado inválido!");
    }

}
