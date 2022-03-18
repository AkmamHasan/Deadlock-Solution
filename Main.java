//package deadlock;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class Main {

	private JFrame frmBankersAlgorithm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmBankersAlgorithm.setVisible(true);  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankersAlgorithm = new JFrame();
		frmBankersAlgorithm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankersAlgorithm.getContentPane().setBackground(new Color(0, 139, 139));
		
		frmBankersAlgorithm.setTitle("Deadlock");
		frmBankersAlgorithm.setBounds(100, 100, 461, 292);
		frmBankersAlgorithm.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Bankers Algorithm");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(46, 27, 319, 40);
		frmBankersAlgorithm.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Resource Allocation Graph");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton_1.setBounds(47, 88, 318, 40);
		frmBankersAlgorithm.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((rdbtnNewRadioButton).isSelected()){
					bankers win=new bankers();
					win.frmBankersAlgorith.setVisible(true);
				}
				if((rdbtnNewRadioButton_1).isSelected()){
					resourceAllocation win2=new resourceAllocation();
					win2.frmBankersAlgorith.setVisible(true);
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(135, 171, 140, 46);
		frmBankersAlgorithm.getContentPane().add(btnNewButton);
	}
}
