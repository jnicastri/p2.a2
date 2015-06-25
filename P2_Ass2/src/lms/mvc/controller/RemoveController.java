package lms.mvc.controller;

import java.awt.event.*;

import lms.mvc.model.Holding;
import lms.mvc.view.*;

import java.util.*;

import javax.swing.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
//Handles all removing except through the "Pop-Up" option 
public class RemoveController implements ActionListener {

	private String type;
	private ToolBar tb;
	
	public RemoveController(String type, ToolBar tb){
		this.type = type;
		this.tb = tb; //Link to model
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.tb.getMainFrame().getModel().getCollection() != null){
			for(int i = 0; i < 1; i++){ //Code placed in a loop to allow easy break points
				List<Holding> listHoldingsList = new ArrayList<Holding>();
				List<String> stringList = new ArrayList<String>();
				
				if(tb.getMainFrame().getModel().getAllHoldings() != null){
				
					Holding[] allHoldings = tb.getMainFrame().getModel().getAllHoldings();
					
					try{
						if(type.equals("b")){
							for(Holding h: allHoldings){
								if(h instanceof lms.mvc.model.Book)
									listHoldingsList.add(h);
							}
							if(listHoldingsList.isEmpty()){
								JOptionPane.showMessageDialog(this.tb.getMainFrame(), "There are currently no Book Holdings", 
																"No Book Holdings Found", JOptionPane.OK_OPTION);
								break;
							}
						}
						else{
							for(Holding h: allHoldings){
								if(h instanceof lms.mvc.model.Video)
									listHoldingsList.add(h);
							}
							if(listHoldingsList.isEmpty()){
								JOptionPane.showMessageDialog(this.tb.getMainFrame(), "There are currently no Video Holdings", 
																"No Video Holdings Found", JOptionPane.OK_OPTION);
								break;
							}
						}

						String currentHolding = "";
						for(Holding h: listHoldingsList){
							currentHolding = h.getCode() + ", " + h.getTitle();
							stringList.add(currentHolding);
						}
						
						Object[] listHoldingsArray = stringList.toArray(); //JOptionPane ScrollList takes generic Object Array only
						
						Object selectedItem = JOptionPane.showInputDialog(this.tb.getMainFrame(), "Please select a holding to remove from the collection", 
																	"Remove a Holding", JOptionPane.QUESTION_MESSAGE, null, listHoldingsArray, null);

						int divide = ((String)selectedItem).indexOf(',', 0)	;
						String codeString = ((String)selectedItem).substring(0, divide);	
						int selectedItemCode = Integer.parseInt(codeString);
						
						int confirm = JOptionPane.showConfirmDialog(this.tb.getMainFrame(), "Removing Holding....\nAre you sure?", 
																	"Confirm Remove Holding", JOptionPane.YES_NO_OPTION);
						
						if(confirm == JOptionPane.YES_OPTION){

							tb.getMainFrame().getModel().removeHolding(selectedItemCode);
							tb.getMainFrame().getMainContentPane().updateCells();
							tb.getMainFrame().getStatusBar().updateStatusBar();
						}
					}
					catch(NullPointerException npe){ //Catching JOptionPane.CANCEL_OPTION
						break;
					}
				}
				else{
					String typeName = "Book";
					if(this.type.equals("v"))
						typeName = "Video";
		
					JOptionPane.showMessageDialog(this.tb.getMainFrame(), "There are currently no " + typeName + " Holdings", "No " + typeName + 
													" Holdings Found", JOptionPane.OK_OPTION);
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(this.tb.getMainFrame(), "There are currently no holdings because there is no collection", 
					"No Collection", JOptionPane.OK_OPTION);
		}
	}
}
