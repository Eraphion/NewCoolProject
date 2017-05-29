import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Graphics extends JFrame 
{
	private JPanel DisksPanel;
	private JPanel InfoPanel;
	private JPanel ElectroPanel;
	private JPanel OperaPanel;
	private JPanel MainPanel;
	private JPanel FunctionsPanel;
	
	private JPanel DisksButtons;
	private JPanel OperaButtons;
	private JPanel ElectroButtons;
	
	private static ArrayList<Assembly> disks;
	private static ArrayList<Electro> electro;
	private static ArrayList<Opera> opera;
	
	private static JList disksList; 
	private static JList electroList; 
	private static JList operaList; 
	private JScrollPane disksScroll;
	private JScrollPane electroScroll;
	private JScrollPane operaScroll;
	
	private static JButton ClearButton;
	private static JButton AddDiskButton;
	private static JButton ShowInfoButton;
	private static JButton ConfirmAddressButton;
	
	private static JButton diskshowButton;
	private static JButton DiskRemoveButton;
	private static JButton DiskChangeButton;
	
	private static JButton operahowButton;
	private static JButton OperaChangeButton;
	private static JButton OperaRemoveButton;
	
	private static JButton electrohowButton;
	private static JButton ElectroChangeButton;
	private static JButton ElectroRemoveButton;
	
	
	private JLabel SourceLabel;
	private JLabel disksLabel;
	private JLabel electroLabel;
	private JLabel operaLabel;
	private static JTextField Source;
	
	private static String Path;
	
	private static DiskCreationDialog DCD;
	private static DiskChangeDialog DChD;
	private static ElectroChangeDialog ECD;
	private static OperaChangeDialog OCD;
	

Graphics()
{
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	DisksPanel = new JPanel();
	DisksPanel.setLayout(new BorderLayout());
	InfoPanel = new JPanel();
	OperaPanel = new JPanel();
	OperaPanel.setLayout(new BorderLayout());
	ElectroPanel = new JPanel();
	ElectroPanel.setLayout(new BorderLayout());
	MainPanel = new JPanel();
	FunctionsPanel = new JPanel();
	MainPanel.setLayout(new BorderLayout());
	MainPanel.add(DisksPanel,BorderLayout.WEST);
	MainPanel.add(ElectroPanel, BorderLayout.CENTER);
	MainPanel.add(OperaPanel,BorderLayout.EAST);
	MainPanel.add(InfoPanel, BorderLayout.SOUTH);
	MainPanel.add(FunctionsPanel, BorderLayout.NORTH);
	

	DisksButtons = new JPanel();
	DisksButtons.setLayout(new BoxLayout(DisksButtons,BoxLayout.Y_AXIS));
	diskshowButton = new JButton("О диске");
	DiskChangeButton = new JButton("Перезаписать");
	DiskRemoveButton = new JButton("Удалить");
	DisksButtons.add(diskshowButton);
	DisksButtons.add(DiskChangeButton);
	DisksButtons.add(DiskRemoveButton);
	
	ElectroButtons = new JPanel();
	ElectroButtons.setLayout(new BoxLayout(ElectroButtons,BoxLayout.Y_AXIS));
	electrohowButton = new JButton("Подробнее о...");
	ElectroChangeButton = new JButton("Изменить");
	ElectroRemoveButton = new JButton("Удалить");
	ElectroButtons.add(electrohowButton);
	ElectroButtons.add(ElectroChangeButton);
	ElectroButtons.add(ElectroRemoveButton);
	
	OperaButtons = new JPanel();
	OperaButtons.setLayout(new BoxLayout(OperaButtons,BoxLayout.Y_AXIS));
	operahowButton = new JButton("Подробнее о...");
	OperaChangeButton = new JButton("Изменить");
	OperaRemoveButton = new JButton("Удалить");
	OperaButtons.add(operahowButton);
	OperaButtons.add(OperaChangeButton);
	OperaButtons.add(OperaRemoveButton);
	
	diskshowButton.setEnabled(false);
	DiskRemoveButton.setEnabled(false);
	DiskChangeButton.setEnabled(false);
	operahowButton.setEnabled(false);
	OperaChangeButton.setEnabled(false);
	OperaRemoveButton.setEnabled(false);
	electrohowButton.setEnabled(false);
	ElectroChangeButton.setEnabled(false);
	ElectroRemoveButton.setEnabled(false);
	
	AddDiskButton = new JButton("Добавить диск");
	FunctionsPanel.add(AddDiskButton);
	ShowInfoButton = new JButton("Информация по дискам");
	ShowInfoListener SIL = new ShowInfoListener();
	ShowInfoButton.addActionListener(SIL);
	FunctionsPanel.add(ShowInfoButton);
	ClearButton = new JButton("Сжечь все архивы");
	FunctionsPanel.add(ClearButton);
	ClearButton.setEnabled(false);
	AddDiskButton.setEnabled(false);
	ShowInfoButton.setEnabled(false);
	ClearButtonListener ClBL = new ClearButtonListener();
	ClearButton.addActionListener(ClBL);
	AddDiskListener ADL = new AddDiskListener();
	AddDiskButton.addActionListener(ADL);
	
	SourceLabel = new JLabel("Открыть (создать) файл с дисками: ");
	Source = new JTextField("C:\\Users\\Eugene\\Desktop");
	InfoPanel.add(SourceLabel);
	InfoPanel.add(Source);
	SourceLabel.setLabelFor(Source);
	Source.setPreferredSize(new Dimension(300,20));
	ConfirmAddressButton = new JButton("Готово!");
	InfoPanel.add(ConfirmAddressButton);
	ConfirmButtonListener CBL = new ConfirmButtonListener();
	ConfirmAddressButton.addActionListener(CBL);
	
	this.setTitle("Made by Trusov E.D.");
	this.setLocation(200, 300);
	this.setSize(900, 640);
	this.setResizable(false);
	this.getContentPane().add(MainPanel);
	
	disksList = new JList();
	disksLabel = new JLabel("Диски: ");
	disksLabel.setLabelFor(disksList);
	disksLabel.setPreferredSize(new Dimension(300,20));
	DisksPanel.add(disksLabel, BorderLayout.NORTH);
	
	electroList = new JList();
	electroLabel = new JLabel("Электро-музыка: ");
	electroLabel.setLabelFor(electroList);
	ElectroPanel.add(electroLabel, BorderLayout.NORTH);
	
	operaList = new JList();
	operaLabel = new JLabel("Оперы: ");
	operaLabel.setLabelFor(operaList);
	operaLabel.setPreferredSize(new Dimension(300,20));
	OperaPanel.add(operaLabel, BorderLayout.NORTH);
	
	disksScroll = new JScrollPane();
	electroScroll = new JScrollPane();
	operaScroll = new JScrollPane();
	disksScroll.getViewport().add(disksList);
	electroScroll.getViewport().add(electroList);
	operaScroll.getViewport().add(operaList);
	
	DisksPanel.add(disksScroll, BorderLayout.CENTER);
	ElectroPanel.add(electroScroll, BorderLayout.CENTER);
	OperaPanel.add(operaScroll, BorderLayout.CENTER);
	
	DisksPanel.add(DisksButtons, BorderLayout.SOUTH);
	ElectroPanel.add(ElectroButtons, BorderLayout.SOUTH);
	OperaPanel.add(OperaButtons, BorderLayout.SOUTH);
	
	DiskListListener DLL = new DiskListListener();
	disksList.addListSelectionListener(DLL);
	
	ElectroListListener ELL = new ElectroListListener();
	electroList.addListSelectionListener(ELL);
	OperaListListener OLL = new OperaListListener();
	operaList.addListSelectionListener(OLL);
	
	disksList.setBackground(new Color(140,140,140));
	electroList.setBackground(new Color(140,140,140));
	operaList.setBackground(new Color(140,140,140));
	disksList.setSelectionBackground(new Color(200,0,200));
	operaList.setSelectionBackground(new Color(200,0,200));
	electroList.setSelectionBackground(new Color(200,0,200));
	disksList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
	operaList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
	electroList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
	Font font = new Font("Tahoma",Font.BOLD|Font.ITALIC,16);
	disksList.setFont(font);
	operaList.setFont(font);
	electroList.setFont(font);
	
	
	
	DiskShowListener DSL = new DiskShowListener();
	diskshowButton.addActionListener(DSL);
	ElectroShowListener ESL = new ElectroShowListener();
	electrohowButton.addActionListener(ESL);
	OperaShowListener OSL = new OperaShowListener();
	operahowButton.addActionListener(OSL);
	
	DiskRemoveListener RRL = new DiskRemoveListener();
	DiskRemoveButton.addActionListener(RRL);
	ElectroRemoveListener ERL = new ElectroRemoveListener();
	ElectroRemoveButton.addActionListener(ERL);
	OperaRemoveListener ORL = new OperaRemoveListener();
	OperaRemoveButton.addActionListener(ORL);
	
	ChangeDiskListener CDL = new ChangeDiskListener();
	DiskChangeButton.addActionListener(CDL);
	ChangeElectroListener CEL = new ChangeElectroListener();
	ElectroChangeButton.addActionListener(CEL);
	ChangeOperaListener COL = new ChangeOperaListener();
	OperaChangeButton.addActionListener(COL);
}
public static void ConfirmButtonPushed()
{
	Path = Source.getText();
	Path += "\\data.lab5";
	StringAsClass Report = new StringAsClass();
	disks = ObjectWorker.ReadFromFile(Path,Report);
	if(Report.str != null)
		JOptionPane.showMessageDialog(Source, Report.str);
	if(disks == null)
		disks = new ArrayList<Assembly> ();
	disksList.setListData(disks.toArray());
	ClearButton.setEnabled(true);
	AddDiskButton.setEnabled(true);
	ShowInfoButton.setEnabled(true);
}
public static void ClearButtonPushed()
{
	StringAsClass Report = new StringAsClass();
	ObjectWorker.ClearFile(Path,Report);
	if(Report.str != null)
		JOptionPane.showMessageDialog(ClearButton, Report.str);
	disks = new ArrayList<Assembly> ();
	disksList.setListData(disks.toArray());
}
public static void DialogConfirmed()
{
	DCD.setVisible(false);
	 Assembly NewDisk = DiskCreationDialog.getData();
	disks = ObjectWorker.ReadFromFile(Path, new StringAsClass());
	if(disks == null)
		disks = new ArrayList<Assembly>();
	disks.add(NewDisk);
	StringAsClass Report = new StringAsClass();
	ObjectWorker.SaveObjects(Path,disks,Report);
	if(Report.str != null)
		JOptionPane.showMessageDialog(AddDiskButton, Report.str);
	try
	{
		disksList.setListData(disks.toArray());
		disksList.setSelectedIndex(0);
	}
	catch(Exception Ex)
	{
		disksList.setSelectedIndex(0);
		return;
	}
}
public static void AddDiskButtonPushed()
{
	DCD = new DiskCreationDialog();
	DCD.setVisible(true);
}
public static void ChangeDiskButtonPushed()
{
	DChD = new DiskChangeDialog(disks.get(disksList.getSelectedIndex()));
	DChD.setVisible(true);
}
public static void DiskChanged()
{
	DChD.setVisible(false);
	DChD.getData();
	ObjectWorker.SaveObjects(Path, disks, new StringAsClass());
	JOptionPane.showMessageDialog(DiskChangeButton, "Диск успешно перезаписан!");
	try
	{
		disksList.setListData(disks.toArray());
		disksList.setSelectedIndex(0);
	}
	catch(Exception Ex)
	{
		disksList.setSelectedIndex(0);
		return;
	}
}
public static void ChangeElectroButtonPushed()
{
	ECD = new ElectroChangeDialog(disks.get(disksList.getSelectedIndex()).getElectroByIndex(electroList.getSelectedIndex()));
	ECD.setVisible(true);
	
}
public static void ElectroChanged()
{
	ECD.setVisible(false);
	ECD.getData();
	ObjectWorker.SaveObjects(Path, disks, new StringAsClass());
	JOptionPane.showMessageDialog(ElectroChangeButton, "Электро изменено!");
	try
	{
		disksList.setListData(disks.toArray());
		disksList.setSelectedIndex(0);
	}
	catch(Exception Ex)
	{
		disksList.setSelectedIndex(0);
		return;
	}
}
public static void ChangeOperaButtonPushed()
{
	OCD = new OperaChangeDialog(disks.get(disksList.getSelectedIndex()).getOperaByIndex(operaList.getSelectedIndex()));
	OCD.setVisible(true);
	
}
public static void OperaChanged()
{
	OCD.setVisible(false);
	OCD.getData();
	ObjectWorker.SaveObjects(Path, disks, new StringAsClass());
	JOptionPane.showMessageDialog(OperaChangeButton, "Опера изменена!");
	try
	{
		disksList.setListData(disks.toArray());
		disksList.setSelectedIndex(0);
	}
	catch(Exception Ex)
	{
		disksList.setSelectedIndex(0);
		return;
	}
}
public static void ListSelected()
{
	Assembly cur = null;
	if(disksList.getSelectedIndex() !=-1)
	{
		diskshowButton.setEnabled(true);
		DiskRemoveButton.setEnabled(true);
		DiskChangeButton.setEnabled(true);
		cur = (Assembly) disksList.getSelectedValue();
	}
	else
	{
		diskshowButton.setEnabled(false);
		DiskRemoveButton.setEnabled(false);
		DiskChangeButton.setEnabled(false);
		cur = new Assembly();
	}
	operaList.setListData(cur.getAllOpera().toArray());
	electroList.setListData(cur.getAllElectro().toArray());
}
public static void ShowInfoPushed()
{
	String Report = "";
	disks = ObjectWorker.ReadFromFile(Path, new StringAsClass());
	if(disks == null)
	{
		JOptionPane.showMessageDialog(ShowInfoButton, "Нет дисков для показа!");
		return;
	}
	int total = 0;
	Report+=("В архиве дисков: " + disks.size()  +"\r\n");
	for(int i = 0 ; i < disks.size(); i++)
	{
		Assembly Disk = disks.get(i);
		total+=disks.get(i).getTotalDuration();
		Report+=("\t\t*** INFORMATION ABOUT DISK: ***\t\t"+"\r\n");
		Report+=("COMPOSITIONS BURNED ON THE DISK: " + Disk.getSize()+"\r\n");
		Report+=("Продолжительность композиций на диске:" + disks.get(i).getTotalDuration() + "\r\n");
		for(int j = 0; j < Disk.getSize(); j++)
		{
			Report+=("Composition's name: " + Disk.getElement(j).getName()+"\r\n");
			Report+=("Compositions' duration: " + AbstractMusic.ShowDuration(Disk.getElement(j).getDuration())+"\r\n");
			Report+=("Composition's creation year: " + Disk.getElement(j).getCreationYear()+"\r\n");
			Report+=("Additional information about this composition: "+"\r\n" );
			Report+=(Disk.getElement(j).getAdditionalInfo()+"\r\n");
			if(j != Disk.getSize()- 1)
				Report+=("\n************************************\n");
		}
		Report+=("ИТОГО ПРОДОЛЖИТЕЛЬНОСТЬ: " + total + " секунд " + "\r\n");
		Report+=("*************************************\r\n*************************************\r\n");
	}
	Report rep = new Report(Report);
	rep.setVisible(true);
}
public static void ElectroListSelected()
{
	if(electroList.getSelectedIndex()==-1)
	{
		ElectroRemoveButton.setEnabled(false);
		ElectroChangeButton.setEnabled(false);
		electrohowButton.setEnabled(false);
	}
	else
	{
		ElectroRemoveButton.setEnabled(true);
		ElectroChangeButton.setEnabled(true);
		electrohowButton.setEnabled(true);
	}
}
public static void OperaListSelected()
{
	if(operaList.getSelectedIndex()==-1)
	{
		OperaRemoveButton.setEnabled(false);
		OperaChangeButton.setEnabled(false);
		operahowButton.setEnabled(false);
	}
	else
	{
		OperaRemoveButton.setEnabled(true);
		OperaChangeButton.setEnabled(true);
		operahowButton.setEnabled(true);
	}
}


public static void ShowDisk()
{
	String out = "";
	Assembly Disk = (Assembly) disksList.getSelectedValue();
	out+="Куплен в: " + Disk.getShop() + "\n";
	out+="Адрес магазина: " + Disk.getAddress() + "\n";
	out+="Вместимость в секундах: " + Disk.getCapacity() + "\n";
	out+="Электро треков записано: " + Disk.getElectroSize() + "\n";
	out+="Опер на диске: " + Disk.getOperaSize() + "\n";
	out+="Продолжительность композиций на диске: " + Disk.getTotalDuration() + "\n";
	JOptionPane.showMessageDialog(diskshowButton, out);
}
public static void ShowElectro()
{
	String out = "";
	Electro Electro = (Electro) electroList.getSelectedValue();
	out+="Название композиции: " + Electro.getName()+ "\n";
	out+="Основной инструмент: " + Electro.getMainInstrument() + "\n";
	out+="Продолжительность в секундах: " + Electro.getDuration()+ "\n";
	out+="Трек создан в : " + Electro.getCreationYear() + "\n";
	if(Electro.hasSpecialEffects())
		out+="Есть спец. эффекты";
	else
		out+="Спец. эффектов нет";
	JOptionPane.showMessageDialog(electrohowButton, out);
}
public static void ShowOpera()
{
	String out = "";
	Opera Opera = (Opera) operaList.getSelectedValue();
	out+="Название оперы " + Opera.getName()+ "\n";
	out+="Длительность в секундах: " + Opera.getDuration()+ "\n";
	out+="Эра оперы: " + Opera.getClassicEra() + "\n";
	out+="Создана в : " + Opera.getCreationYear();
	JOptionPane.showMessageDialog(operahowButton, out);
}
public static void RemoveDisk()
{
	disks = ObjectWorker.ReadFromFile(Path, new StringAsClass());
	disks.remove(disksList.getSelectedIndex());
	if(disks.size() > 0)
		ObjectWorker.SaveObjects(Path, disks, new StringAsClass());
	else
		ObjectWorker.ClearFile(Path, new StringAsClass());
	JOptionPane.showMessageDialog(DiskRemoveButton, "Диск уничтожен!");
	try
	{
		disksList.setListData(disks.toArray());
		disksList.setSelectedIndex(0);
	}
	catch(Exception Ex)
	{
		disksList.setSelectedIndex(0);
		return;
	}
}
public static void RemoveElectro()
{
	disks = ObjectWorker.ReadFromFile(Path, new StringAsClass());
	disks.get(disksList.getSelectedIndex()).removeElectroByIndex(electroList.getSelectedIndex());
	ObjectWorker.SaveObjects(Path, disks, new StringAsClass());
	JOptionPane.showMessageDialog(ElectroRemoveButton, "Трек удален с диска!");
	try
	{
		disksList.setListData(disks.toArray());
		disksList.setSelectedIndex(0);
	}
	catch(Exception Ex)
	{
		disksList.setSelectedIndex(0);
		return;
	}
}
public static void RemoveOpera()
{
	disks = ObjectWorker.ReadFromFile(Path, new StringAsClass());
	disks.get(disksList.getSelectedIndex()).removeOperaByIndex(operaList.getSelectedIndex());
	ObjectWorker.SaveObjects(Path, disks, new StringAsClass());
	JOptionPane.showMessageDialog(OperaRemoveButton, "Опера удалена с диска!");
	try
	{
		disksList.setListData(disks.toArray());
		disksList.setSelectedIndex(0);
	}
	catch(Exception Ex)
	{
		disksList.setSelectedIndex(0);
		return;
	}
}
public static Assembly getCurrent()
{
	return disks.get(disksList.getSelectedIndex());
}
}
