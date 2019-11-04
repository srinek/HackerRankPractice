package design.linuxFindCmd;

public interface FindCommandInput<T> {
	
	public String getPName();
	
	public String getPath();
	
	public PVal<T> getPval();
}
