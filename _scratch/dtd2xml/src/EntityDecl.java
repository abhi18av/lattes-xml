public interface EntityDecl extends Comparable<EntityDecl> {
	String asXML();
	
	String getName();

	@Override
	public int compareTo(EntityDecl o);
}
