package e_oop.score;
public class Score {

	public static void main(String[] args) {
		Student[] students = new Student[10];
		
		for(int i=0; i<students.length; i++){
			Student student = new Student(); // for 문 위로 올라가버리면 안된다!
			student.name = "학생" + (i+1); student.rank = 1;
			student.kor = (int)(Math.random() * 101); student.eng = (int)(Math.random() * 101); student.math = (int)(Math.random() * 101);
			student.sum = student.kor + student.eng + student.math; student.avg = student.sum / 3.0;
			students[i] = student;
			for(int j=0; j<i; j++){
				if(students[i].sum > students[j].sum){
					students[j].rank++;
					Student temp = students[i];         // 랭크를 위한 비교를 하면서
					students[i] = students[j];          // 비교 된 김에 정렬도 해준다.
					students[j] = temp;                 // 새로만든 학생객체의 등수가 더 좋으면 앞으로
				}
				else if(students[i] != students[j]){
					students[i].rank++;					// 새로 만든 객체 등수가 더 안좋으니 뒤에 그대로 둔다.
				}
			}
		}
		//성적 관리 프로그램을 완성해주세요
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t등수");
		for(int i=0; i<students.length; i++){
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",students[i].name,students[i].kor,
					students[i].eng,students[i].math,students[i].sum,students[i].avg,students[i].rank);
		}
		//과목별 합계
		int korSum =0, engSum =0, mathSum =0;
		for(int i=0; i<students.length; i++){
			korSum += students[i].kor;
			engSum += students[i].eng;
			mathSum += students[i].math;
		}
		//과목별 평균
		double korAvg = (double)korSum / students.length;
		double engAvg = (double)engSum / students.length;
		double mathAvg = (double)mathSum / students.length;
		System.out.printf("과목합계\t%d\t%d\t%d\n",korSum,engSum,mathSum);
		System.out.printf("과목평균\t%.2f\t%.2f\t%.2f",korAvg,engAvg,mathAvg);
			
		
	}
}
