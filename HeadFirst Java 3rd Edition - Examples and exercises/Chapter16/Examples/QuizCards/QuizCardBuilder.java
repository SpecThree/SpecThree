import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder
{
	private ArrayList<QuizCard> cardList = new ArrayList<>();
	private JTextArea question;
	private JTextArea answer;
	private JFrame frame;
	
	public static void main(String[] args)
	{
		new QuizCardBuilder().go();
	}
	
	public void go()
	{
		frame = new JFrame("Quiz Card Builder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		
		question = createTextArea(bigFont);
		JScrollPane qScroller = createScroller(question);
		answer = createTextArea(bigFont);
		JScrollPane aScroller = createScroller(answer);
		
		mainPanel.add(new JLabel("Question:"));
		mainPanel.add(qScroller);
		mainPanel.add(new JLabel("Answer:"));
		mainPanel.add(aScroller);
		
		JButton nextButton = new JButton("Next Card");
		nextButton.addActionListener(e -> nextCard());
		mainPanel.add(nextButton);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(e -> clearAll());
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(e -> saveCard());
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500, 600);
		frame.setVisible(true);
	}
	
	private void saveFile(File file)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (QuizCard card : cardList)
			{
				writer.write(card.getQuestion() + "/");
				writer.write(card.getAnswer() + "\n");
			}
			writer.close();
		} catch (IOException ex) {
			System.out.println("Couldn't write the cardList out: " + ex.getMessage());
		}
	}
	
	private void saveCard()
	{
		if (!question.getText().equals("") && !answer.getText().equals(""))
		{
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);
		}
		
		if (cardList.isEmpty()) { return; }
		
		JFileChooser fileSave = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовый документ", "txt");
		fileSave.setFileFilter(filter);
		fileSave.showSaveDialog(frame);
		saveFile(fileSave.getSelectedFile());
	}
	
	private void clearAll()
	{
		cardList.clear();
		clearCard();
	}
	
	private void clearCard()
	{
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}
	
	private void nextCard()
	{
		QuizCard card = new QuizCard(question.getText(), answer.getText());
		cardList.add(card);
		clearCard();
	}
	
	private JTextArea createTextArea(Font font)
	{
		JTextArea textArea = new JTextArea(6, 20);
		textArea.setLineWrap(true); //If set to true the lines will be wrapped if they are too long to fit within the allocated width.
		textArea.setWrapStyleWord(true); //If set to true the lines will be wrapped at word boundaries (whitespace) if they are too long to fit within the allocated width.
		textArea.setFont(font);
		return textArea;
	}
	
	private JScrollPane createScroller(JTextArea textArea)
	{
		JScrollPane scroller = new JScrollPane(textArea); //JScrollPane как обёртка для JTextArea
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		return scroller;
	}
}