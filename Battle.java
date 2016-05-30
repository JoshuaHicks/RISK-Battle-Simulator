import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Random;
import java.util.Arrays;

import java.io.*;

public class Battle extends JFrame implements ActionListener
{
	//Instance Variables
	private JRadioButton atk1Radio;
	private JRadioButton atk2Radio;
	private JRadioButton atk3Radio;
	private JRadioButton def1Radio;
	private JRadioButton def2Radio;
	
	private JButton btnBattle;
	
	private JLabel display;
	private JLabel atkLabel;
	private JLabel defLabel;
	private JLabel result;
	
	private Integer[] atkDice = {1, 2, 3};
	private Integer[] defDice = {1, 2};

	private Random rand = new Random();
	
	private int atk, def;
	
	//------------------------------------------------
	// Constructor
	//------------------------------------------------
	public Battle() {
		//Creating the Container and Panels
		Container pane = this.getContentPane();
		JPanel mid = new JPanel();
		JPanel bottom = new JPanel();
		
		
		//setting the layouts
		pane.setLayout(new BorderLayout() );
		mid.setLayout(new GridLayout(4, 2) );
		bottom.setLayout(new GridLayout(2,1) );
		
		//Creating the button
		btnBattle = new JButton("Battle!");
		
		//Adding action listener for the button
		btnBattle.addActionListener(this);
		
		//Creating the labels
		display = new JLabel("Risk Battle Simulator");
		atkLabel = new JLabel("Attacking");
		defLabel = new JLabel("Defending");
		result =  new JLabel("The result is: ");
		
		//Creating the RadioButtons
		atk1Radio = new JRadioButton("1 Dice");
		atk2Radio = new JRadioButton("2 Dice");
		atk3Radio = new JRadioButton("3 Dice");
		def1Radio = new JRadioButton("1 Dice");
		def2Radio = new JRadioButton("2 Dice");
		
		//Setting first two Radio Buttons to true
		atk1Radio.setSelected(true);
		def1Radio.setSelected(true);
		
		//Grouping the radio buttons
		ButtonGroup atkGroup = new ButtonGroup();
		atkGroup.add(atk1Radio);
		atkGroup.add(atk2Radio);
		atkGroup.add(atk3Radio);
		
		ButtonGroup defGroup = new ButtonGroup();
		defGroup.add(def1Radio);
		defGroup.add(def2Radio);
		
		//Adding everything to the Pane/Panels
		pane.add(display, BorderLayout.NORTH);
		pane.add(mid, BorderLayout.CENTER);
		pane.add(bottom, BorderLayout.SOUTH);
		
		mid.add(atkLabel);
		mid.add(defLabel);
		mid.add(atk1Radio);
		mid.add(def1Radio);
		mid.add(atk2Radio);
		mid.add(def2Radio);
		mid.add(atk3Radio);

		mid.add(btnBattle);
		bottom.add(btnBattle);
		bottom.add(result);
		
	}

