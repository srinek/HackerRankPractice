package design.linuxFindCmd.impl;

import design.linuxFindCmd.Find;
import design.linuxFindCmd.FindCommandInput;
import design.linuxFindCmd.PVal;

public class FindBySizeTest {
	
	public static void main(String[] args) {
		
		Find<Long> findByName = new FindBySizeImpl();
		
		FindCommandInput<Long> input = new FindCommandInput<Long>() {

			@Override
			public String getPName() {
				return "size";
			}

			@Override
			public String getPath() {
				return "C:\\code\\jars";
			}
			
			@Override
			public PVal<Long> getPval() {
				return new PVal<Long>() {

					@Override
					public Long getVal() {
						return new Long(10000);
					}
					 
				};
			}
		};
		
		System.out.println(findByName.findFiles(input));
	}

}
