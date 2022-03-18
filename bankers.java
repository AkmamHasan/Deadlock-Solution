//package deadlock;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class bankers {

	int process=0;
	int m=0;
	int a=1;
	int flag = 1;
	int flag2 = 0;
	int r=0;
	boolean flag3=false;
	int[][] allocated=new int[10][3];
	int[][] max=new int[10][3]; 
	int[]available=new int[3];
	int[][]needMatrix=new int[10][3]; 
	
	public JFrame frmBankersAlgorith;
	private JTextField txtAllocation;
	private JTextField txtMaxMatrix;
	private JTextField txtAvailable;
	private JTextField txtAllocationTable;
	private JTextField txtMaxTable;
	private JTextField txtNeedMatrix;
	private JTextField txtAvailableMatrix;
	private JTextField txtSequence;
	private JTextField txtResult;
	private JTextField allo1;
	private JTextField allo2;
	private JTextField allo3;
	private JTextField max1;
	private JTextField max2;
	private JTextField max3;
	private JTextField ava1;
	private JTextField ava2;
	private JTextField ava3;
	private JLabel lblR_3;
	private JLabel lblR_4;
	private JLabel lblR_5;
	private JLabel lblR_6;
	private JLabel lblR_7;
	private JLabel lblR_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankers window = new bankers();
					window.frmBankersAlgorith.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bankers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmBankersAlgorith = new JFrame();
		frmBankersAlgorith.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmBankersAlgorith.setBackground(new Color(0, 0, 0));
		frmBankersAlgorith.getContentPane().setBackground(new Color(0, 139, 139));
		frmBankersAlgorith.setTitle("Bankers Algorithm");
		frmBankersAlgorith.setBounds(100, 100, 1143, 609);
		frmBankersAlgorith.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankersAlgorith.getContentPane().setLayout(null);
		
		allo1 = new JTextField();
		allo1.setColumns(10);
		allo1.setBounds(31, 104, 40, 19);
		frmBankersAlgorith.getContentPane().add(allo1);
		
		allo2 = new JTextField();
		allo2.setColumns(10);
		allo2.setBounds(103, 104, 40, 19);
		frmBankersAlgorith.getContentPane().add(allo2);
		
		allo3 = new JTextField();
		allo3.setColumns(10);
		allo3.setBounds(180, 104, 40, 19);
		frmBankersAlgorith.getContentPane().add(allo3);
		
		max1 = new JTextField();
		max1.setColumns(10);
		max1.setBounds(31, 346, 40, 19);
		frmBankersAlgorith.getContentPane().add(max1);
		
		max2 = new JTextField();
		max2.setColumns(10);
		max2.setBounds(92, 346, 40, 19);
		frmBankersAlgorith.getContentPane().add(max2);
		
		max3 = new JTextField();
		max3.setColumns(10);
		max3.setBounds(154, 346, 40, 19);
		frmBankersAlgorith.getContentPane().add(max3);
		
		ava1 = new JTextField();
		ava1.setColumns(10);
		ava1.setBounds(31, 460, 40, 19);
		frmBankersAlgorith.getContentPane().add(ava1);
		
		ava2 = new JTextField();
		ava2.setColumns(10);
		ava2.setBounds(92, 460, 40, 19);
		frmBankersAlgorith.getContentPane().add(ava2);
		
		ava3 = new JTextField();
		ava3.setColumns(10);
		ava3.setBounds(154, 460, 40, 19);
		frmBankersAlgorith.getContentPane().add(ava3);

		txtAllocation = new JTextField();
		txtAllocation.setForeground(new Color(255, 255, 255));
		txtAllocation.setBackground(new Color(0, 0, 0));
		txtAllocation.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAllocation.setText("Allocation");
		txtAllocation.setBounds(62, 29, 96, 19);
		frmBankersAlgorith.getContentPane().add(txtAllocation);
		txtAllocation.setColumns(10);
		
		txtMaxMatrix = new JTextField();
		txtMaxMatrix.setText("Max");
		txtMaxMatrix.setForeground(Color.WHITE);
		txtMaxMatrix.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMaxMatrix.setColumns(10);
		txtMaxMatrix.setBackground(Color.BLACK);
		txtMaxMatrix.setBounds(74, 288, 96, 19);
		frmBankersAlgorith.getContentPane().add(txtMaxMatrix);
		
		
		
		txtAvailable = new JTextField();
		txtAvailable.setText("Available");
		txtAvailable.setForeground(Color.WHITE);
		txtAvailable.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAvailable.setColumns(10);
		txtAvailable.setBackground(Color.BLACK);
		txtAvailable.setBounds(62, 406, 96, 19);
		frmBankersAlgorith.getContentPane().add(txtAvailable);
		
		
		
		JTextArea textArea_max = new JTextArea();
		textArea_max.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea_max.setBounds(257, 329, 270, 199);
		frmBankersAlgorith.getContentPane().add(textArea_max);
		textArea_max.setText("\tR1   "+"R2   "+"R3\n");
		
		txtAllocationTable = new JTextField();
		txtAllocationTable.setText("Allocation Table");
		txtAllocationTable.setForeground(Color.WHITE);
		txtAllocationTable.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAllocationTable.setColumns(10);
		txtAllocationTable.setBackground(Color.BLACK);
		txtAllocationTable.setBounds(312, 29, 148, 19);
		frmBankersAlgorith.getContentPane().add(txtAllocationTable);
		
		txtMaxTable = new JTextField();
		txtMaxTable.setText("Max Table");
		txtMaxTable.setForeground(Color.WHITE);
		txtMaxTable.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMaxTable.setColumns(10);
		txtMaxTable.setBackground(Color.BLACK);
		txtMaxTable.setBounds(342, 300, 96, 19);
		frmBankersAlgorith.getContentPane().add(txtMaxTable);
		
		JTextArea textArea_allocate = new JTextArea();
		textArea_allocate.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea_allocate.setBounds(257, 72, 270, 199);
		frmBankersAlgorith.getContentPane().add(textArea_allocate);
		textArea_allocate.setText("\t"+"R1  "+"R2  "+"R3\n");
		
		txtNeedMatrix = new JTextField();
		txtNeedMatrix.setText("Need Matrix");
		txtNeedMatrix.setForeground(Color.WHITE);
		txtNeedMatrix.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtNeedMatrix.setColumns(10);
		txtNeedMatrix.setBackground(Color.BLACK);
		txtNeedMatrix.setBounds(631, 300, 110, 19);
		frmBankersAlgorith.getContentPane().add(txtNeedMatrix);
		
		JTextArea textArea_available = new JTextArea();
		textArea_available.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea_available.setBounds(560, 72, 270, 199);
		frmBankersAlgorith.getContentPane().add(textArea_available);
		textArea_available.setText("\tR1   "+"R2   "+"R3\n");
		
		txtAvailableMatrix = new JTextField();
		txtAvailableMatrix.setText("Available Matrix");
		txtAvailableMatrix.setForeground(Color.WHITE);
		txtAvailableMatrix.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAvailableMatrix.setColumns(10);
		txtAvailableMatrix.setBackground(Color.BLACK);
		txtAvailableMatrix.setBounds(607, 29, 144, 19);
		frmBankersAlgorith.getContentPane().add(txtAvailableMatrix);
		
		JTextArea textArea_need = new JTextArea();
		textArea_need.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea_need.setBounds(560, 332, 270, 197);
		frmBankersAlgorith.getContentPane().add(textArea_need);
		textArea_need.setText("\tR1   "+"R2   "+"R3\n");
		
		JTextArea textArea_sequence = new JTextArea();
		textArea_sequence.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea_sequence.setBounds(896, 72, 197, 277);
		frmBankersAlgorith.getContentPane().add(textArea_sequence);
		 textArea_sequence.setText("\n   Safe Sequnce:");
		
		txtSequence = new JTextField();
		txtSequence.setText("Sequence");
		txtSequence.setForeground(Color.WHITE);
		txtSequence.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSequence.setColumns(10);
		txtSequence.setBackground(Color.BLACK);
		txtSequence.setBounds(946, 29, 110, 19);
		frmBankersAlgorith.getContentPane().add(txtSequence);
		
		txtResult = new JTextField();
		txtResult.setText("Result");
		txtResult.setForeground(Color.WHITE);
		txtResult.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtResult.setColumns(10);
		txtResult.setBackground(Color.BLACK);
		txtResult.setBounds(965, 415, 70, 19);
		frmBankersAlgorith.getContentPane().add(txtResult);
		
		JTextArea textArea_result = new JTextArea();
		textArea_result.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_result.setBounds(896, 444, 197, 89);
		frmBankersAlgorith.getContentPane().add(textArea_result);
		
		
		JButton btnAllocation = new JButton("Add");
		btnAllocation.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAllocation.setBackground(new Color(135, 206, 250));
		btnAllocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.out.println(process);
				 //allocated=new int[process+1][3];
				
				 String t1=allo1.getText();
				 String t2=allo2.getText();
				 String t3=allo3.getText();
				 
				 allocated[process][0]=Integer.parseInt(t1);
				 allocated[process][1]=Integer.parseInt(t2);
				 allocated[process][2]=Integer.parseInt(t3);
				 process++;
				 System.out.println(process);
				 textArea_allocate.append("\t"+t1+"   "+t2+"   "+t3+"\n");
				 
				
				 allo1.setText("");
				 allo2.setText("");
				 allo3.setText("");
				 
			}
		});
		
		JButton btnAvailable = new JButton("Calculate");
		btnAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//available=new int[a][3];
				 System.out.println(a);
				 
				 String t1=ava1.getText();
				 String t2=ava2.getText();
				 String t3=ava3.getText();
				 
				 available[0]=Integer.parseInt(t1);
				 available[1]=Integer.parseInt(t2);
				 available[2]=Integer.parseInt(t3);
			
			
				 textArea_available.append("\t"+t1+"    "+t2+"    "+t3+"\n");
				 
				 ava1.setText("");
				 
				 ava2.setText("");
				 ava3.setText("");
				 
				 //need matrix
				 System.out.println("Need:");
				 for (int i = 0; i < process; i++) {
					    for (int j = 0; j < 3; j++) {
					      needMatrix[i][j] = max[i][j] - allocated[i][j]; // calculating need matrix
					      System.out.print("\t"+needMatrix[i][j]);       //  printing need matrix
					    }
					    textArea_need.append("\t"+needMatrix[i][0]+"    "+needMatrix[i][1]+"    "+needMatrix[i][2]+"\n");
					  }
