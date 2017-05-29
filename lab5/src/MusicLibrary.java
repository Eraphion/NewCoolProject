import java.util.ArrayList;

public abstract class MusicLibrary
{
	// For electro musuic
	private static  ArrayList<String> MusicData = new ArrayList<String>();
	private static  ArrayList<Boolean> MusicUsed = new ArrayList<Boolean>();
	
	// For opera music
	private static  ArrayList<String> MusicData2 = new ArrayList<String>();
	private static  ArrayList<Boolean> MusicUsed2 = new ArrayList<Boolean>();
	
	private static  ArrayList<String> MainInstruments = new ArrayList<String> ();
	private static  ArrayList<String> Places = new ArrayList<String> ();
	private static  ArrayList<String> Eras = new ArrayList<String> ();
	

	private static void AddInstrument(String Name)
	{
		for(int i = 0; i < MainInstruments.size(); i++)
			if(MainInstruments.get(i).equals(Name))
				return;
		MainInstruments.add(Name);
	}
	public static String getInstrument()
	{
		if(MainInstruments.size() == 0)
			return "NULL";
		double r = Math.random();
		int choise = (int) (r * MainInstruments.size());
		return MainInstruments.get(choise);
	}
	
	
	
	
	private static void AddPlace(String Name)
	{
		for(int i = 0; i < Places.size(); i++)
			if(Places.get(i).equals(Name))
				return;
		 Places.add(Name);
	}
	public static String getPlace()
	{
		if( Places.size() == 0)
			return "NULL";
		double r = Math.random();
		int choise = (int) (r *  Places.size());
		return  Places.get(choise);
	}
	
	
	
	
	private static void AddEra(String Name)
	{
		for(int i = 0; i < Eras.size(); i++)
			if(Eras.get(i).equals(Name))
				return;
		 Eras.add(Name);
	}
	public static String getEra()
	{
		if( Eras.size() == 0)
			return "NULL";
		double r = Math.random();
		int choise = (int) (r *  Eras.size());
		return  Eras.get(choise);
	}
	
	
	
	
	
	public static void AddName(String Name)
	{
		for(int i = 0; i < MusicData.size(); i++)
			if(MusicData.get(i).equals(Name))
				return;
		MusicData.add(Name);
		MusicUsed.add(false);
	}
	public static String getName()
	{
		if(MusicData.size() == 0)
			return "NULL";
		while(true)
		{
			double r = Math.random();
			int choise = (int)( r * MusicData.size());
			if(!MusicUsed.get(choise))
			{
				MusicUsed.set(choise, true);
				return MusicData.get(choise);
			}
		}
	}
	
	
	public static void AddName2(String Name)
	{
		for(int i = 0; i < MusicData2.size(); i++)
			if(MusicData2.get(i).equals(Name))
				return;
		MusicData2.add(Name);
		MusicUsed2.add(false);
	}
	public static String getName2()
	{
		if(MusicData2.size() == 0)
			return "NULL";
		while(true)
		{
			double r = Math.random();
			int choise = (int)( r * MusicData2.size());
			if(!MusicUsed2.get(choise))
			{
				MusicUsed2.set(choise, true);
				return MusicData2.get(choise);
			}
		}
	}
	
	
	
	public static int getSize()
	{
		return MusicData.size();
	}
	public static int getSize2()
	{
		return MusicData2.size();
	}
	
	public static void Reset()
	{
		for(int i = 0; i < MusicUsed.size(); i++)
			MusicUsed.set(i, false);
		for(int i = 0; i < MusicUsed2.size(); i++)
			MusicUsed2.set(i, false);
	}
	
	
	public static void MakeBase()
	{
		AddName("Daft Punk - Get Lucky");
		AddName("Daft Punk - Da Funk");
		AddName("Daft Punk - One More Time");
		AddName("Daft Punk - Short Curcuit");
		AddName("Daft Punk - Human After All");
		AddName("Daft Punk - Harder better faster stronger");
		AddName("Daft Punk - Alive");
		AddName("Daft Punk - Tron: legacy");
		
		AddName2("Dido and Aeneas");
		AddName2("Giulio Cesare");
		AddName2("Serse (Xerxes)");
		AddName2("Orfeo ed Euridice");
		AddName2("Le Nozze di Figaro");
		AddName2("Barbiere di Siviglia");
		AddName2("Guillaume Tell (William Tell)");
		AddName2("Rigoletto");
		AddName2("La Traviata");
		AddName2("Pagliacci");
		
		
		AddInstrument("violin");
		AddInstrument("drums");
		AddInstrument("ukulele");
		AddInstrument("guitar");
		AddInstrument("piano");
		
		AddEra("classicism");
		AddEra("romanism");
		AddEra("barokko");
		AddEra("sentimentalism");
		AddEra("realism");
		
		AddPlace("Moscow");
		AddPlace("Vena");
		AddPlace("Milan");
		AddPlace("Buenos Aires");
	}
}
