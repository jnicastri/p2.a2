package lms.mvc.model;

import lms.mvc.model.Holding;

import java.util.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 1
 */
public class LibraryCollection{
   
   private String collectionCode;
   private String collectionName;
   protected List<Holding> collHoldingList = new ArrayList<Holding>();
   
   public LibraryCollection(){}
   
   public LibraryCollection(String collCode, String name){
      
      this.collectionCode = collCode;
      this.collectionName = name;
      
   }
   
   public boolean addHolding(Holding holding){
      
      boolean success = true;
      
      for(Holding h : this.collHoldingList){
         if(h.getCode() == holding.getCode()){
            success = false;
            break;
         }
      }
      if(success == true){
         collHoldingList.add(holding);
      }
      return success;
   }
   
   public Holding[] getAllHoldings(){
      
      if(this.collHoldingList.size() > 0){
         return collHoldingList.toArray(new Holding[collHoldingList.size()]);
      }
      else{
         return null;
      }
   }
   
   public Holding getHolding(int code){
      
      Holding found = null;
      
      for(Holding holding : collHoldingList){
         if(holding.getCode() == code){
            found = holding;
         }  
      }
      return found;
   }
   
   public boolean removeHolding(int code){
      
      boolean success = false;
      Holding found = null;
      
      for(Holding holding : collHoldingList){
         if(holding.getCode() == code){
            found = holding;
         }
      }
      if(found != null){
         collHoldingList.remove(found);
         success = true;
      }
      return success;
   }
   public String toString(){
      
      String strRep = this.collectionCode + ":" + this.collectionName + ":";
      
      if(collHoldingList.size() > 0){
         for(Holding holding : collHoldingList){
            strRep += "," + holding.getCode();
         }
      }
      return strRep;
   }

}
