import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TextArea extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	String randomString = "";
	Random r = new Random();
	int counter=0;
	private JLabel lblSearching;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextArea frame = new TextArea();
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
	public TextArea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 121, 355, 360);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setTabSize(5);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 23));
		textArea.setForeground(new Color(255, 255, 50));
		textArea.setBackground(Color.BLUE);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField.setBounds(66, 47, 225, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(301, 47, 120, 50);
		contentPane.add(btnNewButton);
		
		lblSearching = new JLabel("");
		lblSearching.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearching.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearching.setBounds(194, 492, 101, 23);
		contentPane.add(lblSearching);
		
		lblNewLabel = new JLabel("MUSTAFA ERCAN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(85, 526, 305, 38);
		contentPane.add(lblNewLabel);
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				textField.setText(textField.getText().toUpperCase());
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				lblSearching.setText("");
				counter=0;
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						while(true) {
							counter++;
							randomString = "";
							for(int i=0; i<textField.getText().length(); i++) {
								randomString+= (char) (r.nextInt(90-65)+65);
							}
							if(randomString.equals(textField.getText())) {
								textArea.setText(textArea.getText()+"\n"+randomString+" - "+counter+". Deneme");
								lblSearching.setText("Bulundu");
								break;
							}
							textArea.setText(textArea.getText()+"\n"+randomString+" - "+counter+". Deneme");
							lblSearching.setText("Araniyor...");
						}
						
					}
				});
				th.start();

			}
			
		});
		
	}
}
