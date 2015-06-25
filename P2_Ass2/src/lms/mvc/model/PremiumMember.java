package lms.mvc.model;

import java.util.List;

import lms.mvc.model.exception.InsufficientCreditException;
import lms.mvc.model.exception.MultipleBorrowingException;
import lms.mvc.model.util.DateUtil;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 1
 */
public class PremiumMember extends AbstractMember {
   
   private static final int MAX_CREDIT = 45;
   private int currentCredit;
   
   public PremiumMember(){ super(); }
   
   public PremiumMember(String ID, String name){
      
      super(ID, name);
      this.currentCredit = MAX_CREDIT;
   }

   @Override
   public String toString() {
      return super.getMemeberId() + ":" + super.getFullName() + ":" + this.currentCredit + ":PREMIUM";
   }

   @Override
   public int getMaxCredit() {
      return MAX_CREDIT;
   }

   @Override
   public void resetCredit() {
      this.currentCredit = MAX_CREDIT; 
   }

   @Override
   public int calculateRemainingCredit() {
      return this.currentCredit;
   }
   public void borrowHolding(Holding h) throws MultipleBorrowingException, InsufficientCreditException{
      
      boolean prevBorrow = false;
      List<HistoryRecord> hList = this.historyList.getAllHistoryRecords();
      
      for(HistoryRecord r : hList){
         if(r.getHolding().equals(h)){
            prevBorrow = true;
         }
      }
      if(prevBorrow == true){
         throw new MultipleBorrowingException("Previously Borrowed - Forbidden Action!");
      }
      else{
         if(this.currentCredit - h.getDefaultLoanFee() >= 0){
            this.currentHoldings.add(h);
            this.currentCredit -= h.getDefaultLoanFee();
         }
         else{
            throw new InsufficientCreditException("Insufficient Credit to borrow holding");
         }
      } 
   }
   @Override
   public void returnHolding(Holding h) {
      
      int loanDays = DateUtil.getInstance().getElapsedDays(h.getBorrowDate());
      int overdue = loanDays - h.getMaxLoanPeriod();
      int fees = 0;
      
      if(overdue > 0){
         fees = h.calulateLateFee(overdue);
      }
      
      super.currentHoldings.remove(h);
      h.setBorrowDate();
      this.historyList.addHistoryRecord(h, h.getDefaultLoanFee(), fees);
      this.currentCredit -= fees;
   }
   


}
