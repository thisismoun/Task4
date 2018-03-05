import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class InOGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		lblEnterLengthHere.setBounds(155, 99, 84, 14);
		lblEnterLengthHere.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEnterLengthHere);
		
		JLabel label = new JLabel("");
		label.setBounds(93, 135, 0, 0);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(93, 135, 0, 0);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(155, 124, 84, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("?");
		button.setBounds(253, 123, 37, 23);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(155, 135, 0, 0);
		contentPane.add(label_2);
		
		JLabel lblEnter = new JLabel("Enter number of sections here");
		lblEnter.setBounds(155, 165, 145, 14);
		contentPane.add(lblEnter);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(300, 135, 0, 0);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(300, 135, 0, 0);
		contentPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 184, 84, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("?");
		button_1.setBounds(253, 183, 37, 23);
		contentPane.add(button_1);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(362, 135, 0, 0);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(362, 135, 0, 0);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(362, 135, 0, 0);
		contentPane.add(label_7);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(353, 227, 71, 23);
		contentPane.add(btnProceed);
	}
}
