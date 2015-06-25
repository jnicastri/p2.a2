package lms.mvc.model;

import java.util.List;

public interface Member extends Borrower{

   public int calculateRemainingCredit();
   public List<HistoryRecord> getBorrowingHistory();   
   public List<Holding> getCurrentHoldings();   
   public String getFullName();   
   public int getMaxCredit();   
   public String getMemeberId();   
   public void resetCredit();   
   public HistoryRecord getHistoryRecord(Holding h);
}
