
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;



public class GUI extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Player testPlayer;
	RoomGenerator createDungeon = new RoomGenerator();
	
	private JTextArea outputMUD; 
	private JPanel textMap;
	private JScrollPane scroller;
	private JPanel buttonMap;
	private JButton buttonNorth;
	private JButton buttonWest;
	private JButton buttonSouth;
	private JButton buttonEast;
	
    static byte gridLayout[][]  =  {{1,0,0}, 
  									{1,0,0}, 
  									{1,1,1}};

    Room dungeon[][] = new Room [3][3];


	
	public GUI()
	{
		
		testPlayer = new Player();
		setLayout(new GridLayout(2,2));
		setTitle("MUD");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		createDungeon.populateDungeon(gridLayout, dungeon);
		buildTextPanel();
		buildButtonMap();
		this.add(textMap);
		
		this.add(buttonMap);
		
		dungeon[0][0].describeRoom("You are in a slimy, dimly lit stone room. There are no furnishings or trinkets to be found that suggest comfort.");
		dungeon[1][0].describeRoom("You squeeze through a narrow crack in the wall to find what was once most certainly a home for goblins. "
								+ "\nBones litter the ground around a smoking campfire.");
		
		checkButtons();
		setVisible(true);
		outputMUD.append("\n" + dungeon[testPlayer.location.row][testPlayer.location.column].roomDescription());
	}
	public void buildTextPanel()
	{
		textMap = new JPanel();
		textMap.setLayout(new GridLayout(1,2));
		outputMUD = new JTextArea();
		DefaultCaret caret = (DefaultCaret)outputMUD.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		outputMUD.setText("Welcome to the Dungeon.");
		outputMUD.setEditable(false);
		outputMUD.setSize(new Dimension(800,300));
		outputMUD.setLineWrap(true);
		scroller = new JScrollPane(outputMUD);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		textMap.add(scroller);
	}
	
	public void buildButtonMap()
	{
		buttonMap = new JPanel();
		buttonNorth = new JButton("North");
		buttonWest = new JButton("West  ");
		buttonSouth = new JButton("South");
		buttonEast = new JButton("East  ");
		
		buttonNorth.addActionListener(new MovementButtonListener());
		buttonWest.addActionListener(new MovementButtonListener());
		buttonSouth.addActionListener(new MovementButtonListener());
		buttonEast.addActionListener(new MovementButtonListener());
		
		buttonMap.add(buttonNorth);
		buttonMap.add(buttonWest);
		buttonMap.add(buttonSouth);
		buttonMap.add(buttonEast);
		 
	}
	private void checkButtons()
	{
		if(!(createDungeon.lookNorth(testPlayer, dungeon)))
		{
			buttonNorth.setEnabled(false);
		}
		else
			buttonNorth.setEnabled(true);
		if(!(createDungeon.lookWest(testPlayer, dungeon)))
		{
			buttonWest.setEnabled(false);
		}
		else
			buttonWest.setEnabled(true);
		if(!(createDungeon.lookSouth(testPlayer, dungeon)))
		{
			buttonSouth.setEnabled(false);
		}
		else
			buttonSouth.setEnabled(true);
		if(!(createDungeon.lookEast(testPlayer, dungeon)))
		{
			buttonEast.setEnabled(false);
		}
		else
			buttonEast.setEnabled(true);
	}
	
	
	private class MovementButtonListener implements ActionListener
	{
	
		public void actionPerformed(ActionEvent E)
		{
			
			if(E.getSource() == buttonNorth)
			{
				testPlayer.location.row -= 1;
				checkButtons();
				dungeon[testPlayer.location.row][testPlayer.location.column].enterRoom();
				outputMUD.append("\nMoved North");
				outputMUD.append("\n" + dungeon[testPlayer.location.row][testPlayer.location.column].roomDescription());
				
			}
			if(E.getSource() == buttonWest)
			{
				testPlayer.location.column -= 1;
				checkButtons();
				dungeon[testPlayer.location.row][testPlayer.location.column].enterRoom();
				outputMUD.append("\nMoved West.");
				outputMUD.append("\n" + dungeon[testPlayer.location.row][testPlayer.location.column].roomDescription());
			}
			if(E.getSource() == buttonSouth)
			{
				testPlayer.location.row += 1;
				checkButtons();
				dungeon[testPlayer.location.row][testPlayer.location.column].enterRoom();
				outputMUD.append("\nMoved South.");
				outputMUD.append("\n" + dungeon[testPlayer.location.row][testPlayer.location.column].roomDescription());
			}
			if(E.getSource() == buttonEast)
			{
				testPlayer.location.column += 1;
				checkButtons();
				dungeon[testPlayer.location.row][testPlayer.location.column].enterRoom();
				outputMUD.append("\nMoved East.");
				outputMUD.append("\n" + dungeon[testPlayer.location.row][testPlayer.location.column].roomDescription());
			}
			
			
			
			
			/*
			player at (position,position)
			if room is available around player coordinates
			move to room based on button pressed
			call that rooms enter procedure
			update buttons
			
			*/
		}
		
		
	}
	
	public static void main(String[] args)
	{
		GUI gameFace = new GUI();
		
		
		
	}
}