System.out.println("Final Out put...................................................................");
				
				
				
int count=0;
int safeSequence[] = new int[process];
//visited array to find the already allocated process
boolean visited[] = new boolean[process];
for (int i = 0;i < process; i++)
{
    visited[i] = false;
}
     
//work array to store the copy of available resources
int work[] = new int[3];   
for (int i = 0;i < 3; i++)
{
    work[i] = available[i];
}

while (count<process)
{
    boolean flag = false;
    for (int i = 0;i < process; i++)
    {
        if (visited[i] == false)
         {
        int j;
        for (j = 0;j < 3; j++)
        {       
            if (needMatrix[i][j] > work[j])
            break;
        }
        if (j == 3)
        {
           safeSequence[count++]=i;
           visited[i]=true;
           flag=true;
                     
            for (j = 0;j < 3
            		; j++)
            {
            work[j] = work[j]+allocated[i][j];
            }
        }
         }
    }
    if (flag == false)
    {
        break;
    }
}
if (count < process)
{
    System.out.println("The System is UnSafe!");
    textArea_result.append("\n   Deadlock");
}
else
{
    //System.out.println("The given System is Safe");
	textArea_result.append("\n   Safe");
            for (int i = 0;i < process; i++)
    {
            	textArea_sequence.append("\n   Process"+safeSequence[i]);
       
    }
}
}				    
				
		});
		btnAvailable.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAvailable.setBackground(new Color(135, 206, 250));
		btnAvailable.setBounds(62, 490, 102, 21);
		frmBankersAlgorith.getContentPane().add(btnAvailable);
		

		JButton btnMax = new JButton("Add");
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //max=new int[m+1][3];
				 System.out.println(m);
				 
				 String t1=max1.getText();
				 String t2=max2.getText();
				 String t3=max3.getText();
				 
				 max[m][0]=Integer.parseInt(max1.getText());
				 max[m][1]=Integer.parseInt(max2.getText());
				 max[m][2]=Integer.parseInt(max3.getText());
			
			
				 m++;
				 textArea_max.append("\t"+t1+"    "+t2+"    "+t3+"\n");
				 
				 max1.setText("");
				 
				 max2.setText("");
				 max3.setText("");
			}
		});
		btnMax.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMax.setBackground(new Color(135, 206, 250));
		btnMax.setBounds(68, 375, 85, 21);
		frmBankersAlgorith.getContentPane().add(btnMax);
		
		btnAllocation.setBounds(73, 133, 85, 21);
		frmBankersAlgorith.getContentPane().add(btnAllocation);
		
		JLabel lblR = new JLabel("R1");
		lblR.setForeground(Color.WHITE);
		lblR.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR.setBounds(43, 81, 19, 13);
		frmBankersAlgorith.getContentPane().add(lblR);
		
		JLabel lblR_1 = new JLabel("R2");
		lblR_1.setForeground(Color.WHITE);
		lblR_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR_1.setBounds(114, 81, 29, 13);
		frmBankersAlgorith.getContentPane().add(lblR_1);
		
		JLabel lblR_2 = new JLabel("R3");
		lblR_2.setForeground(Color.WHITE);
		lblR_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR_2.setBounds(186, 81, 61, 13);
		frmBankersAlgorith.getContentPane().add(lblR_2);
		
		lblR_3 = new JLabel("R1");
		lblR_3.setForeground(Color.WHITE);
		lblR_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR_3.setBounds(41, 317, 19, 13);
		frmBankersAlgorith.getContentPane().add(lblR_3);
		
		lblR_4 = new JLabel("R2");
		lblR_4.setForeground(Color.WHITE);
		lblR_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR_4.setBounds(103, 317, 29, 13);
		frmBankersAlgorith.getContentPane().add(lblR_4);
		
		lblR_5 = new JLabel("R3");
		lblR_5.setForeground(Color.WHITE);
		lblR_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR_5.setBounds(159, 317, 61, 13);
		frmBankersAlgorith.getContentPane().add(lblR_5);
		
		lblR_6 = new JLabel("R1");
		lblR_6.setForeground(Color.WHITE);
		lblR_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR_6.setBounds(41, 437, 19, 13);
		frmBankersAlgorith.getContentPane().add(lblR_6);
		
		lblR_7 = new JLabel("R2");
		lblR_7.setForeground(Color.WHITE);
		lblR_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR_7.setBounds(103, 437, 29, 13);
		frmBankersAlgorith.getContentPane().add(lblR_7);
		
		lblR_8 = new JLabel("R3");
		lblR_8.setForeground(Color.WHITE);
		lblR_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR_8.setBounds(159, 437, 61, 13);
		frmBankersAlgorith.getContentPane().add(lblR_8);
		
		
		
			}
}
