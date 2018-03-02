public class TreeGenerator {
	public static void main (String args[]){
		ArrayList<Person> tree = FamilyTree.makeTree(args[0]);
		
		for (Person p: tree){
			System.out.println(p);
		}
			
	
	}
}