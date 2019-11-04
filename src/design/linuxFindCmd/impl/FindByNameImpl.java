package design.linuxFindCmd.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import design.linuxFindCmd.Find;
import design.linuxFindCmd.FindCommandInput;

public class FindByNameImpl implements Find<String> {

	@Override
	public List<String> findFiles(FindCommandInput<String> input) {
		
		String val = input.getPval().getVal();
		String path = input.getPath();
		
		File f = new File(path);
		List<String> result = new ArrayList<>();
		findFilesHelper(val, f, result);
		return result;
	}
	
	private void findFilesHelper(String val, File directory, List<String> result){
		
		if(directory == null){
			return;
		}
		
		//System.out.println(directory.getName() +"  "+directory.listFiles());
		
		for(File eachFile : directory.listFiles()){
			if(eachFile.isDirectory()){
				findFilesHelper(val, eachFile, result);
			}
			else if( eachFile.getName().indexOf(val) != -1 ) {
				result.add(eachFile.getName());
			}
		}
	
	}

}
