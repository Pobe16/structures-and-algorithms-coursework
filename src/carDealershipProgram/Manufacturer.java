package carDealershipProgram;

public class Manufacturer implements Comparable<Manufacturer>{

	protected String name;
	
	public Manufacturer(String inputName) {
		this.name = inputName;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Manufacturer inputManufacturer) {
		if(this.name.toLowerCase().equals(inputManufacturer.name.toLowerCase())) 
		{
			return 0;
		}
		else if (this.name.toLowerCase().compareTo(inputManufacturer.name.toLowerCase()) > 0) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
