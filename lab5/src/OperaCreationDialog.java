import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperaCreationDialog extends JDialog
{
	private JPanel MainPanel;
	private JPanel NamePanel;
	private JPanel DurationPanel;
	private JPanel ClassicEraPanel;
	private JPanel YearPanel;
	
	private static  JButton ConfirmButton;
	
	private JLabel NameLabel;
	private JLabel DurationLabel;
	private JLabel ClassicEraLabel;
	private JLabel YearLabel;
	
	private static JTextField NameField;
	private static JTextField DurationField;
	private static JTextField ClassicEraField;
	private static JTextField YearField;
	
	
	OperaCreationDialog()
	{
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		MainPanel = new JPanel();
		MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
		NamePanel = new JPanel();
		DurationPanel = new JPanel();
		ClassicEraPanel = new JPanel();
		YearPanel = new JPanel();
		MainPanel.add(NamePanel);
		MainPanel.add(DurationPanel);
		MainPanel.add(ClassicEraPanel);
		MainPanel.add(YearPanel);
		ConfirmButton = new JButton("Добавить!");
		OperaButtonListener VBL = new OperaButtonListener();
		ConfirmButton.addActionListener(VBL);
		MainPanel.add(ConfirmButton);
		this.getContentPane().add(MainPanel);
		this.setModal(true);
		this.setTitle("Добавление оперы");
		this.setSize(550, 200);
		this.setLocation(300, 350);
		this.setResizable(false);
		
		NameLabel = new JLabel("Введите название: ");
		DurationLabel = new JLabel("Введите продолжительность: ");
		ClassicEraLabel = new JLabel("Эра оперы: ");
		YearLabel = new JLabel("Год создания: ");
		NameField = new JTextField("Rigoletto", 25);
		DurationField = new JTextField("3670",5);
		ClassicEraField = new JTextField("Romanism",12);
		YearField = new JTextField("1703",4);
		
		NamePanel.add(NameLabel);
		NamePanel.add(NameField);
		DurationPanel.add(DurationLabel);
		DurationPanel.add(DurationField);
		ClassicEraPanel.add(ClassicEraLabel);
		ClassicEraPanel.add(ClassicEraField);
		YearPanel.add(YearLabel);
		YearPanel.add(YearField);
	}
	private static  int getInt(String Message)
	{
		String age = JOptionPane.showInputDialog(Message);
		int result = 0;
		try
		{
			result = Integer.parseInt(age);
		}
		catch (Exception Ex)
		{
			return getInt(Message);
		}
		return result;
	}
	public static Opera getData()
	{
		Opera result = new Opera();
		result.setName(NameField.getText());
		String str = DurationField.getText();
		int Duration = 0 ;
		try{
			Duration = Integer.parseInt(str);
		}
		catch(Exception Ex)
		{
			Duration = getInt("Введите корректную продолжительность!");
		}
		
		
		
		str = YearField.getText();
		int Year = 0;
		try
		{
			Year = Integer.parseInt(str);
		}
		catch(Exception Ex)
		{
			Year = getInt("Введите корретный год!");
		}
		result.setClassicEra(ClassicEraField.getText());
		result.setDuration(Duration);
		result.setCreationYear(Year);
		return result;
	}
}
