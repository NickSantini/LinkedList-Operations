import javax.swing.JOptionPane;

 

public class LinkedList 
{
	RandomNumberGenerator RN = new RandomNumberGenerator(0,100,1000);
    Node head = null;
    Node tail = null;
    long  length;
    int data;
    
    public LinkedList()
    {
        head = null; 
        tail = null;
        length = 0;
        
    }
    
    public void ResetLinkedList()
    {
    	head=null;
    	tail=null;
    	length = 0;
    }
    
    public void AddToBegining(int number)
    {
    	
    	  Node temp = new Node();
    	  temp.data = number;
    	 
    	  if(head == null)
    	  {
    	    head=temp;
    	    tail=temp;
    	    length++;
    	   
    	    System.out.println("if statement");
    	  }
    	  else
    	  {
    	    temp.next = head;
    	    head = temp;
    	    System.out.println("else");
    	    length++;
    	  }

        
    }
    public void AddToEnd(int number)
    {
    	Node temp = new Node();
    	Node t = new Node();
    	t.data=number;
    	temp = head;
    	
    if(head==null)
    {
    	head=t;
    	tail=t;
    	length++;
    	
    }
    else
    	
    	if(head!=null)
    	{	
    		tail.next = t;
    		tail=t;
    		length++;
    	}
   /* 		
    	while(temp.next !=null)
    	
    	{
    		temp = temp.next;
    		System.out.println("while loopy");
    
    	}
    	temp.next = t;
    	}
       */
    }
    public void AddAfterNthNode(int number /*, int position*/)
    {
     String input = JOptionPane.showInputDialog("Please enter the node number that you would like  a new node after");
     Node temp = new Node();
     Node t= new Node();
     Node previous = new Node();
     t.data = number;
     temp = head;
     int counter = 0;
     int position = 0;
     
     
     if(input != null)
     {
    	 position = Integer.parseInt(input);
    	 System.out.println("position = "+position);
     }
     
    if(head==null && input != null)
    {
    	AddToBegining(RN.getRandomNumber());
  /*	
    head=t;
    tail=t;
    length++;
  */
    	
    JOptionPane.showMessageDialog(null,"List was empty, New node added as first Node");
    }
    
    
    else
    	
    	if(head != null)
    	{
    		while(temp.next !=null && counter < position-1 )
    		{
    			temp=temp.next;
    			System.out.println("counter ="+counter);
    			counter ++;
    		}
    		
    		previous = temp.next;
    		temp.next = t;
    		t.next = previous;
    		length++;
    		
    	}
    
    }
    
    public void DeleteFromBegining()
    {
    	if(head==null)
        {
        	JOptionPane.showMessageDialog(null,"The list is empty, Unable to delete node");	
        }
    	
    	if(head !=null)
    	{
    		head = head.next;
    		length --;
    	}
    	
    }

    public void DeleteFromEnd()
    {
    	Node temp = head;
    	Node previous = null;
    	
    	if(head==null)
        {
        	JOptionPane.showMessageDialog(null,"The list is empty, Unable to delete node");	
        }
    	
    	 if(head != null)
    	 {
    		while(temp.next != null)
    		{
    			previous = temp;
    			temp = temp.next;
    			System.out.println("while...");
    			
    		}
    		if(length >= 2)
    		{
    			previous.next = null;
    			tail = previous;
    			length--;
    		}
    		 else
        	 {
        		 head=null;
        		 length=0;
        		 
        	 }
    	 }
    	
      
    }
    
    public void DeleteSpecificNode()
    {
    	
        int Data = 0;
        Node temp = new Node();
        Node previous = new Node();
        temp = head;
      
      String input = JOptionPane.showInputDialog("Please the node you would like to delete (By Data)");
      
      	if(input != null)
      	{
    	 Data = Integer.parseInt(input);
     	 System.out.println("position = "+ Data);
      	}
      
      
      if(head == null && input != null)
      {
    	  JOptionPane.showMessageDialog(null, "The list is empty, Unable to delete node");
    	  
      }
      
      if( head != null)
      {
    	  while(temp != null && temp.data != Data)
    	  {
    		  previous = temp;
    		  temp = temp.next;	  
    	  }
    	  if(previous.next != null)
    	  {
    		  previous.next = temp.next;
    		  length --;
    	  
    	  }
    	  else
    	  {
    		  head=temp.next;
    		  length --;
    	  }
      }
    	      
    }
    
    public void DeleteByPosition()
    {
    	
        Node temp;
        Node previous=null;
        
        temp = head;
        int counter = 1;
        int position = 1;
        
        String input = JOptionPane.showInputDialog("Please enter the node you would like to delete by position 1,2,3...N");
        
        
        if(input != null)
        {
       	 position = Integer.parseInt(input);
       	 System.out.println("position = "+position);
        }
        
       if(head==null && input != null)
       {
       	JOptionPane.showMessageDialog(null,"The List is empty, Nothing to delete");
       }
       
           	
       	if(head != null)
       	{
       		while(temp.next !=null && counter != position )
       		{
       			previous=temp;
       			temp=temp.next;
       			System.out.println("counter ="+counter);
       			counter ++;
       			
       		
       		}
       		if(position == 1)
       		{
       			head=temp.next;
       			length--;
       			
       		}
       		
       			
       		else if(previous.next != null)
       		{
       			previous.next = temp.next;
       			length --;
       			System.out.println("DBP if");
   	  
       		}
       		
       		else
       		{
       			head=temp.next;
       			length --;
       			System.out.println("DBP else");
       		
       		}
       
       }
    }
    
    
    public void LocateNode()
    {
    	
    	String input = JOptionPane.showInputDialog("Enter the data of the node you would like to locate");
    	
    			if(input != null)
    			{
    				data = Integer.parseInt(input);
    			}
    			
    			
    			
    }
   
    
}
