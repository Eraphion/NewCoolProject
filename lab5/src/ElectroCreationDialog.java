import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ElectroCreationDialog extends JDialog
{	
	private JPanel MainPanel;
	private JPanel NamePanel;
	private JPanel DurationPanel;
	private JPanel AgePanel;
	private JPanel InstrumentsPanel;
	private ButtonGroup SpeciailPanel;
	
	private JLabel NameLabel;
	private JLabel DurationLabel;
	private JLabel AgeLabel;
	private JLabel InstrumentsLabel;
	private JLabel SpeciailLabel;
	
	private static JRadioButton RB1;
	private static JRadioButton RB2;
	private static JButton ConfirmButton;
	
	private static JTextField NameField;
	private static JTextField DurationField;
	private static JTextField AgeField;
	private static JTextField InstrumentsField;
	
	ElectroCreationDialog()
	{
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		NamePanel = new JPanel();
		DurationPanel = new JPanel();
		AgePanel = new JPanel();
		InstrumentsPanel = new JPanel();
		SpeciailPanel = new  ButtonGroup();
		
		RB1 = new JRadioButton("Да");
		RB2 = new JRadioButton("Нет");
		SpeciailPanel.add(RB1);
		SpeciailPanel.add(RB2);
	
		
		NameLabel = new JLabel("Имя композиции: ");
		DurationLabel = new JLabel("Продолжительность (в секундах): ");
		AgeLabel = new JLabel("Год создания: ");
		InstrumentsLabel = new JLabel("Главный инструмент: " );
		SpeciailLabel = new JLabel("Есть ли спец.эффекты?");
		
		NameField = new JTextField("Armin Van Buuren - Mirage", 25);
		DurationField = new JTextField("340", 4);
		AgeField = new JTextField("2001", 4);
		InstrumentsField = new JTextField("violin", 10);
		
		ConfirmButton = new JButton("Добавить!");
		ElectroButtonListener EBL = new ElectroButtonListener();
		ConfirmButton.addActionListener(EBL);
		
		RB1.setSelected(false);
		RB2.setSelected(true);
		
		MainPanel = new JPanel();
		MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
		NamePanel.add(NameLabel);
		NamePanel.add(NameField);
		DurationPanel.add(DurationLabel);
		DurationPanel.add(DurationField);
		AgePanel.add(AgeLabel);
		AgePanel.add(AgeField);
		InstrumentsPanel.add(InstrumentsLabel);
		InstrumentsPanel.add(InstrumentsField);
		
		MainPanel.add(NamePanel);
		MainPanel.add(InstrumentsPanel);
		MainPanel.add(AgePanel);
		MainPanel.add(DurationPanel);
		MainPanel.add(SpeciailLabel);
		MainPanel.add(RB1);
		MainPanel.add(RB2);
		MainPanel.add(ConfirmButton);
		
		this.getContentPane().add(MainPanel);
		this.setModal(true);
		this.setTitle("Доблавение электро");
		this.setSize(500, 300);
		this.setLocation(300, 350);
		this.setResizable(false);
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
	public static Electro getData()
	{
		Electro result = new Electro();
		result.setName(NameField.getText());
		if(RB1.isSelected())
			result.setSpecialEffects(true);
		else
			result.setSpecialEffects(false);
		result.setMainInstrument(InstrumentsField.getText());
		String str = AgeField.getText();
		int age = 0;
		try
		{
			age = Integer.parseInt(str);
		}
		catch(Exception Ex)
		{
			age = getInt("Введите корретный год!");
		}
		int Duration = 0;
		str = DurationField.getText();
		try
		{
			Duration = Integer.parseInt(str);
		}
		catch(Exception Ex)
		{
			Duration = getInt("Введите корректную продолжительность!");
		}
		result.setCreationYear(age);
		result.setDuration(Duration);
		return result;
	}
}