	//------------------------------------------------
	// Main method for Battle.java
	//------------------------------------------------
	public static void main(String[] args)
	{
		Battle frame = new Battle();
		frame.setTitle("Risk Battle Simulator");
		frame.setSize(450,250);  
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//end main();
	
	//------------------------------------------------
	// Action Performed method for the buttons
	//------------------------------------------------
	public void actionPerformed(ActionEvent e) {
		//Creating an object called input for each action that is performed
		Object input = e.getSource();
		
		if (input == btnBattle) {
			//Figuring out which radio button is selected
			if (atk1Radio.isSelected() ) 
				atk = 1;
			else if (atk2Radio.isSelected() )
				atk = 2;
			else if (atk3Radio.isSelected() )
				atk = 3;
				
			if (def1Radio.isSelected() )
				def = 1;
			else if (def2Radio.isSelected() )
				def = 2;
			
			System.out.println("The dice rolls are:");
			
			//Scenario 1: 3 attacking, 2 defending
			if (atk == 3 && def == 2) {
				//Getting the random attacking dice rolls
				int randAtk1 = rand.nextInt(6) + 1;
				int randAtk2 = rand.nextInt(6) + 1;
				int randAtk3 = rand.nextInt(6) + 1;
			
				//Getting the random defending dice rolls
				int randDef1 = rand.nextInt(6) + 1;
				int randDef2 = rand.nextInt(6) + 1;
			
				//Getting all the attacking numbers and then sorts them in ascending order
				int[] attacks = {randAtk1, randAtk2, randAtk3};
				sortDesc(attacks);
				System.out.println("Attacking: " + Arrays.toString(attacks) );
				
				//Getting all the defending numbers and then sorting them in ascending order
				int[] defence = {randDef1, randDef2};
				sortDesc(defence);
				System.out.println("Defending: " + Arrays.toString(defence) );
				
				//Determining the result and printing it to the result label
				if (attacks[0] > defence[0] && attacks[1] > defence[1])
					result.setText("The result is: The defenders lost 2 troops in war.");
				else if (attacks[0] <= defence[0] && attacks[1] <= defence[1])
					result.setText("The result is: The attackers lost 2 troops in war.");
				else if (attacks[0] > defence[0] && attacks[1] <= defence[1])
					result.setText("The result is: The attackers and defenders both lost 1 troop in war.");
				else if (attacks[0] <= defence[0] && attacks[1] > defence[1])
					result.setText("The result is: The attackers and defenders both lost 1 troop in war.");

			}	 
			//Scenario 2: 3 attacking, 1 defending
			else if (atk == 3 && def == 1) {
				//Getting the random attacking dice rolls
				int randAtk1 = rand.nextInt(6) + 1;
				int randAtk2 = rand.nextInt(6) + 1;
				int randAtk3 = rand.nextInt(6) + 1;
				
				//Getting the random defending dice rolls
				int randDef1 = rand.nextInt(6) + 1;
				
				//Getting all the attacking numbers and then sorts them in ascending order
				int[] attacks = {randAtk1, randAtk2, randAtk3};
				sortDesc(attacks);
				System.out.println("Attacking: " + Arrays.toString(attacks) );
				
				//Printing out the defence roll
				System.out.println("Defending: [" + randDef1 + "]");
				
				//Determining the result and printing it to the result label
				if (attacks[0] > randDef1)
					result.setText("The result is: The defenders lost 1 troop in war.");
				else if (attacks[0] <= randDef1)
					result.setText("The result is: The attackers lost 1 troop in war.");
		
			} 
			//Scenario 3: 2 attacking, 2 defending
			else if (atk == 2 && def == 2) {
				//Getting the random attacking dice rolls
				int randAtk1 = rand.nextInt(6) + 1;
				int randAtk2 = rand.nextInt(6) + 1;
				
				//Getting the random defending dice rolls
				int randDef1 = rand.nextInt(6) + 1;
				int randDef2 = rand.nextInt(6) + 1;
				
				//Getting all the attacking numbers and then sorts them in ascending order
				int[] attacks = {randAtk1, randAtk2};
				sortDesc(attacks);
				System.out.println("Attacking: " + Arrays.toString(attacks) );
			
				//Getting all the defending numbers and then sorting them in ascending order
				int[] defence = {randDef1, randDef2};
				sortDesc(defence);
				System.out.println("Defending: " + Arrays.toString(defence) );
				
				//Determining the result and printing it to the result label
				if (attacks[0] > defence[0] && attacks[1] > defence[1])
					result.setText("The result is: The defenders lost 2 troops in war.");
				else if (attacks[0] <= defence[0] && attacks[1] <= defence[1])
					result.setText("The result is: The attackers lost 2 troops in war.");
				else if (attacks[0] > defence[0] && attacks[1] <= defence[1])
					result.setText("The result is: The attackers and defenders both lost 1 troop in war.");
				else if (attacks[0] <= defence[0] && attacks[1] > defence[1])
					result.setText("The result is: The attackers and defenders both lost 1 troop in war.");
				
			} 
			//Scenario 4: 2 attacking, 1 defending
			else if (atk == 2 && def == 1) {
				//Getting the random attacking dice rolls
				int randAtk1 = rand.nextInt(6) + 1;
				int randAtk2 = rand.nextInt(6) + 1;
				
				//Getting the random defending dice rolls
				int randDef1 = rand.nextInt(6) + 1;
				
				//Getting all the attacking numbers and then sorts them in ascending order
				int[] attacks = {randAtk1, randAtk2};
				sortDesc(attacks);
				System.out.println("Attacking: " + Arrays.toString(attacks) );
				
				//Printing out the defence roll
				System.out.println("Defending: [" + randDef1 + "]");
				
				//Determining the result and printing it to the result label
				if (attacks[0] > randDef1)
					result.setText("The result is: The defenders lost 1 troop in war.");
				else if (attacks[0] <= randDef1)
					result.setText("The result is: The attackers lost 1 troop in war.");
			
			}
			//Scenario 5: 1 attacking, 2 defending
			else if (atk == 1 && def == 2) {
				//Getting the random attacking dice rolls
				int randAtk1 = rand.nextInt(6) + 1;
			
				//Getting the random defending dice rolls
				int randDef1 = rand.nextInt(6) + 1;
				int randDef2 = rand.nextInt(6) + 1;
				
				//Printing the attacking roll
				System.out.println("Attacking: [" + randAtk1 + "]" );
				
				//Getting all the defending numbers and then sorting them in ascending order
				int[] defence = {randDef1, randDef2};
				sortDesc(defence);
				System.out.println("Defending: " + Arrays.toString(defence) );
				
				//Determining the result and printing it to the result label
				if (randAtk1 > defence[0])
					result.setText("The result is: The defenders lost 1 troop in war.");
				else if (randAtk1 <= defence[0])
					result.setText("The result is: The attackers lost 1 troop in war.");
					
			}
			//Scenario 6: 1 attacking, 1 defending
			else if (atk == 1 && def == 1) {
				//Getting the random attacking roll
				int randAtk1 = rand.nextInt(6) + 1;
				
				//Getting the random defending roll
				int randDef1 = rand.nextInt(6) + 1;
				
				//Printing out the attacking and defending rolls
				System.out.println("Attacking: [" + randAtk1 + "]");
				System.out.println("Defending: [" + randDef1 + "]");
				
				//Determining the result and printing it to the result label
				if (randAtk1 > randDef1)
					result.setText("The result is: The defenders lost 1 troop in war.");
				else if (randAtk1 <= randDef1)
					result.setText("The result is: The attackers lost 1 troop in war.");
					
			}
			System.out.println();
		}//end if(input == btnBattle)

	}//end actionPerformed()
	
	//------------------------------------------------
	// Method to sort int arrays in descending order
	//------------------------------------------------
	public static void sortDesc(int[] ar) {
		for (int i=0; i<ar.length-1; i++) {
			int smallest = i;
			int temp = 0;
			
			for (int j = i+1; j<ar.length; j++) {
				if (ar[j]>ar[smallest]) {
					smallest = j;
				}
			}
			//Swapping the integers in the array
			temp = ar[i];
			ar[i] = ar[smallest];
			ar[smallest] = temp;
		}
	}//end sortDesc()

}//end class Battle