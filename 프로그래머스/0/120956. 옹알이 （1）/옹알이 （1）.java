class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        // 아가단어
        String[] babyWord = {"aya", "ye", "woo", "ma"};
        
        // 입력된 단어
        for (String keyword : babbling ){
            
            // 아가단어와 이전단어 매치여부 확인
            for( int i = 0 ; i < babyWord.length ; i++){
                
                if( keyword.contains(babyWord[i]) ){
                    // 키워드가 아기단어를 포함하면 split
                    keyword = keyword.trim();
                    String[] result = keyword.split(babyWord[i]);
                   
                    if( result.length != 0 ){
                       
                        // 중간단어가 빠진경우 처리를 위한 선작업
                        int babyWordPoint = keyword.indexOf(babyWord[i]);
                        
                         // split하고 남은 단어가 있다면 남은 단어로 재실행
                        keyword = ""; //기존 키워드 초기화
                        for (String re : result){
                          
                             keyword = keyword + re ; 
                            if ( babyWordPoint > 0 ){
                                //단어사이에 공백추가
                                keyword = keyword + " " ;     
                            } 
                        }
                        
                  //   w ye oo
                    } else { 
                        // split하고 남은 단어가 없으면 break 하고 정답수를 증가한다.
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}