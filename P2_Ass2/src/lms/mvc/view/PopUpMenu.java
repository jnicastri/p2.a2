package lms.mvc.view;

import java.awt.Color;
import javax.swing.*;
import lms.mvc.controller.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
@SuppressWarnings("serial")
public class PopUpMenu extends JPopupMenu {

	private JMenuItem menuItem = new JMenuItem("Remove Holding");
	private Cell cell;
	
	public PopUpMenu(Cell cell){
		super();
		this.cell = cell; //link to model
		
		menuItem.setBackground(Color.WHITE);
		
		this.add(menuItem);
		
		menuItem.addMouseListener(new PopUpController(this));
	}
	public Cell getCell(){
		return this.cell;
	}
	
}
