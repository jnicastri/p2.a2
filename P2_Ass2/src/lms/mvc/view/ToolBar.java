package lms.mvc.view;

import java.awt.*;

import javax.swing.*;

import lms.mvc.controller.*;
/**
 * 
 * @author James Nicastri
 * Student# s3407908
 * SP2, 2013, Programming 2, Assignment 2
 *
 * ICONS:
 * All 5 Icons used in this view were sourced from http://www.iconarchive.com/.
 * Their usage permissions are "Free for non-commercial use".
 * They remain the property of the original author(s).
 */
@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
	
	private AppMainFrame mainFrame; //Link to model
	
	private ImageIcon addCollTile = new ImageIcon("icon-images/collection-mini-tile.png");
	private ImageIcon pBook = new ImageIcon("icon-images/add-book-mini-tile.png");
	private ImageIcon mBook = new ImageIcon("icon-images/drop-book-mini-tile.png");
	private ImageIcon pVideo = new ImageIcon("icon-images/add-video-mini-tile.png");
	private ImageIcon mVideo = new ImageIcon("icon-images/drop-video-mini-tile.png");
	
	private JButton addCollBtn = new JButton(addCollTile);
	private JButton addBookBtn = new JButton(pBook);
	private JButton removeBookBtn = new JButton(mBook);
	private JButton addVideoBtn = new JButton(pVideo);
	private JButton removeVideoBtn = new JButton(mVideo);	
	
	public ToolBar(AppMainFrame mainFrame){
		
		super();
		this.mainFrame = mainFrame;
		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		addCollBtn.setToolTipText("<html>Add a new Collection.<br />WARNING: Adding a new collection will erase the<br />existing collection and all holdings</html>");
		addBookBtn.setToolTipText("Add a Book Holding to the current Collection");
		removeBookBtn.setToolTipText("Remove a Book Holding from the current Collection");
		addVideoBtn.setToolTipText("Add a Video Holding to the current Collection");
		removeVideoBtn.setToolTipText("Remove a Video Holding from the current Collection");
		
		panel.add(addCollBtn);
		panel.add(addBookBtn);
		panel.add(removeBookBtn);
		panel.add(addVideoBtn);
		panel.add(removeVideoBtn);
		
		//Listeners
		addBookBtn.addActionListener(new AddController("b", this));
		addVideoBtn.addActionListener(new AddController("v", this));
		removeBookBtn.addActionListener(new RemoveController("b", this));
		removeVideoBtn.addActionListener(new RemoveController("v", this));
		addCollBtn.addActionListener(new AddCollectionController(this));
		
		this.add(panel);
	}
	public AppMainFrame getMainFrame(){ return this.mainFrame; }
	
}
