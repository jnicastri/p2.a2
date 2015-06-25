package lms.mvc.model;

import java.util.*;
import lms.mvc.model.exception.*;

/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 1
 */
public abstract class AbstractMember implements Member {

   private String memberId;
   private String fullName;
   protected List<Holding> currentHoldings = new ArrayList<Holding>();
   protected BorrowingHistory historyList;
   
   public AbstractMember(){
      
   }
   public AbstractMember(String ID, String name){
      
      this.memberId = ID;
      this.fullName = name;
      this.historyList =  new BorrowingHistory();
   }

   public List<HistoryRecord> getBorrowingHistory(){
      
      return historyList.getAllHistoryRecords();
   }
   public HistoryRecord getHistoryRecord(Holding h){
      
      return this.historyList.getHistoryRecord(h);
   }
   public List<Holding> getCurrentHoldings(){
      
      return currentHoldings;
   }
   public String getFullName(){ return this.fullName; }

   public String getMemeberId(){  return this.memberId; }
   
   public abstract int getMaxCredit();
   public abstract void resetCredit();
   public abstract void returnHolding(Holding h)throws OverdrawnCreditException;
   public abstract String toString();
   public abstract int calculateRemainingCredit();
   public abstract void borrowHolding(Holding h) throws MultipleBorrowingException, InsufficientCreditException;
}
