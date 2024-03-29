package d_array;

import java.util.Arrays;

public class Array_test {

	public static void main(String[] args) {
		String[] names = {"김민수", "이하늘", "김태균", "팀쿡","일론머스크","테슬라"};
		String[] subjects = {"국어", "영어", "수학", "사회", "과학", "Oracle","Java"};
		int[][] score = new int[names.length][subjects.length];
		
		for(int i=0; i<names.length; i++){
			for(int j=0; j<subjects.length; j++){
				score[i][j] = (int)(Math.random()*100);
			}
		}
		
		int[] nameSum = new int[names.length];
		
		for(int i=0; i<names.length; i++){
			for(int j=0; j<subjects.length; j++){
				nameSum[i] += score[i][j];
			}
		}
		
		double[] nameAvg = new double[names.length];
		
		for(int i=0; i<names.length; i++){
			nameAvg[i] = nameSum[i]/(double)subjects.length;
			nameAvg[i] = (Math.round(nameAvg[i]*100))/100;
		}
		
		int[] subSum = new int[subjects.length];
		
		for(int i=0; i<subjects.length; i++){
			for(int j=0; j<names.length; j++){
				subSum[i] += score[j][i];
			}
		}
		
		double[] subAvg = new double[subjects.length];
		
		for(int i=0; i<subjects.length; i++){
			subAvg[i] = subSum[i] / (double)names.length;
			subAvg[i] = (Math.round(subAvg[i] * 100))/100.0;
		}
		
		int[] rank = new int[names.length];
		for(int i=0; i<names.length; i++){
			for(int j=i+1; j<names.length; j++){
				if(subSum[i]<subSum[j])
					rank[i]++;
				else{ if(subSum[i] != subSum[j]) rank[j]++;}
			}
			rank[i]++;
		}
		
		System.out.print("\t"+Arrays.toString(subjects)+"\t합계\t평균\t석차");
		for(int i=0; i<names.length; i++){
			System.out.print("\n"+names[i]+"\t"+Arrays.toString(score[i])+"\t"
					+"\t"+subSum[i]+"\t"+subAvg[i]+"\t"+rank[i]);
		}
		System.out.print("\n과목합계\t"+Arrays.toString(subSum)+"\n과목평균\t"+Arrays.toString(subAvg));
	}

}
