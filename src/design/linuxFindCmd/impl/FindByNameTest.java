package design.linuxFindCmd.impl;

import design.linuxFindCmd.Find;
import design.linuxFindCmd.FindCommandInput;
import design.linuxFindCmd.PVal;

public class FindByNameTest {
	
	public static void main(String[] args) {
		
		Find<String> findByName = new FindByNameImpl();
		
		FindCommandInput<String> input = new FindCommandInput<String>() {

			@Override
			public String getPName() {
				return "name";
			}

			@Override
			public String getPath() {
				return "C:\\code\\jars";
			}
			
			@Override
			public PVal<String> getPval() {
				return new PVal<String>() {

					@Override
					public String getVal() {
						return "a";
					}
					 
				};
			}
		};
		
		System.out.println(findByName.findFiles(input));
	}

}
