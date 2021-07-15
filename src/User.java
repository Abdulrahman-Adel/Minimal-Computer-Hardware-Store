import java.util.UUID;

public class User {
	
	protected String USER_ID;
	protected String full_name;
	protected String password;
	protected String Email;
	
	
	public void setPass(String Pass)
	{
		this.password = Pass;
	}
	public String getPass()
	{
		return this.password;
	}
	
	public void setMail(String mail)
	{
		this.Email = mail;
	}
	public String getMail()
	{
		return this.Email;
	}
	
	public void setName(String fn)
	{
		this.full_name = fn;
	}
	public String getName()
	{
		return this.full_name;
	}
	
	public void generate_ID()
	{
		this.USER_ID = UUID.randomUUID().toString();
	}
	
	public void setID(String id)
	{
		this.USER_ID = id;
	}
	public String getID()
	{
		return this.USER_ID;
	}
}

