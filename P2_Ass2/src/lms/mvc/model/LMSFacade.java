package lms.mvc.model;

import lms.mvc.model.exception.InsufficientCreditException;
import lms.mvc.model.exception.MultipleBorrowingException;
import lms.mvc.model.exception.OverdrawnCreditException;
import lms.mvc.model.util.DateUtil;

/**
 * @author Mikhail Perepletchikov 06/2013
 */
public class LMSFacade implements LMSModel {

	/* you need to implement all LMSModel methods here */
	
	// this shows an example of using the provided DateUtil class to set the current date
   
   private Library lib;
   
	public void setDate(String currentDate) {
		DateUtil.getInstance().setDate(currentDate);
	}
	
	public LMSFacade(){
	   this.lib = new Library();
	}

   @Override
   public void addMember(Member member) {
      this.lib.addMember(member);
   }

   @Override
   public void addCollection(LibraryCollection collection) {
      this.lib.addCollection(collection); 
   }

   @Override
   public Member getMember() {
      return this.lib.getMember();
   }

   @Override
   public LibraryCollection getCollection() {
      return this.lib.getCollection();
   }

   @Override
   public boolean addHolding(Holding holding) {
      
      return this.lib.addHolding(holding);
   }

   @Override
   public boolean removeHolding(int holdingId) {
      
      return this.lib.removeHolding(holdingId);
   }

   @Override
   public Holding getHolding(int holdingId) {
      return this.lib.getHolding(holdingId);
   }

   @Override
   public Holding[] getAllHoldings() { 
      return this.lib.getAllHoldings();
   }

   @Override
   public void borrowHolding(int holdingId) throws InsufficientCreditException,
         MultipleBorrowingException {
      this.lib.borrowHolding(holdingId);
   }

   @Override
   public void returnHolding(int holdingId) throws OverdrawnCreditException {
      this.lib.returnHolding(holdingId);  
   }

   @Override
   public HistoryRecord[] getBorrowingHistory() {
      return this.lib.getBorrowingHistory();
   }

   @Override
   public HistoryRecord getHistoryRecord(int holdingId) {
      return this.lib.getHistoryRecord(holdingId);
   }

   @Override
   public Holding[] getBorrowedHoldings() {
      return this.lib.getBorrowedHoldings();
   }
   @Override
   public void resetMemberCredit() {
      this.lib.resetCredit();   
   }

   @Override
   public int calculateRemainingCredit() {
      return this.lib.calculateRemaingCredit();
   }

   @Override
   public int calculateTotalLateFees() {
      return this.lib.calculateTotalLateFees();
   }
}