package lms.mvc.controller;

import java.awt.event.*;

import javax.swing.JOptionPane;
import lms.mvc.model.*;
import lms.mvc.view.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
//Functionality to add a new library collection or override an existing one.
public class AddCollectionController implements ActionListener {
	
	private ToolBar tb;
	private String collCode;
	private String collName;
	
	public AddCollectionController(ToolBar tb){
		this.tb = tb; //Link to model
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		//Procedure placed in a for-loop to allow easy break points
		for(int i = 0; i < 1; i++){
			try{
				if(tb.getMainFrame().getModel().getCollection() != null){ //Check for an existing collection
					int confirm = JOptionPane.showConfirmDialog(this.tb.getMainFrame(), "A Collection already exists\nThis system was designed to manage only one collection at a time\nIf you create a new collection the current one and all holdings will be deleted\n\nWould you like to continue?", 
																		"Confirm New Collection", JOptionPane.WARNING_MESSAGE,  JOptionPane.YES_NO_CANCEL_OPTION);	
					if(confirm != JOptionPane.OK_OPTION)
						break;
				}
				collCode = JOptionPane.showInputDialog(this.tb.getMainFrame(), "Enter the Collection Code", 
						"Creating a new Collection", JOptionPane.QUESTION_MESSAGE);
				if(collCode != null){
					collName = JOptionPane.showInputDialog(this.tb.getMainFrame(), "Enter the name of the new Collection", 
															"Creating a new Collection", JOptionPane.QUESTION_MESSAGE);
					if(collName != null){
						tb.getMainFrame().getModel().addCollection(new LibraryCollection(collCode, collName)); //Adding a new Collection
					}
				}
				tb.getMainFrame().getMainContentPane().updateCells(); //Updating mainContent View
				tb.getMainFrame().getStatusBar().updateStatusBar(); //Updating StatusBar View
			}
			catch(NullPointerException npe){ break; }
		}
		
	}

}
