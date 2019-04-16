package carDealershipProgram;

public class Car implements Comparable<Car>{
	
	protected String name;
	private String registrationNumber;
	private String model;
	private String colour;
	
	public Car(String manufacturerName, String regNumber, String carModel, String carColour) {
		name = manufacturerName;
		// TODO Auto-generated constructor stub
		registrationNumber = regNumber;
		model = carModel;
		colour = carColour;
	}
	
//	Access methods
	public String getName() {return name;}
	public String getRegistration() {return registrationNumber;}
	public String getModel() {return model;}
	public String getColour() {return colour;}
	
	@Override
	public String toString() {
		return "Manufacturer : " + this.name + "\n"
				+ "Model : " + this.model+ "\n"
				+ "Registration Number : " + this.registrationNumber + "\n"
				+ "Colour : " + this.colour+ "\n";
	}
	
	@Override
	public int compareTo(Car otherCar) {
		if(this.getRegistration().toLowerCase().equals(otherCar.getRegistration().toLowerCase())) 
		{
			return 0;
		}
		
		if(this.name.toLowerCase().equals(otherCar.name.toLowerCase())) 
		{
			if(this.getModel().toLowerCase().equals(otherCar.getModel().toLowerCase())) 
			{
				if(this.getRegistration().toLowerCase().equals(otherCar.getRegistration().toLowerCase())) 
				{
					return 0;
				}
				else if (this.getRegistration().toLowerCase().compareTo(otherCar.getRegistration().toLowerCase()) > 0) {
					return 1;
				}
				else {
					return -1;
				}
			}
			else if (this.getModel().toLowerCase().compareTo(otherCar.getModel().toLowerCase()) > 0) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else if (this.name.toLowerCase().compareTo(otherCar.name.toLowerCase()) > 0) {
			return 1;
		}
		else {
			return -1;
		}
	}	
}
