package lms.mvc.model;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 1
 */
public class Video extends AbstractHolding {
  
   private int loanFee;
   private static final int MAX_LOAN_PERIOD = 7;
  
   public Video(){}
   
   public Video(int code, String title, int loanFee){
      
      super(code, title);
      this.loanFee = loanFee;
      
   }
   @Override
   public int calulateLateFee(int days) {
      
      int fee = days * (loanFee / 2);
      
      return fee;
   }
   @Override
   public int getDefaultLoanFee() { return loanFee; }
   @Override
   public int getMaxLoanPeriod() { return MAX_LOAN_PERIOD; }
   @Override
   public String toString(){
         
      String formattedString = this.getCode() + ":" + this.getTitle() + ":" + this.getDefaultLoanFee()
                                 + ":" + this.getMaxLoanPeriod() + ":VIDEO";
      return formattedString;
   }
}
