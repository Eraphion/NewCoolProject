import java.io.Serializable;
import java.util.ArrayList;

public class Assembly implements Serializable
{
	private ArrayList<AbstractMusic> disk;
	private String shop;
	private String address;
	private int capacity;

	private ArrayList<Opera> OperaList;
	private ArrayList<Electro> ElectroList;
	Assembly()
	{
		disk = new ArrayList<AbstractMusic> ();
		OperaList = new ArrayList<Opera>();
		ElectroList = new ArrayList<Electro>();
	}
	public String getShop()
	{
		return shop;
	}
	public String getAddress()
	{
		return address;
	}
	public int getCapacity()
	{
		return capacity;
	}
	public void setShop(String Shop)
	{
		shop = Shop;
	}
	public void setAddress(String Address)
	{
		address = Address;
	}
	public void setCapacity(int Capacity)
	{
		capacity = Capacity;
	}
	public void addComposition(AbstractMusic composition)
	{
		disk.add(composition);
		if(composition.getClass().getName()=="Opera")
			OperaList.add((Opera)composition);
		else
			ElectroList.add((Electro)composition);
	}
	public void removeComposition(int index)
	{
		disk.remove(index);
	}
	public void removeAllCompositions()
	{
		disk.clear();
	}
	public int getTotalDuration()
	{
		int result = 0;
		for(int i = 0; i < disk.size(); i++)
			result+=disk.get(i).getDuration();
		return result;
	}
	public AbstractMusic getElement(int index)
	{
		return disk.get(index);
	}
	public ArrayList<AbstractMusic> getDisk()
	{
		return disk;
	}
	public void showInfo()
	{
		System.out.println("\t\t*** INFORMATION ABOUT DISK: ***\t\t");
		System.out.println("COMPOSITIONS BURNED ON THE DISK: " + disk.size());
		for(int i = 0; i < disk.size(); i++)
		{
			System.out.println("Composition's name: " + disk.get(i).getName());
			System.out.println("Compositions' duration: " + AbstractMusic.ShowDuration(disk.get(i).getDuration()));
			System.out.println("Composition's creation year: " + disk.get(i).getCreationYear());
			System.out.println("Additional information about this composition: " );
			System.out.println(disk.get(i).getAdditionalInfo());
			if(i != disk.size()- 1)
					System.out.println("\n************************************\n");
		}
	}
	public void addCompositions(ArrayList<AbstractMusic> compositions)
	{
		for(int i = 0; i < compositions.size(); i++)
			disk.add(compositions.get(i));
	}
	public void removeElectroByIndex(int index)
	{
		ElectroList.remove(index);
	}
	public void removeOperaByIndex(int index)
	{
		OperaList.remove(index);
	}
	public Electro getElectroByIndex(int index)
	{
		return ElectroList.get(index);
	}
	public Opera getOperaByIndex(int index)
	{
		return OperaList.get(index);
	}
	public int getElectroSize()
	{
		return ElectroList.size();
	}
	public int getOperaSize()
	{
		return OperaList.size();
	}
	public ArrayList<Opera> getAllOpera()
	{
		return OperaList;
	}
	public ArrayList<Electro> getAllElectro()
	{
		return ElectroList;
	}
	public int getSize()
	{
		return disk.size();
	}
	public String toString()
	{
		return this.getShop();
	}
}
