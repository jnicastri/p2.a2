package lms.mvc.model.exception;

@SuppressWarnings("serial")
public class InsufficientCreditException extends LMSException{

public InsufficientCreditException(){
      super();
   }
   public InsufficientCreditException(String message){
      super(message);
   }
}
