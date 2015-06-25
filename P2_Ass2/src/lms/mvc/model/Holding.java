package lms.mvc.model;

public interface Holding{

   public int calulateLateFee(int days);
   public String getBorrowDate();   
   public int getCode();   
   public int getDefaultLoanFee();   
   public int getMaxLoanPeriod();   
   public String getTitle();   
   public boolean isOnLoan();   
   public void setBorrowDate();
}
