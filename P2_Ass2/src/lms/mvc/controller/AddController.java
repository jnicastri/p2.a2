package lms.mvc.controller;

import java.awt.event.*;

import javax.swing.*;

import lms.mvc.model.Book;
import lms.mvc.model.Video;
import lms.mvc.view.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
//Adds both Book & Video Holdings to the current collection
//Used by both MenuBar & ToolBar
public class AddController implements ActionListener {

	private ToolBar tb;
	private String type;
	private String code;
	private int codeInt;
	private String title;
	private Object loanFee = null;
	private Integer[] loanFees = {new Integer(4), new Integer(6)};
	
	public AddController(String type, ToolBar tb){

		this.type = type;
		this.tb = tb; //Link back to model
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		
		if(this.tb.getMainFrame().getModel().getCollection() != null){
			for(int i = 0; i < 1; i++){ //Procedure placed in a for-loop to allow easy break points
				if(this.type.equals("b")){ //Adding a Book
					try{
						code = JOptionPane.showInputDialog(this.tb.getMainFrame(), "Enter the new 8 digit holding code", 
															"Enter a new Book Holding", JOptionPane.QUESTION_MESSAGE);
						if(code.length() != 8){ //Validating input before sending to model
							JOptionPane.showMessageDialog(this.tb.getMainFrame(), "An Error has Occured.\nHolding code must be an integer of 8 characters\nPlease try again", 
															"Error", JOptionPane.ERROR_MESSAGE);
							break;
						}
						try{
							codeInt = Integer.parseInt(code); //Validating input before sending to model
						}
						catch(NumberFormatException e){
							JOptionPane.showMessageDialog(this.tb.getMainFrame(), "An Error has Occured.\nHolding code must be an integer of 8 characters\nPlease ensure your code does not contain letters", 
															"Error", JOptionPane.ERROR_MESSAGE);
							break;
						}
						boolean titleLoop;
						do{
							titleLoop = false;
							title = JOptionPane.showInputDialog(this.tb.getMainFrame(), "Enter the new Holdings name", 
															"Enter a new Book Holding", JOptionPane.QUESTION_MESSAGE);
							if(title.equals("")){
								JOptionPane.showMessageDialog(this.tb.getMainFrame(), "Please enter a name for the new holding", "No Title Submitted", JOptionPane.PLAIN_MESSAGE);
							}
							else{
								titleLoop = true;
							}
						}while (!titleLoop);
						
						boolean addBookHolding = tb.getMainFrame().getModel().addHolding(new Book(codeInt, title)); //Adding Book Holding
						
						if(addBookHolding)
							JOptionPane.showMessageDialog(this.tb.getMainFrame(), "New holding has been added to the Collection", 
															"Success!", JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(this.tb.getMainFrame(), "Unable to add the new holding to the Collection\nHolding code already exists", 
															"Failed", JOptionPane.ERROR_MESSAGE);
					}
					catch(NullPointerException e){ //Catches JOptionPane.CANCEL_OPTION
						break;
					}
				}
				else{
					try{
						code = JOptionPane.showInputDialog(this.tb.getMainFrame(), "Enter the new 8 digit holding code", "Enter a new Video Holding", 
															JOptionPane.QUESTION_MESSAGE);
						if(code.length() != 8){ //Validating input before sending to model
							JOptionPane.showMessageDialog(this.tb.getMainFrame(), "An Error has Occured.\nHolding code must be an integer of 8 characters\nPlease try again", 
															"Error", JOptionPane.ERROR_MESSAGE);
							break;
						}
						try{
							codeInt = Integer.parseInt(code); //Validating input before sending to model
						}
						catch(NumberFormatException e){
							JOptionPane.showMessageDialog(this.tb.getMainFrame(), "An Error has Occured.\nHolding code must be an integer of 8 characters\nPlease ensure your code does not contain letters", 
																					"Error", JOptionPane.ERROR_MESSAGE);
							break;
						}
						boolean titleLoop;
						do{
							titleLoop = false;
							title = JOptionPane.showInputDialog(this.tb.getMainFrame(), "Enter the new Holdings name", 
															"Enter a new Video Holding", JOptionPane.QUESTION_MESSAGE);
							if(title.equals("")){
								JOptionPane.showMessageDialog(this.tb.getMainFrame(), "Please enter a name for the new holding", "No Title Submitted", JOptionPane.PLAIN_MESSAGE);
							}
							else{
								titleLoop = true;
							}
						}while (!titleLoop);
						
						loanFee = JOptionPane.showInputDialog(this.tb.getMainFrame(), "Choose default loan fee amount", "Enter a new Video Holding", 
																JOptionPane.QUESTION_MESSAGE, null, loanFees, null);
						
						boolean addVideoHolding = tb.getMainFrame().getModel().addHolding(new Video(codeInt, title, ((int)loanFee))); //Adding Video Holding
						
						if(addVideoHolding)
							JOptionPane.showMessageDialog(this.tb.getMainFrame(), "New holding has been added to the Collection", 
															"Success!", JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(this.tb.getMainFrame(), "Unable to add the new holding to the Collection\nHolding code already exists", 
															"Failed", JOptionPane.ERROR_MESSAGE);
					}
					catch(NullPointerException  e){ //Catches JOptionPane.CANCEL_OPTION
						break;
					}
				}
			}
			tb.getMainFrame().getMainContentPane().updateCells(); //Updating mainContent View
			tb.getMainFrame().getStatusBar().updateStatusBar(); //Updating StatusBar View
			}
		else{
			JOptionPane.showMessageDialog(this.tb.getMainFrame(), "Please create a collection before attempting to add holdings", 
														"No Collection", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
