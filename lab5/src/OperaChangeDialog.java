import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperaChangeDialog extends JDialog
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
	
	private static Opera result;
	
	OperaChangeDialog(Opera opera)
	{
		result = opera;
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
		ConfirmButton = new JButton("Изменить!");
		ConfirmOperaChangeListener CVCL = new ConfirmOperaChangeListener();
		ConfirmButton.addActionListener(CVCL);
		MainPanel.add(ConfirmButton);
		this.getContentPane().add(MainPanel);
		this.setModal(true);
		this.setTitle("Изменение оперы");
		this.setSize(550, 200);
		this.setLocation(300, 350);
		this.setResizable(false);
		
		NameLabel = new JLabel("Введите название: ");
		DurationLabel = new JLabel("Введите продолжительность: ");
		ClassicEraLabel = new JLabel("Эра оперы: ");
		YearLabel = new JLabel("Год создания: ");
		
		NameField = new JTextField(result.getName(), 25);
		DurationField = new JTextField(String.valueOf(result.getDuration()),5);
		ClassicEraField = new JTextField(result.getClassicEra(),12);
		YearField = new JTextField(String.valueOf(result.getCreationYear()),4);
		
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
	public static void getData()
	{
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
		Assembly cur = Graphics.getCurrent();
		int prev = result.getDuration();
		result.setClassicEra(ClassicEraField.getText());
		result.setDuration(Duration);
		if(cur.getTotalDuration() > cur.getCapacity())
		{
			result.setDuration(prev);
			JOptionPane.showMessageDialog(DurationField,"Вместимость слишком мала!");
		}
		result.setCreationYear(Year);
	}
}
