import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        HashMap<Integer, Integer> numList = new HashMap<>(); 
                
        // array의 값들이 몇개인지 정렬
        for( int i = 0; i < array.length ; i++ ){
            int targetNum = array[i];
            
            if ( numList.containsKey(targetNum) ){
                //true이면 찾아서 숫자를 올려준다.
                numList.put(targetNum, (numList.get(targetNum)) +1 );
                
            } else {
                //없으면 값을 추가한다.
                numList.put(targetNum,1);
            }
        }
        
        // 가장 빈도가 높은 수 찾기    
        int count = 0 ;
        Iterator<Integer> keys = numList.keySet().iterator();
        while(keys.hasNext()){
            int key = keys.next();
            if  ( count == numList.get(key)){
                answer = -1 ;
            } else if ( count < numList.get(key)){
                answer = key ;
                count = numList.get(key) ;
            }
        }

        return answer;
    }
}