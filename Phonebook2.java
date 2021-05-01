package mapPractice;

import java.util.*;


public class Phonebook2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map <String, String>aban = new TreeMap<>();
		aban.put("박동현", "01065245555");
		aban.put("김새별", "01065245554");
		aban.put("장재현", "01065245553");
		
		Map <String, String>bban = new TreeMap<>();
		bban.put("서민성", "01066245552");
		bban.put("장현석", "01066245551");
		bban.put("박규진", "01066245550");
		
		Map<String, Map<String, String>> phoneBook = new TreeMap<>();
		phoneBook.put("A반", aban);
		phoneBook.put("B반", bban);
//		
//		Set<Map.Entry<String, Map<String, String>>> entrySet = phoneBook.entrySet();
//		
//		
//		Iterator<Map.Entry<String, Map<String, String>>> iter1 = entrySet.iterator();
//		
//		while(iter1.hasNext()) {
//			Map.Entry<String, Map<String, String>> entry = iter1.next();
//			System.out.println(entry.getKey()); //A반 또는 B반
//			Map<String, String> pb = entry.getValue();
//			Set<Map.Entry<String, String>> phones = pb.entrySet();
//			Iterator<Map.Entry<String, String>> iter2 = phones.iterator();
//			while(iter2.hasNext()) {
//				Map.Entry<String, String> phone = iter2.next();
//				System.out.println(phone.getKey() +" : " + phone.getValue());
//			}
//			System.out.println("\n");		
//		}
			
			
			Object str[] = phoneBook.keySet().toArray();

			Iterator iter = aban.keySet().iterator();
			
			Object a[] = aban.keySet().toArray();
			
			System.out.println(str[0]);
			int i = -1;
			while(iter.hasNext()) {
				i++;
				System.out.println(iter.next()+ " : " + aban.get(a[i]));
			}
			
			
			System.out.println();
			
			Iterator iter2 = bban.keySet().iterator();
			
			Object b[] = bban.keySet().toArray();
			
			System.out.println(str[1]);
			i = -1;
			while(iter2.hasNext()) {
				i++;
				System.out.println(iter2.next() + " : " + bban.get(b[i]));
			}		
	}

}
