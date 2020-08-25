package view;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import commands.CommandsFactory;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import model.Document;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import java.nio.file.attribute.FileTime;


public class Text2SpeechEditorView{

	private JFrame frmTextvoiceApp;
	private CommandsFactory cmd;
	private EditorPane editorPane;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private Document currentDocument = new Document();
	private JMenuItem replayCommand;
	private static Text2SpeechEditorView instance;	
	private String docPath = "noPath";
	private JTextField volumeField,rateField,pitchField;
	private JMenu preferencesMenu ;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private FileTime dateCreated,dateModified;
	private JRadioButton atBashEncode_1,rot13Encode_1;
	public JMenuItem NewDocMenu;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Text2SpeechEditorView window = Text2SpeechEditorView.getInstance();
					window.frmTextvoiceApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Text2SpeechEditorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		currentDocument.setAdapterMode("FreeTTSAdapter");
		currentDocument.setEncodeStrategy("Rot13");
		cmd = new CommandsFactory();
		
		//frame
		frmTextvoiceApp = new JFrame();
		frmTextvoiceApp.setTitle("text2voice App");
		frmTextvoiceApp.setBounds(100, 100, 750, 500);
		frmTextvoiceApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//menuBar
		menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.setBackground(new Color(255, 255, 153));
		frmTextvoiceApp.setJMenuBar(menuBar);

		//scrollPane, EditorPane
		frmTextvoiceApp.getContentPane().setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		frmTextvoiceApp.getContentPane().add(scrollPane, BorderLayout.CENTER);
		editorPane = new EditorPane();
		scrollPane.setViewportView(editorPane);
		editorPane.setBackground(SystemColor.control);
		

		//SubMenu document
		JMenu DocumentSubMenu = new JMenu("Document");
		menuBar.add(DocumentSubMenu);
		
		//SubMenuItems 
		NewDocMenu = new JMenuItem("New");
		NewDocMenu.addActionListener(cmd.createCommand("NewDocument"));
		DocumentSubMenu.add(NewDocMenu);		
		
		
		JMenuItem OpenDocMenu = new JMenuItem("Open");
		OpenDocMenu.addActionListener(cmd.createCommand("OpenDocument"));
		DocumentSubMenu.add(OpenDocMenu);
		
		JMenuItem SaveDocMenu = new JMenuItem("Save");
		SaveDocMenu.addActionListener(cmd.createCommand("SaveDocument"));
		DocumentSubMenu.add(SaveDocMenu);
		
		JMenuItem EditDocMenu = new JMenuItem("Edit");
		EditDocMenu.addActionListener(cmd.createCommand("EditDocument"));
		DocumentSubMenu.add(EditDocMenu);
		
		//SubMenu Listen
		JMenu Text2SpeechMenu = new JMenu("Listen");
		menuBar.add(Text2SpeechMenu);
		
		JMenuItem listenDoc = new JMenuItem("Document");
		listenDoc.addActionListener(cmd.createCommand("DocumentToSpeech"));
		Text2SpeechMenu.add(listenDoc);		
		
		JMenuItem listenLine = new JMenuItem("Line");
		listenLine.addActionListener(cmd.createCommand("LineToSpeech"));
		Text2SpeechMenu.add(listenLine);
		
		JMenuItem listenReversedDoc = new JMenuItem("Reversed Document");
		Text2SpeechMenu.add(listenReversedDoc);
		listenReversedDoc.addActionListener(cmd.createCommand("DocumentToSpeech"));
		
		JMenuItem listenReversedLine = new JMenuItem("Reversed Line");
		Text2SpeechMenu.add(listenReversedLine);
		listenReversedLine.addActionListener(cmd.createCommand("LineToSpeech"));
		
		JMenuItem listenEncodedDocument = new JMenuItem("Encoded Document");
		Text2SpeechMenu.add(listenEncodedDocument);
		listenEncodedDocument.addActionListener(cmd.createCommand("DocumentToSpeech"));
		
