package lms.mvc.model;

import lms.mvc.model.exception.*;
import java.util.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 1
 */
public class Library{
   
   private LibraryCollection libColl;
   private Member member;
   
   public Library(){}
   
   public void addCollection(LibraryCollection lib){
      
      this.libColl = lib;
   }
   
   public boolean addHolding(Holding hldng){
      
      return this.libColl.addHolding(hldng); 
   }
   
   public boolean addMember(Member m){
      this.member = m;
      return true;
   }
   
   public void borrowHolding(int code) throws MultipleBorrowingException, InsufficientCreditException{
      
      Holding found = null;
      
      for(Holding h : this.libColl.collHoldingList){
         if(h.getCode() == code){
            found = h;
         }
      }
      this.member.borrowHolding(found);
      found.setBorrowDate();
   }
   
   public int calculateRemaingCredit(){
      return this.member.calculateRemainingCredit();
   }
   
   public int calculateTotalLateFees(){
      List<HistoryRecord> Hlist = this.member.getBorrowingHistory();
      int fees = 0;
      
      for(HistoryRecord r : Hlist){
         fees += r.getAccumulatedFees();
      }
      return fees;
   }
   
   public Holding[] getAllHoldings(){
      return this.libColl.getAllHoldings();
   }

   public Holding[] getBorrowedHoldings(){
      
      List<Holding> bList = new ArrayList<Holding>();
      
      for(Holding h : this.libColl.collHoldingList){
         if(h.isOnLoan() == true){
            bList.add(h);
         }
      }
      if(bList.size() > 0){
         return bList.toArray(new Holding [bList.size()]);
      }
      else{
         return null;
      }
   } 
   public HistoryRecord[] getBorrowingHistory(){
      
      List<HistoryRecord> HList = this.member.getBorrowingHistory();
      
      if(HList.size() > 0){
         return HList.toArray(new HistoryRecord[HList.size()]);
      }
      else{
         return null;
      }
   }
   
   public LibraryCollection getCollection(){
      
      return this.libColl;
   }
   
   public HistoryRecord getHistoryRecord(int ID){
      
      Holding found = null;
      
      for(Holding h : this.libColl.collHoldingList){
         if(h.getCode() == ID){
            found = h;
         }
      }
      return this.member.getHistoryRecord(found);
   }
   
   public Holding getHolding(int code){
      
      return this.libColl.getHolding(code);
   }
   
   public Member getMember(){
      
      return this.member;
   }
   
   public boolean removeHolding(int ID){
      boolean removed = false;
      Holding found = null;
      for(Holding cH : this.libColl.collHoldingList){
         if(cH.getCode() == ID){
            found = cH;
         }
      }
      if(found != null && found.isOnLoan() != true){
         this.libColl.collHoldingList.remove(found);
         removed = true;
      }
      return removed;
   }
   
   public void resetCredit(){
      this.member.resetCredit();
   }
   
   public void returnHolding(int code)throws OverdrawnCreditException{
      
      Holding found = null;
      
      for(Holding h : this.libColl.collHoldingList){
         if(h.getCode() == code){
            found = h;
         }
      }
      this.member.returnHolding(found);
   }
}
