package lms.mvc.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import lms.mvc.model.Holding;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
@SuppressWarnings("serial")
public class StatusBar extends JPanel {

	private JLabel barString = new JLabel("Please Add a New Collection");
	private AppMainFrame mainFrame; //Link to model
	
	
	public StatusBar(AppMainFrame mainFrame){
		
		super();
		this.mainFrame = mainFrame;
		
		Border border = new LineBorder(Color.BLACK, 1);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBorder(border);
		
		if(this.mainFrame.getModel().getCollection() != null)
			updateStatusBar();
		
		add(barString);
	}
	
	public void updateStatusBar(){ //Update method - called on initialization & by controllers when any change to the holdings in the model has occurred
		
		Holding holdings []= mainFrame.getModel().getAllHoldings();
		
		int videos = 0;
		int books = 0;
		String collString = this.mainFrame.getModel().getCollection().toString();
		int divide = collString.indexOf(":", 0);
		String collCode = collString.substring(0, divide);
		
		if(holdings != null){
			for(Holding h: holdings){
				if(h instanceof lms.mvc.model.Book)
					books++;
				else
					videos++;
			}
		}
		barString.setText("Collection:[" + collCode + "] Books:[" + books + "] Videos:[" + videos + "]");
	}
	
}
