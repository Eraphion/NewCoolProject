
public class Opera extends ClassicMusic 
{
	private String firstTheatre;
	Opera()
	{
		
	}
	Opera(int duration, int creationYear, String name, String classicEra, String firstTheatre)
	{
		super(duration, creationYear, name, classicEra);
		this.firstTheatre = firstTheatre;
	}
	public void setFirstTheatre(String firstThreatre)
	{
		this.firstTheatre = firstThreatre;
	}
	public String getFirstTheatre()
	{
		return firstTheatre;
	}
	String getAdditionalInfo() 
	{
		String result = "";
		result += "Composition's era is " + getClassicEra() +"\r\n" ;
		MusicLibrary.MakeBase();
		result += "The first theatre where this opera was performed is " +MusicLibrary.getPlace() +"\r\n" ;
		return result;
	}
	public String toString()
	{
		return this.getName();
	}
}
