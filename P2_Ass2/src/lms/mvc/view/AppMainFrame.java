package lms.mvc.view;

import java.awt.*;

import javax.swing.*;

import lms.mvc.model.*;
import lms.mvc.controller.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
//Main application window
@SuppressWarnings("serial")
public class AppMainFrame extends JFrame {

	private LMSModel model; //Link to model
	
	private Menu headerMB;
	private ToolBar headerTB;
	private StatusBar footerSB;
	private DTWindow mainContent;
	private ImageIcon frameIcon = new ImageIcon("icon-images/main-frame-icon.png");
	
	public AppMainFrame(){
		
		super();
		this.model = new LMSFacade();
		
		mainContent = new DTWindow(this);
		footerSB = new StatusBar(this);
		headerTB = new ToolBar(this);
		headerMB = new Menu(this);
		setLayout(new BorderLayout());
		setIconImage(frameIcon.getImage());
		add(headerTB, BorderLayout.NORTH);
		add(footerSB, BorderLayout.SOUTH);
		add(mainContent, BorderLayout.CENTER);
		setJMenuBar(headerMB);
		
		setTitle("P2, Assignment 2 - LMS GUI");
		setBounds(100, 100, 800, 600);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //Set because WindowController handles DefaultCloseOperation

		setVisible(true);
		
		this.addWindowListener(new WindowController(this));
		
	}
	
	//Getters that all other views and controllers use to access each other & the model
	public LMSModel getModel(){ 
		return this.model; 
	}
	public DTWindow getMainContentPane(){
		return this.mainContent;
	}
	public StatusBar getStatusBar(){
		return this.footerSB;
	}
	public ToolBar getToolBar(){
		return this.headerTB;
	}
	
}

