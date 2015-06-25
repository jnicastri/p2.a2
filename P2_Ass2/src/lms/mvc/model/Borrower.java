package lms.mvc.model;

import lms.mvc.model.exception.*;


public interface Borrower {

   public void borrowHolding(Holding holding)throws MultipleBorrowingException, InsufficientCreditException;
   
   public void returnHolding(Holding holding)throws OverdrawnCreditException;
}
