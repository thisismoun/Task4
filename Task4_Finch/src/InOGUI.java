
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class InOGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lengthField;
	private JTextField sectionField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InOGUI frame = new InOGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InOGUI() {
		setTitle("Zig-zag");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterLengthHere = new JLabel("Enter length here");
		lblEnterLengthHere.setBounds(155, 99, 136, 14);
		lblEnterLengthHere.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEnterLengthHere);
		
		JLabel label = new JLabel("");
		label.setBounds(93, 135, 0, 0);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(93, 135, 0, 0);
		contentPane.add(label_1);
		
		lengthField = new JTextField();
		lengthField.setBounds(155, 124, 84, 20);
		contentPane.add(lengthField);
		lengthField.setColumns(10);
		
		JButton lengthHelp = new JButton("?");
		lengthHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Length is measured in centimeters" + "\n It must be within the range of 30cm and 80cm");
			}
		});
		lengthHelp.setBounds(253, 123, 47, 23);
		contentPane.add(lengthHelp);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(155, 135, 0, 0);
		contentPane.add(label_2);
		
		JLabel lblEnter = new JLabel("Enter number of sections here");
		lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnter.setBounds(143, 165, 180, 14);
		contentPane.add(lblEnter);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(300, 135, 0, 0);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(300, 135, 0, 0);
		contentPane.add(label_4);
		
		sectionField = new JTextField();
		sectionField.setBounds(155, 184, 84, 20);
		contentPane.add(sectionField);
		sectionField.setColumns(10);
		
		JButton sectionHelp = new JButton("?");
		sectionHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Section must be a positive even number" + "\n It must be a minimum of 2 and maximum of 10");
			}
		});
		sectionHelp.setBounds(253, 183, 47, 23);
		contentPane.add(sectionHelp);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(362, 135, 0, 0);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(362, 135, 0, 0);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(362, 135, 0, 0);
		contentPane.add(label_7);
		
		JButton proceedButton = new JButton("Proceed");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userSec;
				int finchLen;
				try {
					
					if (Integer.parseInt(sectionField.getText()) < 2  || Integer.parseInt(sectionField.getText()) > 10 && Integer.parseInt(lengthField.getText()) < 30 || Integer.parseInt(lengthField.getText()) > 80)
					{
						JOptionPane.showMessageDialog(null,"Oops! The given value for length and sections is out of bounds!" +"\nPlease try again!");
					}
					else if (Integer.parseInt(sectionField.getText()) >= 2  && Integer.parseInt(sectionField.getText()) <= 10 && Integer.parseInt(sectionField.getText())%2 == 0)
					{
						userSec = Integer.parseInt(sectionField.getText());
						if (Integer.parseInt(lengthField.getText()) >= 30 && Integer.parseInt(lengthField.getText()) <= 80)
						{
							finchLen = Integer.parseInt(lengthField.getText());
							FinchTest.forwardMovement(finchLen,userSec);
							FinchTest.retraceMovement(finchLen,userSec);
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"Oops! The given value for length is out of Bounds!" +"\nPlease try again!");
						}
							
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Oops! The given value for section is out of Bounds!" +"\nPlease try again!");
					}
					
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "One of the fields is blank or not a number. Please input valid parameters" + "\n See help for details");
				}
				
				
				
			}
		});
		proceedButton.setBounds(334, 227, 90, 23);
		contentPane.add(proceedButton);
		
		JLabel mainHeader = new JLabel("Task 4: Zig-Zag!");
		mainHeader.setFont(new Font("Tahoma", Font.BOLD, 29));
		mainHeader.setHorizontalAlignment(SwingConstants.CENTER);
		mainHeader.setBounds(10, 11, 414, 77);
		contentPane.add(mainHeader);
	}
}
 
