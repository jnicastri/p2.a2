package lms.mvc.model;

import lms.mvc.model.Holding;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 1
 */
public class HistoryRecord {
   
   private Holding recordHolding;
   private int fees;
   private int baseCost;
   
   public HistoryRecord(){ }
   
   public HistoryRecord(Holding holding, int base, int fee){
      this.recordHolding = holding;
      this.fees = fee;
      this.baseCost = base;
   }
   public Holding getHolding(){ return this.recordHolding; }
   
   public String toString(){
      int fullfee = this.fees + this.baseCost;
      
      return this.recordHolding.getCode() + ":" + fullfee;
   }
   public int getAccumulatedFees(){ return this.fees; }
}
