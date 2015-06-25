package lms.mvc.controller;

import java.awt.event.*;
import lms.mvc.view.*;

import javax.swing.JOptionPane;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
//Handles the close operation on JFrame (requests confirmation)
public class WindowController extends WindowAdapter {

	private AppMainFrame mainFrame;
	
	public WindowController(AppMainFrame mainFrame){
		super();
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void windowClosing(WindowEvent e){
		
		int close = JOptionPane.showConfirmDialog(this.mainFrame, "Are you sure you want to exit the application?\nAll data will be lost", 
													"Confirm Exit", JOptionPane.WARNING_MESSAGE,  JOptionPane.YES_NO_CANCEL_OPTION);
		if(close == JOptionPane.OK_OPTION){
			System.exit(1);
		}
	}	
}
