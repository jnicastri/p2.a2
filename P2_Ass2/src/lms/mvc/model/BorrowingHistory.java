package lms.mvc.model;

import java.util.*;

import lms.mvc.model.HistoryRecord;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 1
 */
public class BorrowingHistory {

   private List<HistoryRecord> bHistory = new ArrayList<HistoryRecord>();
   
   public BorrowingHistory(){}
   
   public void addHistoryRecord(Holding h, int base, int fee){
      bHistory.add(new HistoryRecord(h, base, fee));
   }
   
   public int calculateTotalLateFees(){
      
      int totalFees = 0;
      
      for(HistoryRecord r : this.bHistory){
         totalFees += r.getAccumulatedFees();
      }
      return totalFees;
   }
   
   public List<HistoryRecord> getAllHistoryRecords(){
      
      return bHistory;
   }
   public HistoryRecord getHistoryRecord(Holding h){
      
      HistoryRecord found = null;
      
      for(HistoryRecord r : bHistory){
         if(r.getHolding().equals(h))
            found = r;
      }
      return found;
   }  
}
