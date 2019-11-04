package design.linuxFindCmd;

import java.util.List;

public interface Find<T> {

	
	public List<String> findFiles(FindCommandInput<T> input);
}
