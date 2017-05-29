import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiskCreationDialog extends JDialog
{
	private JPanel ShopPanel;
	private JPanel AddressPanel;
	private JPanel DiskCapacityPanel;
	private JPanel MainPanel;
	private JPanel DiskButtons;
	
	private JLabel ShopLabel;
	private JLabel AddressLabel;
	private JLabel DiskCapacityLabel;
	private static JTextField ShopField;
	private static JTextField AddressField;
	private static JTextField DiskCapacityField;
	
	
	private static JButton ConfirmButton;
	private static JButton AddElectroButton;
	private static JButton AddOperaButton;
	
	private static ElectroCreationDialog ECD;
	private static OperaCreationDialog OCD;
	private static Assembly result;
	
	DiskCreationDialog()
	{
		result = new Assembly();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		ShopLabel = new JLabel("Диск купплен в магазине: ");
		AddressLabel = new JLabel("Адрес магазина: ");
		DiskCapacityLabel = new JLabel("Вместимость диска: ");
		ShopField = new JTextField("МП3 у Петровича",25);
		AddressField = new JTextField("Красноярск",25);
		DiskCapacityField = new JTextField("7800",25);
		ShopLabel.setLabelFor(ShopField);
		AddressLabel.setLabelFor(AddressField);
		DiskCapacityLabel.setLabelFor(DiskCapacityField);
		
		ShopPanel = new JPanel();
		ShopPanel.add(ShopLabel);
		ShopPanel.add(ShopField);
		
		AddressPanel = new JPanel();
		AddressPanel.add(AddressLabel);
		AddressPanel.add(AddressField);
		
		DiskCapacityPanel = new JPanel();
		DiskCapacityPanel.add(DiskCapacityLabel);
		DiskCapacityPanel.add(DiskCapacityField);
		
		AddElectroButton = new JButton("Добавить электро");
		AddOperaButton = new JButton("Добавить оперу");
		DiskButtons = new JPanel();
		DiskButtons.add(AddElectroButton);
		DiskButtons.add(AddOperaButton);
		
		NewElectroListener NEL = new NewElectroListener();
		AddElectroButton.addActionListener(NEL);
		NewOperaListener NOL = new NewOperaListener();
		AddOperaButton.addActionListener(NOL);
		
		ConfirmButton = new JButton("Добавить!");
		DialogConfirmListener DCL = new DialogConfirmListener();
		ConfirmButton.addActionListener(DCL);
		
		MainPanel = new JPanel();
		MainPanel.setLayout(new BoxLayout(MainPanel,BoxLayout.Y_AXIS));
		MainPanel.add(ShopPanel);
		MainPanel.add(AddressPanel);
		MainPanel.add(DiskCapacityPanel);
		MainPanel.add(DiskButtons);
		MainPanel.add(ConfirmButton);
		
		this.setModal(true);
		this.getContentPane().add(MainPanel);
		this.setTitle("Добавление диска");
		this.setSize(500, 250);
		this.setLocation(300, 350);
	}
	private static int getMoney()
	{
		String money = JOptionPane.showInputDialog("Введите корректную вместимость!");
		int result = 0;
		try
		{
			result = Integer.parseInt(money);
		}
		catch (Exception Ex)
		{
			return getMoney();
		}
		return result;
	}
	public static Assembly getData()
	{
		result.setShop(ShopField.getText());
		result.setAddress(AddressField.getText());
		int money = 0;
		try
		{
			money = Integer.parseInt(DiskCapacityField.getText());
		}
		catch(Exception Ex)
		{
			money = getMoney();
		}
		result.setCapacity(money);
		return result;
	}
	public static void ElectroAdded()
	{
		int money = 0;
		try
		{
			money = Integer.parseInt(DiskCapacityField.getText());
		}
		catch(Exception Ex)
		{
			money = getMoney();
		}
		result.setCapacity(money);
		ECD = new ElectroCreationDialog();
		ECD.setVisible(true);
	}
	public static void OperaAdded()
	{
		OCD = new OperaCreationDialog();
		OCD.setVisible(true);
	}
	public static void ElectroConfirmed()
	{
		ECD.setVisible(false);
		Electro NewElectro = ElectroCreationDialog.getData();
		if(result.getTotalDuration() + NewElectro.getDuration() < result.getCapacity())
		{
			result.addComposition(NewElectro);
			JOptionPane.showMessageDialog(AddElectroButton,"Трек добавлен!");
		}
		else
			JOptionPane.showMessageDialog(AddElectroButton,"Трек не добавлен, мало места!");

	}
	public static void OperaConfirmed()
	{
		OCD.setVisible(false);
		Opera NewOpera = OperaCreationDialog.getData();
		if(result.getTotalDuration() + NewOpera.getDuration() < result.getCapacity())
		{
			result.addComposition(NewOpera);
			JOptionPane.showMessageDialog(AddElectroButton,"Опера добавлена!");
		}
		else
			JOptionPane.showMessageDialog(AddElectroButton,"Опера не добавлена, мало места!");
	}
}
