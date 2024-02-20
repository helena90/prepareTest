import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
       String[] answer = new String[n];
        
        // 비밀지도 암호화
        // 지도 정보 :  한 변이 n /정사각형배열 / 각칸은 공백이나 벽"#"
        // 전체지도는 지도1과 지도2를 겹치면 된다. 둘다 공백은 공백, 하나이상은 벽 
        // 지도 1, 지도2는 정수배열
        // 가로줄 벽을 1, 공백을 0으로 부호했을떄 얻어지는 값의 배열 
        
        // 입력값
        // 1~16 사이의 n : 지도넓이 
        // arr1 지도1 , arr2는 지도2 길이 n의 정수배열 ( 4의 값 ) , 숫자는 이진
        
        
        
        // 지도1과 지도2 안의 값을 각각 이진배열로 변경
        
        String[] binaryArr1 = Arrays.stream(arr1)
            .mapToObj(num -> String.format("%" + n + "s", Integer.toBinaryString(num)).replace(' ', '0'))
            .toArray(String[]::new);
        
        String[] binaryArr2 = Arrays.stream(arr2)
            .mapToObj(num -> String.format("%" + n + "s", Integer.toBinaryString(num)).replace(' ', '0'))
            .toArray(String[]::new);
     
         

        // 지도의 정보 한줄만 가져옴
        for(int row = 0; row < n; row++){
                   
            //이진배열인 지도의 각 값을 array에 담는다.
            String[] map1row = binaryArr1[row].split(""); // 00001
            String[] map2row = binaryArr2[row].split(""); // 00001  
                   
           
            // 비교한 결과를 answerRow에 담는다.
           StringBuilder answerRow = new StringBuilder();

            // 지도1과 지도2에서 가져온 값을 하나씩 비교
            for(int column = 0 ; column < n ; column++){
                if( map1row[column].equals("0") && map2row[column].equals("0") ){
                    // 둘다 0이면 띄어쓰기 저장
                    answerRow.append(" ");
                } else {
                    // 둘 다 공백이 아니면 #을 표시한다.
                    answerRow.append("#");
                }
            }
            
            // 만들어진 값 저장하기
            answer[row] = answerRow.toString();
        }
        
        
        // 결과 : 지도의 #와 공백을 표시한 배열 
        return answer;
    }
}