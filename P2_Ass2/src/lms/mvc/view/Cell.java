package lms.mvc.view;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

import lms.mvc.model.Book;
import lms.mvc.model.Holding;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
//Cell view - each holding object within the mainContent pane
@SuppressWarnings("serial")
public class Cell extends JPanel {
	
	private Holding holding;
	private DTWindow mainContent; //Link to model
	private String name;
	private int code;
	private int maxLoanDays;
	private int defaultLoanFee;
	private PopUpMenu popUp;
	
	public Cell(DTWindow mainContent, Holding holding){
		
		super();
		this.mainContent = mainContent;
		this.popUp = new PopUpMenu(this);
		
		this.holding = holding;
		this.name = holding.getTitle();
		this.code = holding.getCode();
		this.maxLoanDays = holding.getMaxLoanPeriod();
		this.defaultLoanFee = holding.getDefaultLoanFee();
		
		this.setLayout(new GridLayout(4, 1));
	
		this.add(new JLabel(" Holding Name: " + name));
		this.add(new JLabel(" Holding Code: " + code));
		this.add(new JLabel(" Loan Period: " + maxLoanDays));
		this.add(new JLabel(" Default Loan Fee: " + defaultLoanFee));
		
		Border lineBorder;
		
		if(this.holding instanceof Book){
			lineBorder = new LineBorder(Color.BLUE, 3);
		}
		else{
			lineBorder = new LineBorder(Color.RED, 3);
		}
		
		this.setBorder(lineBorder);
		
		this.setComponentPopupMenu(popUp);

	}
	public int getCode(){
		return this.code;
	}
	public DTWindow getMainContent(){
		return this.mainContent;
	}
	public Holding getClickedHolding(){
		return this.holding;
	}
}
