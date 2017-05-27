
// GUI-related imports

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Main extends Frame implements ActionListener
{
	
	String command = "";
	int var = 0;
	RandomNumberGenerator RN = new RandomNumberGenerator(0,100,1000);
	LinkedList            LL = new LinkedList();
	int                   position, value;
	String                inputValue;
	Node                  location = new Node();
	String[] description = new String[] {
			" This program will allow you to interact with the linked list by ",
			" Allowing you to add and delete nodes.",
			" The Locate Node will find the node by data and change the color to blue",
			" To change the color back to defualt you must use the Reset Locate Node button",
			};
	
	public static void main(String[] arg )
	{
		Frame frame = new Main();	
			
		frame.setResizable(false);
		frame.setSize(900,500);
		frame.setVisible(true);
	}
	
	public  Main()
	{
		setTitle("Linked List Operations");
		
		// Create Menu Bar
		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		// Create Menu Group Labeled "File"
		Menu UtilitiesMenu = new Menu("Utilities");
		mb.add(UtilitiesMenu);
		
		MenuItem miReset = new MenuItem("Reset Linked List");
		miReset.addActionListener(this);
		UtilitiesMenu.add(miReset);
		
		MenuItem miLNode = new MenuItem("Locate Node");
		miLNode.addActionListener(this);
		UtilitiesMenu.add(miLNode);
		
		MenuItem miRNode = new MenuItem("Reset Locate Node");
		miRNode.addActionListener(this);
		UtilitiesMenu.add(miRNode);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		UtilitiesMenu.add(miAbout);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);;
		UtilitiesMenu.add(miExit);
		
		
	// **** add menu items
		
		Menu AddMenu = new Menu("Add");
		mb.add(AddMenu);

		MenuItem miAddBeg = new MenuItem("Begining");
		miAddBeg.addActionListener(this);
		AddMenu.add(miAddBeg);
		
		MenuItem miAddEnd = new MenuItem("End");
		miAddEnd.addActionListener(this);
		AddMenu.add(miAddEnd);
		
		MenuItem miAddN = new MenuItem("After N Node");
		miAddN.addActionListener(this);
		AddMenu.add(miAddN);
		
		
	// **** add menu items
		
		Menu DeleteMenu = new Menu("Delete");
		mb.add(DeleteMenu);
		
		MenuItem miDFN = new MenuItem("Delete First Node");
		miDFN.addActionListener(this);
		DeleteMenu.add(miDFN);
		
		MenuItem miDLN = new MenuItem("Delete Last Node");
		miDLN.addActionListener(this);
		DeleteMenu.add(miDLN);
		
		MenuItem miDBD = new MenuItem("Delete by Data");
		miDBD.addActionListener(this);
		DeleteMenu.add(miDBD);
		
		MenuItem miDBP = new MenuItem("Delete by Position");
		miDBP.addActionListener(this);
		DeleteMenu.add(miDBP);
		

		Menu StackMenu = new Menu("Stack Operations");
		mb.add(StackMenu);
		
		MenuItem miPush = new MenuItem("Push");
		miPush.addActionListener(this);
		StackMenu.add(miPush);
		
		MenuItem miPop = new MenuItem("Pop");
		miPop.addActionListener(this);
		StackMenu.add(miPop);
		
		Menu QueueMenu = new Menu("Queue Operations");
		mb.add(QueueMenu);
		
		MenuItem miQueue = new MenuItem("Queue");
		miQueue.addActionListener(this);
		QueueMenu.add(miQueue);
		
		MenuItem miDequeue = new MenuItem("Dequeue");
		miDequeue.addActionListener(this);
		QueueMenu.add(miDequeue);

		
		
	// **** add menu items
				
		WindowListener l = new WindowAdapter()
		{
						
			public void windowClosing(WindowEvent ev)
			{
				System.exit(0);
			}
			
			public void windowActivated(WindowEvent ev)
			{
				repaint();
			}
			
			public void windowStateChanged(WindowEvent ev)
			{
				repaint();
			}
		
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
		};
		
		// register listeners
			
		this.addWindowListener(l);
		this.addComponentListener(k);

	}
	
//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

	public void actionPerformed (ActionEvent ev)
		{
			// figure out which command was issued
			
			command = ev.getActionCommand();
			
			// take action accordingly
						
			if("Begining".equals(command))
			{
				LL.AddToBegining(RN.getRandomNumber());
				repaint();		
			}
			else
				
			if("End".equals(command))
			{
				LL.AddToEnd(RN.getRandomNumber());
				repaint();		
			}
			else
				
			if("After N Node".equals(command))
			{
				LL.AddAfterNthNode(RN.getRandomNumber());
				repaint();		
			}
			else
				if("Delete First Node".equals(command))
				{
					LL.DeleteFromBegining();
					repaint();		
				}
				else
			if("Delete Last Node".equals(command))
			{
				LL.DeleteFromEnd();
				repaint();		
			}
			else

			if("Delete by Data".equals(command))
			{
				LL.DeleteSpecificNode();
				repaint();		
			}
			
			if("Delete by Position".equals(command))
			{
				LL.DeleteByPosition();
				repaint();			
			}
		
			if("Push".equals(command))
			{
				LL.AddToBegining(RN.getRandomNumber());
				repaint();		
			}
			if("Pop".equals(command))
			{
				LL.DeleteFromEnd();
				repaint();		
			}
			if("Queue".equals(command))
			{
				LL.AddToEnd(RN.getRandomNumber());
				repaint();		
			}
			if("Dequeue".equals(command))
			{
				LL.DeleteFromBegining();
				repaint();		
			}
			if("Reset Linked List".equals(command))
			{
			//	count = 0;
				LL.ResetLinkedList();
				repaint();		
			}
			if("Locate Node".equals(command))
			{
				LL.LocateNode();
				repaint();		
			}
			if("Reset Locate Node".equals(command))
			{
				LL.data = 0;
				repaint();		
			}

			if("About".equals(command))
			{
				
				repaint();		
			}

			
			//*** add all other options

			else
				if("Exit".equals(command))
				{
							
					System.exit(0);
				}
		}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
		
		public void paint(Graphics g )
		{
			
			if ("About".equals(command))
		{
			int x = 0;
			int y =0;
			for (int i=0; i<4; i++)
			{
				g.drawString(description[i],x+220,y+140);
				y=y+25;
			}
		}
			
			int count = 0;
			Graphics2D g2 = (Graphics2D) g;
			if (LL.head == null)
			{
				g.drawString(" Empty List", 400, 250);
				return;
			}
			else
			{
				int xs = 100;
				int ys = 100;
				Node t= LL.head;
				
				
				g.drawString("Head", xs-50, ys);
				g.drawLine(xs-15, ys-5, xs+5, ys-5);
				
				
				
				while (t != null)
				{
					var=t.data;
					
					if (var == LL.data)
					{
						g.setColor(Color.BLUE);
					}
				
					if(count != 0 && count % 8 == 0)
				{
					ys += 60;
					xs=100;
				}
						
					
					g2.draw(new Rectangle2D.Double(xs+15, ys-18, 45, 25));
					g.drawString(""+t.data,xs+25,ys);
					g.drawLine(xs-10, ys-5, xs+10, ys-5);
					g.drawLine(xs+10, ys-5, xs, ys+5);
					g.drawLine(xs+10, ys-5, xs, ys-15);
					
					xs = xs + 75;
					
					g.setColor(Color.BLACK);
					
			//**** display the rectangle and node content


			//**** check if the right end of window is reached, move to next line
					t = t.next;
					count++;
				}
				
				g.drawString("End Of List", xs+5, ys);
			}
			}
			
		}
