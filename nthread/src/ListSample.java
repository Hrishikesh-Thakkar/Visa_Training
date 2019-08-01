import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> iList = Arrays.asList(3,6);
		List<String> sList = Arrays.asList("Smith","Bob");

		print(iList);
		print(sList);
		
		List<Integer> idList=new ArrayList<>();
		List<String> sdList=new ArrayList<>();
		copy(idList,iList);
		copy(sdList,sList);
		System.out.println(idList);
		System.out.println(sdList);
	}
	
	private static <T> void copy(List<T> des , List<T> src) {
		for(T elem: src)
			des.add(elem);
	}

	private static void print(List<?> sList) {
		// TODO Auto-generated method stub
		for (Object object : sList) {
			System.out.println(object);
		}
		
	}

}
