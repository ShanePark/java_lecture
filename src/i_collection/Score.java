package i_collection;

import java.util.ArrayList;
/*

 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를

 * 0 ~ 100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.

 * 

 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차

 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

 * 과목합계	450		450		450		450		450		450		450

 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00

 */
public class Score {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();		
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> subjects = new ArrayList<>();
		
		names.add("정지수");	names.add("김혜정");	names.add("송수미");	names.add("이현기");	names.add("진예은");
		names.add("윤지혜");	names.add("양지수");	names.add("정이삭");	names.add("김도윤");	names.add("박세현");
		names.add("김보현");	names.add("오세일");	names.add("원정훈");	names.add("장병길");	names.add("문선준");
		names.add("배수진");	names.add("진유리");	names.add("김지훈");	names.add("김동익");	names.add("임태준");
		names.add("이진수");	names.add("최희수");	names.add("박초원");	names.add("전형섭");	names.add("김보미");

		subjects.add("국어");		subjects.add("영어");			subjects.add("수학");		subjects.add("사회");		
		subjects.add("과학");		subjects.add("Oracle");		subjects.add("Java");	

		for(int i=0; i<names.size(); i++){	               
			ArrayList<Integer> _list = new ArrayList<>();
			int sum = 0;
			for(int j=0; j<subjects.size(); j++){          
				_list.add((int)(Math.random() * 100)+1);     
				sum+= _list.get(j);
			}
			_list.add(sum);	// list.get(7) 총점
			_list.add(1);	//석차용 ArrayList 1개 추가 list.get(8) 석차
			list.add(_list);                               
		}                      


		int temp;
		for(int i=0; i<list.size(); i++){
			for(int j=i+1; j<list.size() ; j++){
				if(list.get(i).get(subjects.size()) < list.get(j).get(subjects.size())){	//list.get(7) 총점, 8 랭킹
					temp = list.get(i).get(subjects.size()+1);
					list.get(i).set(subjects.size()+1, temp+1);
				}
				else{
					if(list.get(i).get(subjects.size()) != list.get(j).get(subjects.size())){
						temp = list.get(j).get(subjects.size()+1);
						list.get(j).set(subjects.size()+1, temp+1);
					}
				}
			}
		}

		ArrayList<Integer> tempList;
		if(list.get(0).get(subjects.size()+1) > list.get(1).get(subjects.size()+1)){
			tempList = list.get(0);
			list.set(0,list.get(1));
			list.set(1,tempList);
		}

		for(int i=1; i<list.size(); i++){
			tempList = list.get(i);
			String temp_name = names.get(i);
			int j;
			for(j=i-1; j>=0; j--){
				if(tempList.get(subjects.size()+1) < list.get(j).get(subjects.size()+1)){
					list.set((j+1),list.get(j));
					names.set(j+1,names.get(j));
				}else break;
			}
			list.set(j+1, tempList);
			names.set(j+1,temp_name);

		}
		////////////////// print //////////////////////////
		System.out.print("이름\t");
		for(int i=0; i<subjects.size();i++)
			System.out.print(subjects.get(i)+"\t");
		System.out.print("합계\t평균\t석차\n");
		
		for(int i=0; i<list.size();i++){
			System.out.print(names.get(i)+"\t");
			for(int j=0; j<list.get(i).size(); j++){
				System.out.print(list.get(i).get(j)+"\t");
				if(j==subjects.size())
					System.out.print(Math.round(list.get(i).get(j)/(double)subjects.size()*100)/100.0+"\t");
			}
			System.out.println();
		}
		
		System.out.print("과목합계\t");
		list.add(new ArrayList<Integer>());
		for(int i=0; i<subjects.size(); i++){
			int sum=0;
			for(int j=0; j<names.size(); j++)
				sum+= list.get(j).get(i);
			list.get(list.size()-1).add(i, sum);
		}
		
		for(int i=0; i<subjects.size(); i++)
			System.out.print(list.get(list.size()-1).get(i)+"\t");
		System.out.print("\n과목평균\t");
		for(int i=0; i<subjects.size(); i++)
			System.out.print(Math.round((list.get(list.size()-1).get(i))/(double)names.size()*100)/100.0+"\t");
		

	}
}