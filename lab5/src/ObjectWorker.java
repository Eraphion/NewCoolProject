import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectWorker {
public static void SaveObjects(String FilePath, ArrayList<Assembly> disks, StringAsClass Report)
{
	{
		FileOutputStream OutputStream = null;
		ObjectOutputStream ObjectOutput = null;
		try
		{
			 OutputStream = new FileOutputStream(FilePath);
			 ObjectOutput = new ObjectOutputStream(OutputStream);
			 ObjectOutput.writeObject(disks);
		}
		catch(FileNotFoundException err)
		{
			Report.str = err.getMessage();
		}
		catch(IOException err)
		{
			Report.str = err.getMessage();
		}
		finally
		{
			try
			{
				if(OutputStream!=null)
				{
					OutputStream.close();
					try
					{
						if(ObjectOutput!=null)
						{
							Report.str = "Изменения сохранены!";
							ObjectOutput.close();
						}
					}
					catch(IOException err)
					{
						Report.str = err.getMessage();
					}
				}
			}
			catch(IOException err)
			{
				Report.str = err.getMessage();
			}
		}
	}
}



	public static ArrayList<Assembly>  ReadFromFile(String FilePath, StringAsClass Report)
	{
		FileInputStream InputStream = null;
		ObjectInputStream ObjectInput = null;
		ArrayList<Assembly> disks = null;
		try
		{
			InputStream = new FileInputStream (FilePath);
		    ObjectInput = new ObjectInputStream(InputStream);
		    disks = (ArrayList<Assembly>)ObjectInput.readObject();
		}
		catch(FileNotFoundException err)
		{
			Report.str = "Файл был создан!";
		}
		catch(IOException err)
		{
			Report.str = err.getMessage();
		}
		catch(ClassNotFoundException err)
		{
			Report.str = err.getMessage();
		}
		finally
		{
			try
			{
				if(InputStream != null)
				{
					InputStream.close();
					try
					{
						if(ObjectInput!=null)
							ObjectInput.close();
					}
					catch(IOException err)
					{
						Report.str = err.getMessage();
					}
				}
			}
			catch(IOException err)
			{
				Report.str = err.getMessage();
			}
		}
		if(disks==null && Report.str==null)
			Report.str = "Файл оказался пуст!";
		else if (disks!=null)
			Report.str = "Файл успешно открыт!";
		return disks;
	}
	
	
	public static void ClearFile(String path, StringAsClass Report)
	{
		FileOutputStream OutputStream = null;
		try
		{
			OutputStream = new FileOutputStream(path);
			byte [] empty ;
			empty = new byte[0];
			OutputStream.write(empty);
		}
		catch(IOException err)
		{
			Report.str = err.getMessage();
		}
		finally
		{
			if(OutputStream != null)
				try
				{
					Report.str = "Файл очищен!";
					OutputStream.close();
				}
			catch(IOException err)
			{
				Report.str = err.getMessage();
			}
		}
	}
}
