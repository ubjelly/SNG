package org.sng;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import org.sng.engine.Generator;

/**
 * The main class for SNG.
 * @author Stephen Andrews
 */
public class Window extends JFrame {

	private Generator generator;
	private JPanel contentPane;
	private JLabel lblInput;
	private JLabel lblOutput;
	private JButton generateButton;
	private JScrollPane inputScrollPane;
	private JScrollPane outputScrollPane;
	private JTextArea inputArea;
	private static JTextArea outputArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setResizable(false);
		setTitle("SNG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		generator = new Generator();
		
		lblInput = new JLabel("Input:");
		lblInput.setBounds(6, 6, 61, 16);
		contentPane.add(lblInput);
		
		lblOutput = new JLabel("Output:");
		lblOutput.setBounds(203, 6, 61, 16);
		contentPane.add(lblOutput);
		
		generateButton = new JButton("Generate");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generator.generate(inputArea.getText());
			}
		});
		generateButton.setBounds(476, 303, 117, 29);
		contentPane.add(generateButton);
		
		inputScrollPane = new JScrollPane();
		inputScrollPane.setBounds(6, 29, 185, 262);
		contentPane.add(inputScrollPane);
		
		inputArea = new JTextArea();
		inputScrollPane.setViewportView(inputArea);
		
		outputScrollPane = new JScrollPane();
		outputScrollPane.setBounds(203, 29, 390, 262);
		contentPane.add(outputScrollPane);
		
		outputArea = new JTextArea();
		outputScrollPane.setViewportView(outputArea);
		outputArea.setForeground(Color.WHITE);
		outputArea.setBackground(Color.BLACK);
	}

	/**
	 * Gets the output area.
	 * @return The output area.
	 */
	public static JTextArea getOutput() {
		return outputArea;
	}
}
