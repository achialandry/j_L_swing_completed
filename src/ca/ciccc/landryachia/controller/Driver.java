package ca.ciccc.landryachia.controller;

import java.awt.EventQueue;

import ca.ciccc.landryachia.model.ProjectView;

/**
 * Entry point of the main app
 * @author Landry Achia
 *
 */
public class Driver {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectView frame = new ProjectView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
