package lms.mvc.model;

public class Book extends AbstractHolding {
   /**
    * 
    * @author James Nicastri
    * Student# s3407908
    * SP2, 2013, Programming 2, Assignment 1
    */
   private static final int LOAN_FEE = 10;
   private static final int MAX_LOAN_PERIOD = 28;
  
   public Book(){}
   
   public Book(int code, String title){
      
      super(code, title); 
   }
   @Override
   public int calulateLateFee(int days) {
      
      int fee = days * 2;
      return fee;
   }
   @Override
   public int getDefaultLoanFee() { return LOAN_FEE; }
   @Override
   public int getMaxLoanPeriod() { return MAX_LOAN_PERIOD; }
   @Override
   public String toString(){
      
      String formattedString = this.getCode() + ":" + this.getTitle() + ":" + this.getDefaultLoanFee()
                              + ":" + this.getMaxLoanPeriod() + ":BOOK";
      return formattedString;
   }
}
