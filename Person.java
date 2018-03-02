public class Person implements Comparable<Person> {
	private String name;
	private int birth; 
	private int death; 
	
	public Person(String n, int b, int d) {
		name = n;
		birth = b; 
		death = d;
    }
    
    public String getName() {
    	return name;
	}
	
	public int getBirth() {
		return birth;
	}
	
	public int getDeath() {
		return death;
	}
	
	public int compareTo(Person p) {
		Person other = p;
		//Compares births if births aren't equal
        if (this.birth < other.birth) { return -1; }
        if (this.birth > other.birth) { return 1; }
        if (this.birth == other.birth) { return 0; }
        else
        	return 0;
            
    }		
	
}

