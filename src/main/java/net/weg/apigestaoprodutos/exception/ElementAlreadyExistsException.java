package net.weg.apigestaoprodutos.exception;

public class ElementAlreadyExistsException extends RuntimeException{

    public ElementAlreadyExistsException(){
        super("O elemento já existe no banco de dados.");
    }

}
