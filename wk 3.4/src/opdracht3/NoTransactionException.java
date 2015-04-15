package opdracht3;

public class NoTransactionException extends Exception {
public NoTransactionException(){
	super("kopen is mislukt,want heeft er al een");
}
public NoTransactionException(String message){
	super(message);
}
}
