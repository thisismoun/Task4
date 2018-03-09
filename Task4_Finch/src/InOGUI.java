
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
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class InOGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lengthField;
	private JTextField sectionField;

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

	public InOGUI() {
		setBackground(Color.WHITE);
		setTitle("Zig-zag");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterLengthHere = new JLabel("Enter length here");
		lblEnterLengthHere.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterLengthHere.setBounds(197, 120, 180, 34);
		lblEnterLengthHere.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEnterLengthHere);
		
		JLabel label = new JLabel("");
		label.setBounds(93, 135, 0, 0);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(93, 135, 0, 0);
		contentPane.add(label_1);
		
		lengthField = new JTextField();
		lengthField.setBackground(Color.WHITE);
		lengthField.setBounds(197, 151, 123, 36);
		contentPane.add(lengthField);
		lengthField.setColumns(10);
		
		JButton lengthHelp = new JButton("?");
		lengthHelp.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		lengthHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Length is measured in centimeters" + "\n It must be within the range of 30cm and 80cm");
			}
		});
		lengthHelp.setBounds(330, 150, 47, 36);
		contentPane.add(lengthHelp);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(155, 135, 0, 0);
		contentPane.add(label_2);
		
		JLabel lblEnter = new JLabel("Enter number of sections here");
		lblEnter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnter.setBounds(197, 208, 214, 40);
		contentPane.add(lblEnter);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(300, 135, 0, 0);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(300, 135, 0, 0);
		contentPane.add(label_4);
		
		sectionField = new JTextField();
		sectionField.setBackground(Color.WHITE);
		sectionField.setBounds(197, 248, 123, 36);
		contentPane.add(sectionField);
		sectionField.setColumns(10);
		
		JButton sectionHelp = new JButton("?");
		sectionHelp.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		sectionHelp.setForeground(Color.BLACK);
		sectionHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Section must be a positive even number" + "\n It must be a minimum of 2 and maximum of 10");
			}
		});
		sectionHelp.setBounds(330, 248, 47, 36);
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
				int dist;
				double displacement;
				try {
					//check for if both fields are simultaneously out of bounds
					if ((Integer.parseInt(sectionField.getText()) < 2  || Integer.parseInt(sectionField.getText()) > 10) && (Integer.parseInt(lengthField.getText()) < 30 || Integer.parseInt(lengthField.getText()) > 80))
					{
						JOptionPane.showMessageDialog(null,"Oops! The given value for 'length' and 'sections' is out of bounds!" +"\nPlease try again!");
					}
					//otherwise, checks if section is in bounds
					else if (Integer.parseInt(sectionField.getText()) >= 2  && Integer.parseInt(sectionField.getText()) <= 10 && Integer.parseInt(sectionField.getText())%2 == 0)
					{
						//if yes, then assigns userSec as the value and then checks if the length field is in the bounds
						userSec = Integer.parseInt(sectionField.getText());
						if (Integer.parseInt(lengthField.getText()) >= 30 && Integer.parseInt(lengthField.getText()) <= 80) 
							// if yes, all checks are complete. finchLen is assigned the value and the zig zag constructor from the movement class is called with with values of finchLen and userSec.
							//Then, distance and displacement is calculated and displayed once the finch is done moving
						{
							finchLen = Integer.parseInt(lengthField.getText());
							FinchMovement.zig_Zag(finchLen, userSec);
							//One line of code, so no need to create another method to calculate the total distance
							dist = userSec * finchLen;
							displacement = displaceCalc(finchLen,userSec);
							JOptionPane.showMessageDialog(null, "The finch travelled a total of " + dist +"cm" + "\nThe total displacement is " + displacement + "cm");
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"Oops! The given value for 'length' is out of Bounds!" +"\nPlease try again!");
						}
							
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Oops! The given value for 'section' is out of Bounds!" +"\nPlease try again!");
					}
					
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "One of the fields is blank or not a number. Please input valid parameters" + "\n See '?' for details");
				}
				
				
				
			}
		});
		proceedButton.setBounds(417, 296, 112, 48);
		contentPane.add(proceedButton);
		
		JLabel mainHeader = new JLabel("Task 4: Zig-Zag!");
		mainHeader.setFont(new Font("Tahoma", Font.BOLD, 29));
		mainHeader.setHorizontalAlignment(SwingConstants.CENTER);
		mainHeader.setBounds(5, 17, 528, 77);
		contentPane.add(mainHeader);
	}
	//method used to calculate displacement. Used as code is a bit lengthy to put into the Action Event
	public static double displaceCalc(int finchLen,int userSec) {
		double x;
		DecimalFormat dd = new DecimalFormat("#.##");  
		x = ((userSec/2) * (finchLen * Math.sqrt(2)));
		x = Double.valueOf(dd.format(x));
		return (x);
		
	}
}
 
