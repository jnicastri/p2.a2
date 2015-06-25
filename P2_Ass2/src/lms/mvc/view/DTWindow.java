package lms.mvc.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import lms.mvc.model.Holding;
import lms.mvc.view.Cell;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
//mainContent Window - where the holdings in the collection are graphically represented in cells
@SuppressWarnings("serial")
public class DTWindow extends JPanel {

	private AppMainFrame mainFrame; //Link to model
	private JPanel innerPanel = new JPanel();
	
	public DTWindow(AppMainFrame mainFrame){
		
		super();
		this.mainFrame = mainFrame;
		
		if(this.mainFrame.getModel().getCollection() != null)
			updateCells();		
	}
	
	//Update method - called on initialization & by controllers when any change to the holdings in the model has occurred
	public void updateCells(){ 

		this.innerPanel.removeAll();

		this.setLayout(new GridLayout(1, 1));
		Holding [] holdings = mainFrame.getModel().getAllHoldings();
		
		LayoutManager layOut = null;
		
		//Determines cell layout - max 4 columns, all evenly sized cells, utilize space most efficiently (as per spec requirement)
		if(holdings != null){
			if(holdings.length <= 4){
				layOut = new GridLayout(1, holdings.length, 2, 2);
			}
			else{
				if(holdings.length % 4 == 0){
					layOut = new GridLayout((holdings.length / 4), 4, 2, 2);
				}
				else{
					layOut = new GridLayout((holdings.length / 4 + 1), 4, 2, 2);
				}
			}
		}
		else
			layOut = new GridLayout();
				
		innerPanel.setLayout(layOut);
		innerPanel.setBackground(Color.WHITE);
		Border border = new LineBorder(Color.BLACK, 1);
		innerPanel.setBorder(border);

		if(holdings != null){
			for(Holding h: holdings){
				innerPanel.add(new JScrollPane(new Cell(this, h), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
									JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
			}	
		}
		this.add(innerPanel);
		
		this.validate();
	}
	public AppMainFrame getMainFrame(){
		return this.mainFrame;
	}

}
