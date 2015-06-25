package lms.mvc.model.exception;

@SuppressWarnings("serial")
public class OverdrawnCreditException extends LMSException{
   
   public OverdrawnCreditException(){
      super();
   }
   public OverdrawnCreditException(String message){
      super(message);
   }

}
