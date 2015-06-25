package lms.mvc.model.exception;

@SuppressWarnings("serial")
public class MultipleBorrowingException extends LMSException {
   
   public MultipleBorrowingException() {
      super();
   }
   
   public MultipleBorrowingException(String message){
      super(message);
   }

}
