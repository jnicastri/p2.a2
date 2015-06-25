package lms.mvc.model;

import lms.mvc.model.util.DateUtil;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 1
 */
public abstract class AbstractHolding implements Holding {

   private String borrowDate;
   private int code;
   private String title;
   private boolean loaned;
   
   public AbstractHolding(){ }
   public AbstractHolding(int code, String title){  
      this.code = code;
      this.title = title;
      this.loaned = false;
   }
   
   public String getBorrowDate(){ return borrowDate; }
   public int getCode(){ return code; }   
   public String getTitle(){ return title; }
   
   public boolean isOnLoan(){ return loaned; }
   public void setBorrowDate(){ 
      
      if(this.loaned == false){
         borrowDate = DateUtil.getInstance().getDate(); 
         this.loaned = true;
      }
      else{
         this.loaned = false;
      }
   }
   
   public abstract int getDefaultLoanFee();
   public abstract int getMaxLoanPeriod();  
   public abstract String toString();
   
}
