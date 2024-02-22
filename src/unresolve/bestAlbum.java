package unresolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class bestAlbum {

	public static void main(String[] args) {

		String[] genres = { "classic", "pop", "classic", "classic", "pop", "z", "classic", "z", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500, 12, 789, 12, 600 };

		// 베스트앨범에 들어갈 노래의 고유번호 ( 노래장르의 순서에 맞춰서

		// - 스트리밍 사이트에서 장르별로 가장 많이 재생된 노래 두개씩 베스트로
		// - 노래는 고유번호
		// - 노래수록기준 : 1 많이 재생된 장르 2장르내에서 많이 재생된 노래 3재생횟수가 같으면 고유번호가 낮은 노래부터(등록된지 오래된 거
		// 부터)
		// - 장르별로 곡 두개만 , 재생수가 높은것부터

		// step1 - 장르별로 곡 두개씩 뽑기 + 장르별 plays 수 counting
		// 초기화
		HashMap<String, List<Integer>> genresBestMap = new HashMap<>(); // 장르, 곡순서
		HashMap<String, Integer> playCountMap = new HashMap<>(); // 장르, 총 play수

		for (int songNo = 0; songNo < genres.length; songNo++) {
			String genre = genres[songNo];
			int play = plays[songNo];
			List<Integer> newBestSongNoList = new ArrayList<>();

			// ! genresBest에 장르 없으면 바로저장하고 다음으로
			if (!genresBestMap.containsKey(genre)) {
				playCountMap.put(genre, play);
				newBestSongNoList.add(songNo);
				genresBestMap.put(genre, newBestSongNoList);
				continue;
			}

			// ! genresBest에 장르가 있으면,
			// 곡의 플레이 수를 장르 총 실행수에 추가
			int totalPlay = playCountMap.get(genre) + play;
			playCountMap.put(genre, totalPlay);

			// 이전 장르베스트 가져오기
			List<Integer> genresBestNos = genresBestMap.get(genre);

			// 저장된 곡번호의 play수와 비교해서 큰 값만 저장
			newBestSongNoList = genresBestNos;
			for (int j = 0; j < genresBestNos.size(); j++) {
				// 저장된 곡의 플레이수보다 저장할 곡이 플레이수가 크면 순서변경
				int beforeNo = genresBestNos.get(j);
				if (plays[beforeNo] < play) {
					newBestSongNoList.add(j, songNo);
					break;
				}
			}
			// 결과값 저장
			genresBestMap.put(genre, newBestSongNoList);
		}

		// step2- 플레이 수가 가장 큰 장르순서 부터 답변으로 저장
		int genresBestCount = 0; // 총 베스트곡 수
		for (Collection<Integer> bestSongs : genresBestMap.values()) {
			int genresBestSize = bestSongs.size() >= 2 ? 2 : bestSongs.size();
			genresBestCount = genresBestCount + genresBestSize;
		}

		// 답변 저장
		int[] answer = new int[genresBestCount]; // 답변배열 생성
		int saveCnt = 0; // maxno를 구하기 위함
		while (playCountMap.size() != 0) {
			// 재생수가 가장 많은 장르 조회
			Integer macPlayCnt = Collections.max(playCountMap.values());
			List<String> foundGenres = playCountMap.entrySet().stream()
					.filter(entry -> Objects.equals(entry.getValue(), macPlayCnt)).map(Map.Entry::getKey)
					.collect(Collectors.toList());

			//
			if (foundGenres.size() > 1) {

			}

			// 하나씩 답변 저장
			for (String title : foundGenres) {
				List<Integer> bestSongList = genresBestMap.get(title);
				for (int cnt = 0; cnt < 2; cnt++) {
					if (bestSongList.size() <= cnt)
						break;

					answer[saveCnt] = bestSongList.get(cnt);
					saveCnt++;
				}
				// 저장한 항목 제거
				playCountMap.remove(title);
			}
		}

		System.out.println(Arrays.toString(answer));
	}

}