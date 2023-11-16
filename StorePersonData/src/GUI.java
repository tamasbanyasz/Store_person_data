import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class GUI  implements ActionListener {
	
	/* 
	 * 
	 * @author      Tamas Banyasz
	 * @version 	1.0
	 * @since   	2023-11-16
	 * 
	 * The program implements that
	 * simply how to store data from people 
	 * through a graphical interface.
	 * 
	 * 
	 * The applied GUI is the Java SWING window toolkit.
	 * 
	 * On the window there is two input field where we can add the "Name" and the "Age".
	 * The "Age" value will be storing in string format because the "Table" view.
	 * 
	 * There is a "Tab" field on the window and we can select between two display.
	 * One is the "Main" tab and the other is the "Table" tab.
	 * The "Main" tab is contains a simple "TextArea" field. 
	 * The "Table" tab  is contains a simple  "Table" field.
	 * 
	 * 
	 * If we added the two value, these will be appearing on the "TextArea" and on the "Table" field.
	 * 
	 * There is a "MenuBar" with a "Menu" icon. But it doesn't do nothing yet.
	 * The input process doesn't handled yet.
	 * 
	 */
	
	private JFrame frame = new JFrame(); // Main window
	
	// Class of the input fields 
	private JTextField textField1 = new JTextField("Name");  
	private JTextField textField2 = new JTextField("Age");
	
	// Class of the "Click" button.
	private JButton button = new JButton("Click");
	
	// Class of the "TextArea"
	private JTextArea TextArea = new JTextArea(10, 40);
	
	// Class of the "TabbedPane"
	private JTabbedPane tabbedPane = new JTabbedPane();  
	
	// Two input in "String" format
	private String obtainedName;
	private String obtainedAge;
	
	// Simple list where we can store the input values
	private List<Person> persons = new ArrayList<>();
	
	// "Table" heads
	private String column[] = {"Name", "Age"};
	
	// Table model
	private DefaultTableModel model = new DefaultTableModel(column, 0);

	public GUI() {
	 
	frame.setSize(800, 600);
	
	// Class of the "Table"
	JTable jtable = new JTable(model);
	jtable.setPreferredScrollableViewportSize(new Dimension(450, 125));
	jtable.setFillsViewportHeight(true);
	
	// Two panel where the "Tabs"
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	TextArea.setEditable(false);
	
	tabbedPane.setBounds(205, 30, 480, 200);  
	
	// Here added the "TextArea" to the Panel'
	panel1.add(TextArea);
	
	// Added the scroll bar to the "TextArea"
	JScrollPane TextAreaScrollBar = new JScrollPane(TextArea); 
	TextAreaScrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	panel1.add(TextAreaScrollBar);
	
	// Added the scroll bar to the "Table"
	JScrollPane TableScrollBar = new JScrollPane(jtable);
	TableScrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	TableScrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	panel2.add(TableScrollBar);
	
	// Added the panels to the +TabbedPane"
	tabbedPane.add("Main", panel1);
	tabbedPane.add("Table", panel2);
	frame.add(tabbedPane);
	
	
	button.setBounds(360,320,100, 40);
	frame.add(button);
	button.addActionListener(this);  // Button action class
	  
    textField1.setBounds(320,240, 200,30);  
    frame.add(textField1);
    
    textField2.setBounds(320,280, 200,30);  
	frame.add(textField2);
	
	JMenuBar menuBar=new JMenuBar(); // The "MenuBar" with the icon
	frame.setJMenuBar(menuBar);
	
	JMenu menu=new JMenu("Menu");
	menuBar.add(menu); 
	
	JLabel label = new JLabel("Workers");  
	label.setBounds(400, 6, 100,30); 
	frame.add(label);
	

	frame.setLayout(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	}
	
	// Action method when we pressed the "Click" button with the correct inputs:
	public void actionPerformed(ActionEvent e) {  
		
		 if(e.getSource()==button){
			 obtainedName = textField1.getText();  // Get the inputs
			 obtainedAge = textField2.getText();  
		  
		        
		     System.out.println(obtainedName); 
		     System.out.println(obtainedAge);  
		        
		     Person personClass = new Person(obtainedAge, obtainedName); // Create a "Person" class with the obtained values
		        
		     persons.add(personClass); // Add the person to the list
		     System.out.println(persons);
		        
		     TextArea.setText(""); // Clear the "TextArea" after we clicked the "Click" button 
		     for(Person person : persons) {
		    	 TextArea.append("Name: " + person.getName() + "  Age:" + person.getAge() + "\n");	// Show the added persons on the "TextArea" field
		     }
		    
		     model.setRowCount(0); // Refresh the "Table" after we clicked the "Click" button 
		     for(Person person : persons) {
		    		
		    	 String [] personDatas = {person.getName(), person.getAge()}; // Firstly we store the values in a simple list...
		    		
		    	 model.addRow(personDatas);	// ... then we added the simple list to the "Table"		    		
		     }     
		 } 
    }  	
}
