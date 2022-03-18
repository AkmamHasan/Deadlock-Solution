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

public class resourceAllocation {

	int process=0;
	int m=0;
	int a=1;
	int flag = 1;
	int flag2 = 0;
	int r=0;
	boolean flag3=false;
	int[][] allocated=new int[10][3];  
	
	
	public JFrame frmBankersAlgorith;
	private JTextField txtAllocation;
	private JTextField txtAllocationTable;
	private JTextField txtResult;
	private JTextField allo1;
	private JTextField allo2;
	private JTextField allo3;
	private JTextField resource_col;
	private JLabel lblR_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resourceAllocation window = new resourceAllocation();
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
	public resourceAllocation() {
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
		frmBankersAlgorith.setTitle("Resource Allocation ");
		frmBankersAlgorith.setBounds(100, 100, 700, 609);
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
		
		resource_col = new JTextField();
		resource_col.setColumns(10);
		resource_col.setBounds(405, 300, 55, 19);
		frmBankersAlgorith.getContentPane().add(resource_col);

		txtAllocation = new JTextField();
		txtAllocation.setForeground(new Color(255, 255, 255));
		txtAllocation.setBackground(new Color(0, 0, 0));
		txtAllocation.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAllocation.setText("Allocation");
		txtAllocation.setBounds(62, 29, 96, 19);
		frmBankersAlgorith.getContentPane().add(txtAllocation);
		txtAllocation.setColumns(10);
		
		txtAllocationTable = new JTextField();
		txtAllocationTable.setText("Allocation Table");
		txtAllocationTable.setForeground(Color.WHITE);
		txtAllocationTable.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAllocationTable.setColumns(10);
		txtAllocationTable.setBackground(Color.BLACK);
		txtAllocationTable.setBounds(312, 29, 148, 19);
		frmBankersAlgorith.getContentPane().add(txtAllocationTable);
		
		JTextArea textArea_allocate = new JTextArea();
		textArea_allocate.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea_allocate.setBounds(257, 72, 270, 199);
		frmBankersAlgorith.getContentPane().add(textArea_allocate);
		textArea_allocate.setText("\t"+"R1  "+"R2  "+"R3\n");
		
		txtResult = new JTextField();
		txtResult.setText("Result");
		txtResult.setForeground(Color.WHITE);
		txtResult.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtResult.setColumns(10);
		txtResult.setBackground(Color.BLACK);
		txtResult.setBounds(295, 351, 70, 19);
		frmBankersAlgorith.getContentPane().add(txtResult);
		
		JTextArea textArea_result = new JTextArea();
		textArea_result.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_result.setBounds(31, 380, 608, 165);
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
		
		JButton btnAvailable = new JButton("Check");
		btnAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i,j,col=2,count=-1;
				
				System.out.println("Enter a resource to check if collision happens"); 
				int resource=Integer.parseInt(resource_col.getText());
				for(i=0;i<process;i++)
				{
				for(j=0;j<col;j++)
				{
				if(resource==allocated[i][j])
				{
					System.out.println("Matches[row][column]");
					System.out.println(i<<j);
					count=count+1;
				}
				}
				}
				textArea_result.append("Counts of deadlock: "+count); 
				return;
				
			}
				
		});
		btnAvailable.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAvailable.setBackground(new Color(135, 206, 250));
		btnAvailable.setBounds(507, 298, 102, 21);
		frmBankersAlgorith.getContentPane().add(btnAvailable);
		
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
		
		lblR_6 = new JLabel("Enter a resource to check if collision happens");
		lblR_6.setForeground(Color.WHITE);
		lblR_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR_6.setBounds(31, 301, 364, 13);
		frmBankersAlgorith.getContentPane().add(lblR_6);
		
		
		
			}
}