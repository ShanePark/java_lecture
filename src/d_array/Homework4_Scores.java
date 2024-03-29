package d_array;


public class Homework4_Scores {

	public static void main(String[] args) {
		
		String[] names = {"정지수", "김혜정", "송수미", "이현기", "진예은", "윤지혜", "양지수", "정이삭", "김도윤", "박세현", "김보현", "오세일", "원정훈",
				"장병길", "문선준", "배수진","진유리", "김지훈", "김동익", "임태준", "이진수", "최희수", "박초원", "전형섭", "김보미","과목합계"};
		int[][] array= new int[names.length][9]; 	//과목수 7개 + 합계 + 석차 . 학생별로 총 9 크기의 배열
		int num_students = array.length-1;  
		
		
		for(int i=0; i<num_students; i++){					//// Random //////////////////
			for(int j=0; j<array[i].length-2; j++){         // 	array[i][7]는  			//	
				array[i][j] = (int)(Math.random() * 101);   //  		 학생별 총점
				array[i][7] += array[i][j];		            // array[num_students][j]는 
				array[num_students][j] += array[i][j];	    //		과목 합계				//
			}												//////////////////////////////
		}
		for(int i=0; i<num_students;i++){          	    ////// Ranking ///////////
			for(int j=i+1; j<array.length; j++){        //						//
				if(array[i][7] < array[j][7])           //	array[i][7]에 비교된
					array[i][8]++;                      // 	학생별 총점을 기준으로 비교
				else{                                   //
					if(array[i][7] != array[j][7])      // 	array[i][8]에 
						array[j][8]++;                  // 		석차를 저장한다		//
				}                                       //////////////////////////
			}
		}

		if(array[0][8] > array[1][8]){               //////// Sorting ////////////////
			int[] temp;                              //								//
			temp = array[0];                         //  석차 별로 정렬합니다
			array[0] = array[1];                     //
			array[1] = temp;                         // 
		}                                            //
		                                             //
		for(int i=1; i<(num_students); i++){         //
			int temp[] = array[i];                   //		배열을 정렬할때
			String temp_name = names[i];             //		저장된 이름들도
			int j;                                   // 	함께 정렬해줍니다
			for(j=i-1; j>=0; j--){                   //
				if(temp[8] < array[j][8]){           //
					array[j+1]=array[j];             //	정렬 방법은 삽입 정렬을 사용합니다
					names[j+1]=names[j];             //
				}else break;                         //
			}                                        //
			array[j+1] = temp;                       //								//
			names[j+1] = temp_name;                  /////////////////////////////////
		}
			
		System.out.println("\t    국어\t    영어\t    수학\t    사회\t    과학     Oracle\tJAVA\t  합계\t 평균          석차");
		for(int i=0; i<num_students; i++){
			System.out.printf("%s\t%4d\t%4d\t%4d\t%4d\t%4d\t%4d\t%4d\t%4d\t%.2f\t%2d\n",names[i],array[i][0],array[i][1],
					array[i][2],array[i][3],array[i][4],array[i][5],array[i][6],array[i][7],(array[i][7])/7.0,array[i][8]+1);
		}
		System.out.printf("과목합계\t%d\t%d\t%d\t%d\t%d\t%d\t%d\n",array[num_students][0],array[num_students][1],array[num_students][2],
				array[num_students][3],array[num_students][4],array[num_students][5],array[num_students][6]);
		System.out.printf("과목평균\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n",
				array[num_students][0]/(float)(num_students),array[num_students][1]/(float)(num_students),array[num_students][2]/(float)(num_students),array[num_students][3]/(float)(num_students),
				array[num_students][4]/(float)(num_students),array[num_students][5]/(float)(num_students),array[num_students][6]/(float)(num_students));

	}

}
