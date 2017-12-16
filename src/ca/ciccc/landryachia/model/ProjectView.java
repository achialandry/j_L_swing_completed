package ca.ciccc.landryachia.model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 * User Interface for the program
 * @author Landry Achia
 *
 */
public class ProjectView extends JFrame {

	private JPanel contentPane;
	private JTextField txtInputDateHere;
	private JTextField txtResultDateFor;

	/**
	 * Create the frame with the UI elements!
	 */
	public ProjectView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][][]"));

		JButton btnNewButton = new JButton("Click to Check Date");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userInput = txtInputDateHere.getText();
				String[] inputParts = userInput.split("-");
				int year = Integer.parseInt(inputParts[0]);
				int month = Integer.parseInt(inputParts[1]);
				int day = Integer.parseInt(inputParts[2]);
				Date date;
				try {
					date = new Date(year, month, day);
					txtResultDateFor.setText(date.getMonthName() + " " + date.addZeroString() + ", " + date.getYear()
					+ " was on " + date.getDayOfTheWeek());

				} catch (Exception e) {
					txtResultDateFor.setText(e.getMessage());
				}

				
			}
		});

		JLabel lblDateInFormat = new JLabel("Date in Format YYYY-MM-DD");
		contentPane.add(lblDateInFormat, "cell 4 0");

		txtInputDateHere = new JTextField();
		txtInputDateHere.setText("Input Date Here");
		contentPane.add(txtInputDateHere, "cell 4 1,growx");
		txtInputDateHere.setColumns(10);
		contentPane.add(btnNewButton, "cell 4 4");

		txtResultDateFor = new JTextField();
		contentPane.add(txtResultDateFor, "cell 4 6,growx");
		txtResultDateFor.setColumns(10);

		JLabel lblNewLabel = new JLabel("Result Date for your inputed date");
		contentPane.add(lblNewLabel, "cell 4 7");
	}

}
