import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiskChangeDialog extends JDialog
{
	private JPanel ShopPanel;
	private JPanel AdressPanel;
	private JPanel DiskCapacityPanel;
	private JPanel MainPanel;

	
	private JLabel ShopLabel;
	private JLabel AdressLabel;
	private JLabel DiskCapacityLabel;
	private static JTextField ShopField;
	private static JTextField AdressField;
	private static JTextField DiskCapacityField;
	
	
	private static JButton CondiskButton;
	
	private static Assembly result;
	
	DiskChangeDialog(Assembly disk)
	{
		result = disk;
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		ShopLabel = new JLabel("Диск купплен в магазине: ");
		AdressLabel = new JLabel("Адрес магазина: ");
		DiskCapacityLabel = new JLabel("Вместимость диска: ");
		ShopField = new JTextField(disk.getShop(),25);
		AdressField = new JTextField(disk.getAddress(),25);
		DiskCapacityField = new JTextField(String.valueOf(disk.getCapacity()),6);
		ShopLabel.setLabelFor(ShopField);
		AdressLabel.setLabelFor(AdressField);
		DiskCapacityLabel.setLabelFor(DiskCapacityField);
		
		ShopPanel = new JPanel();
		ShopPanel.add(ShopLabel);
		ShopPanel.add(ShopField);
		
		AdressPanel = new JPanel();
		AdressPanel.add(AdressLabel);
		AdressPanel.add(AdressField);
		
		DiskCapacityPanel = new JPanel();
		DiskCapacityPanel.add(DiskCapacityLabel);
		DiskCapacityPanel.add(DiskCapacityField);
		
		
		CondiskButton = new JButton("Изменить!");
		ConfirmDiskChangeListener CDCL = new ConfirmDiskChangeListener();
		CondiskButton.addActionListener(CDCL);
		
		MainPanel = new JPanel();
		MainPanel.setLayout(new BoxLayout(MainPanel,BoxLayout.Y_AXIS));
		MainPanel.add(ShopPanel);
		MainPanel.add(AdressPanel);
		MainPanel.add(DiskCapacityPanel);
		MainPanel.add(CondiskButton);
		
		this.setModal(true);
		this.getContentPane().add(MainPanel);
		this.setTitle("Изменение диска");
		this.setSize(500, 250);
		this.setLocation(300, 350);
	}
	private static int getcapacity()
	{
		String capacity = JOptionPane.showInputDialog("Введите корректную вместимость!");
		int result = 0;
		try
		{
			result = Integer.parseInt(capacity);
			if(result < 0)
				result = getcapacity();
		}
		catch (Exception Ex)
		{
			return getcapacity();
		}
		return result;
	}
	public static void getData()
	{
		result.setShop(ShopField.getText());
		result.setAddress(AdressField.getText());
		int capacity = 0;
		try
		{
			capacity = Integer.parseInt(DiskCapacityField.getText());
			if(capacity <= 0)
				capacity = getcapacity();
		}
		catch(Exception Ex)
		{
			capacity = getcapacity();
		}
		if(capacity >= result.getTotalDuration())
			result.setCapacity(capacity);
		else
			JOptionPane.showMessageDialog(DiskCapacityField,"Вместимость слишком мала!");
	}
}