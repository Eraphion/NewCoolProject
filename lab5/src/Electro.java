
public class Electro extends ModernMusic
{
	private String mainInstrument;
	public String getMainInstrument()
	{
		return mainInstrument;
	}
	public void setMainInstrument(String mainInstrument)
	{
		this.mainInstrument = mainInstrument;
	}
	String getAdditionalInfo() 
	{
		String result = "";
		if(hasSpecialEffects())
			result += "There are special effects in this composition\r\n";
		else
			result +="There are not special effects in this composition\r\n";
		result+="Main instrument in this song: " + mainInstrument+"\r\n";
		return result;
	}
	Electro()
	{
	}
	Electro(int duration, int creationYear, String name, boolean specialEffects, String mainInstrument)
	{
		super(duration, creationYear, name, specialEffects);
		this.mainInstrument = mainInstrument;
	}
	public String toString()
	{
		return this.getName();
	}
}
