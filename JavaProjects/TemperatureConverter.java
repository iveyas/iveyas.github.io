public class Temperature
{
	double ftemp;
	
	
	public Temperature(double ftemp)
	{
	
		setFahrenheit(ftemp);
	
	}//end public Temperature(double)
	
	public void setFahrenheit(double ftemp)
	{
		this.ftemp= ftemp;
	}//end setTemp(double)
	
	public double getFahrenheit()
	{
		double dFTemp;
		dFTemp= this.ftemp;
		return dFTemp;
		
	}//end public double getFahrenheit()
	
	public double getCelcius()
	{
		double dCelcius;
		dCelcius= (5.0/9.0) * (this.ftemp-32);
		return dCelcius;
	}//end getCelcius()
	
	public double getKelvin()
	{
		double dKelvin;
		double dCelcius= getCelcius();
		dKelvin= dCelcius + 273;
		return dKelvin;
	}//end getKelvin(double)
	
}//end public class Temperature
