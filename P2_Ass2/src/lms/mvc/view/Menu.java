package lms.mvc.view;

import java.awt.event.*;

import javax.swing.*;

import lms.mvc.controller.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 */
//JMenuBar
@SuppressWarnings("serial")
public class Menu extends JMenuBar {

	private JMenu libMenu = new JMenu("LMS");
	private JMenu bookMenu = new JMenu("Book Holding");
	private JMenu videoMenu = new JMenu("Video Holding");	
	private JMenuItem addColl, exit, bookAdd, bookRemove, videoAdd, videoRemove;
	private AppMainFrame mainFrame; //Link to model

	public Menu(AppMainFrame mainFrame){
		
		super();
		this.mainFrame = mainFrame;
		
		libMenu.setMnemonic('L');
		bookMenu.setMnemonic('B');
		videoMenu.setMnemonic('V');
		
		add(libMenu);
		add(bookMenu);
		add(videoMenu);

		
		libMenu.add(this.addColl = new JMenuItem("Add New Collection", 'A'));
		libMenu.addSeparator();
		libMenu.add(this.exit = new JMenuItem("Exit", 'E'));
		
		addColl.setIcon(new ImageIcon("icon-images/menu-plus.png"));
		
		bookMenu.add(this.bookAdd = new JMenuItem("Add New Book", 'A'));
		bookMenu.add(this.bookRemove = new JMenuItem("Remove Book from Collection", 'R'));
		
		bookAdd.setIcon(new ImageIcon("icon-images/menu-plus.png"));
		bookRemove.setIcon(new ImageIcon("icon-images/menu-minus.png"));
		
		videoMenu.add(this.videoAdd = new JMenuItem("Add New Video", 'A'));
		videoMenu.add(this.videoRemove = new JMenuItem("Remove Video from Collection", 'R'));
		
		videoAdd.setIcon(new ImageIcon("icon-images/menu-plus.png"));
		videoRemove.setIcon(new ImageIcon("icon-images/menu-minus.png"));
		
		addColl.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		bookAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		videoAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		bookRemove.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		videoRemove.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		
		this.bookAdd.addActionListener(new AddController("b", this.mainFrame.getToolBar()));
		this.videoAdd.addActionListener(new AddController("v", this.mainFrame.getToolBar()));
		this.bookRemove.addActionListener(new RemoveController("b", this.mainFrame.getToolBar()));
		this.videoRemove.addActionListener(new RemoveController("v", this.mainFrame.getToolBar()));
		this.addColl.addActionListener(new AddCollectionController(this.mainFrame.getToolBar()));
		
		this.exit.addActionListener(new ExitController(this.mainFrame));
	
	}
}