		JMenuItem listenEncodedLine = new JMenuItem("Encoded Line");
		Text2SpeechMenu.add(listenEncodedLine);
		listenEncodedLine.addActionListener(cmd.createCommand("LineToSpeech"));
		
		JMenu mnEncodeOptions = new JMenu("Encode techniques");
		Text2SpeechMenu.add(mnEncodeOptions);
		
		rot13Encode_1 = new JRadioButton("Rot13");
		mnEncodeOptions.add(rot13Encode_1);
		
		atBashEncode_1 = new JRadioButton("AtBash");
		mnEncodeOptions.add(atBashEncode_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rot13Encode_1);
		group.add(atBashEncode_1);
		
		JButton tuneEncode = new JButton("Apply");
		mnEncodeOptions.add(tuneEncode);
		tuneEncode.addActionListener(cmd.createCommand("TuneEncoding"));
		
		JMenu replayMenu = new JMenu("Replay");
		menuBar.add(replayMenu);
		
		replayCommand = new JMenuItem("Command");
		replayCommand.addActionListener(cmd.createCommand("ReplayCommand"));
		replayMenu.add(replayCommand);
		
		//SubMenu Preferences
		preferencesMenu = new JMenu("Preferences");
		menuBar.add(preferencesMenu);
		
		JLabel volLabel = new JLabel("Volume");
		preferencesMenu.add(volLabel);
		
		volumeField = new JTextField();
		volumeField.setText("90");
		preferencesMenu.add(volumeField);
		volumeField.setColumns(10);
		
		JLabel rateLabel = new JLabel("Rate");
		preferencesMenu.add(rateLabel);
		
		rateField = new JTextField();
		rateField.setText("120");
		preferencesMenu.add(rateField);
		rateField.setColumns(10);
		
		JLabel pitchLabel = new JLabel("Pitch");
		preferencesMenu.add(pitchLabel);
		
		pitchField = new JTextField();
		pitchField.setText("120");
		preferencesMenu.add(pitchField);
		pitchField.setColumns(10);
		
		JButton savePreferencesButton = new JButton("Apply");
		savePreferencesButton.addActionListener(cmd.createCommand("TuneAudio"));
		preferencesMenu.add(savePreferencesButton);
		
	}
	
	public EditorPane getEditorPane() {
		return editorPane;
	}
	
	public int getVolume() {
		try {
			return Integer.parseInt(this.volumeField.getText());
		}catch(NullPointerException e) {
			return 50;
		}
	}
	
	public int getRate() {
		try {
			return Integer.parseInt(this.rateField.getText());
		}catch(NullPointerException e) {
			return 50;
		}
	}
	
	public int getPitch() {
		try {
			return Integer.parseInt(this.pitchField.getText());
		}catch(NullPointerException e) {
			return 110;
		}
	}
	
	public String getDocumentPath() {
		return this.docPath;
	}
	
	public static Text2SpeechEditorView getInstance() {
		if(instance == null){
            instance = new Text2SpeechEditorView();
        }
        return instance;
	}

	
	public Document getCurrentDocument() {
		return currentDocument;
	}
	
	public void setTitle(String author, String title) {
		frmTextvoiceApp.setTitle(author+" : "+title);
	}
	
	
	public JMenuItem getReplayCommand() {
		return replayCommand;
	}
	
	public void setPath(String docPath) {
		this.docPath = docPath;
	}
	
	public void newDocument() {
		currentDocument = new Document();
		currentDocument.setAdapterMode("FreeTTSAdapter");
	}
	
	public JFrame getFrame() {
		return frmTextvoiceApp;
	}
	
	public String getEncodeOption() {
		if(this.atBashEncode_1.isSelected()) {
			return "AtBash";
		}
		return "Rot13";
	}
	
	public void setAudioParameters(String volume, String pitch, String rate) {
		this.volumeField.setText(volume); 
		this.rateField.setText(rate);
		this.pitchField.setText(pitch);
	}
	
	public JRadioButton getEncodingButton(String encodeOption) {
		if(encodeOption.equals("Rote13")) 
			return this.rot13Encode_1;

		return atBashEncode_1;
	}
	
}
