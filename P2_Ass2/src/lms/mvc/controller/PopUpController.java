package lms.mvc.controller;

import java.awt.event.*;

import javax.swing.*;

import lms.mvc.view.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
//Handles right-click on holding pop up menu - removing a holding
public class PopUpController extends MouseAdapter {

	private PopUpMenu popUp;
	private int holding;
	
	public PopUpController(PopUpMenu popUp){
		super();
		this.popUp = popUp; //Link to model
	}
	@Override
	public void mousePressed(MouseEvent e){
		
		holding = this.popUp.getCell().getClickedHolding().getCode();
		
		int confirm = JOptionPane.showConfirmDialog(this.popUp.getCell().getMainContent().getMainFrame(), 
													"Removing Holding....\nAre you sure?", 
				"Confirm Remove Holding", JOptionPane.YES_NO_OPTION);

		if(confirm == JOptionPane.YES_OPTION){
			if(this.popUp.getCell().getMainContent().getMainFrame().getModel().removeHolding(holding)){ //Removing Holding
				popUp.getCell().getMainContent().updateCells(); //Updating mainContent View
				popUp.getCell().getMainContent().getMainFrame().getStatusBar().updateStatusBar(); //Updating StatusBar View
				JOptionPane.showMessageDialog(this.popUp.getCell().getMainContent().getMainFrame(), "Holding successfully removed", "Success!", 
												JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(this.popUp.getCell().getMainContent().getMainFrame(),
											"An error has occured\nThe holding was not removed\nPlease try again", "Failed", JOptionPane.OK_OPTION);
			}
		}
	}
}
