package org.speculatingwook.cinema;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <h2>MovieService</h2>
 * <p>
 * 자바 8 기능을 유형별로 10개씩 구현한 예시 클래스입니다.
 * 각 메서드에는 번호와 함께 주석으로 설명을 달아두었습니다.
 * </p>
 */
public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // ========================================================
    // A. Filtering (10개)
    // ========================================================

    /** Filtering #1: 특정 장르의 영화 목록 반환 */
    public List<Movie> getMoviesByGenre(String genre) {
        return movies.stream()
                .filter(m -> m.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    /** Filtering #2: 상영 시간이 특정 분보다 긴 영화 목록 반환 */
    public List<Movie> getMoviesLongerThan(int minDuration) {
        return movies.stream()
                .filter(m -> m.getDuration() > minDuration)
                .collect(Collectors.toList());
    }

    /** Filtering #3: 평점이 특정 값 이상인 영화 목록 반환 */
    public List<Movie> getMoviesWithRatingAbove(double minRating) {
        return movies.stream()
                .filter(m -> m.getRating() >= minRating)
                .collect(Collectors.toList());
    }

    /** Filtering #4: 특정 연도 이후에 개봉한 영화 목록 반환 */
    public List<Movie> getMoviesReleasedAfter(int yearThreshold) {
        return movies.stream()
                .filter(m -> m.getYear() > yearThreshold)
                .collect(Collectors.toList());
    }

    /** Filtering #5: 영화 제목에 특정 키워드가 포함된 영화 목록 반환 */
    public List<Movie> getMoviesTitleContains(String keyword) {
        return movies.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    /** Filtering #6: 감독 이름이 정확히 일치하는 영화 목록 반환 */
    public List<Movie> getMoviesByDirector(String director) {
        return movies.stream()
                .filter(m -> m.getDirector().equalsIgnoreCase(director))
                .collect(Collectors.toList());
    }

    /** Filtering #7: 흥행 수익이 일정 금액 이상인 영화 목록 반환 */
    public List<Movie> getMoviesWithBoxOfficeAbove(long minBoxOffice) {
        return movies.stream()
                .filter(m -> m.getBoxOffice() >= minBoxOffice)
                .collect(Collectors.toList());
    }

    /** Filtering #8: 상영 시간이 일정 범위 내에 있는 영화 목록 반환 */
    public List<Movie> getMoviesInDurationRange(int minDuration, int maxDuration) {
        return movies.stream()
                .filter(m -> m.getDuration() >= minDuration && m.getDuration() <= maxDuration)
                .collect(Collectors.toList());
    }

    /** Filtering #9: 평점이 일정 범위 내에 있는 영화 목록 반환 */
    public List<Movie> getMoviesWithRatingInRange(double minRating, double maxRating) {
        return movies.stream()
                .filter(m -> m.getRating() >= minRating && m.getRating() <= maxRating)
                .collect(Collectors.toList());
    }

    /** Filtering #10: 개봉연도가 두 값 사이에 있는 영화 목록 반환 */
    public List<Movie> getMoviesBetweenYears(int startYear, int endYear) {
        return movies.stream()
                .filter(m -> m.getYear() >= startYear && m.getYear() <= endYear)
                .collect(Collectors.toList());
    }

    // ========================================================
    // B. Mapping (10개)
    // ========================================================

    /** Mapping #1: 모든 영화 제목 리스트 반환 */
    public List<String> getAllTitles() {
        return movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }

    /** Mapping #2: 모든 영화 감독 리스트 반환 (중복 제거) */
    public List<String> getAllDirectors() {
        return movies.stream()
                .map(Movie::getDirector)
                .distinct()
                .collect(Collectors.toList());
    }

    /** Mapping #3: 모든 영화 제목을 대문자로 변환하여 반환 */
    public List<String> getTitlesInUpperCase() {
        return movies.stream()
                .map(m -> m.getTitle().toUpperCase())
                .collect(Collectors.toList());
    }

    /** Mapping #4: 영화 제목과 개봉연도를 합친 문자열 리스트 반환 ("제목 (연도)") */
    public List<String> getTitleWithYear() {
        return movies.stream()
                .map(m -> m.getTitle() + " (" + m.getYear() + ")")
                .collect(Collectors.toList());
    }

    /** Mapping #5: 영화 정보를 "제목 - 평점" 형식으로 매핑하여 반환 */
    public List<String> getTitleAndRating() {
        return movies.stream()
                .map(m -> m.getTitle() + " - " + m.getRating())
                .collect(Collectors.toList());
    }

    /** Mapping #6: 모든 영화 상영시간만 추출하여 리스트 반환 */
    public List<Integer> getAllDurations() {
        return movies.stream()
                .map(Movie::getDuration)
                .collect(Collectors.toList());
    }

    /** Mapping #7: 감독과 개봉연도를 합친 문자열 반환 ("감독: 연도") */
    public List<String> getDirectorWithYear() {
        return movies.stream()
                .map(m -> m.getDirector() + ": " + m.getYear())
                .collect(Collectors.toList());
    }

    /** Mapping #8: 모든 영화의 흥행수익 리스트 반환 */
    public List<Long> getAllBoxOffices() {
        return movies.stream()
                .map(Movie::getBoxOffice)
                .collect(Collectors.toList());
    }

    /** Mapping #9: 영화 객체를 커스텀 객체(예: 제목과 평점만 가진 문자열)로 변환 */
    public List<String> mapToCustomObject() {
        return movies.stream()
                .map(m -> "Movie[" + m.getTitle() + ", " + m.getRating() + "]")
                .collect(Collectors.toList());
    }

    /** Mapping #10: 제네릭 매퍼를 통해 Movie를 임의의 타입으로 변환 */
    public <R> List<R> mapMovies(Function<Movie, R> mapper) {
        return movies.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    // ========================================================
    // C. Sorting (10개)
    // ========================================================

    /** Sorting #1: 영화 제목 오름차순 정렬 */
    public List<Movie> getMoviesSortedByTitleAsc() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .collect(Collectors.toList());
    }

    /** Sorting #2: 영화 제목 내림차순 정렬 */
    public List<Movie> getMoviesSortedByTitleDesc() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .collect(Collectors.toList());
    }

    /** Sorting #3: 평점 내림차순 정렬 */
    public List<Movie> getMoviesSortedByRatingDesc() {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .collect(Collectors.toList());
    }

    /** Sorting #4: 개봉연도 오름차순 정렬 */
    public List<Movie> getMoviesSortedByYearAsc() {
        return movies.stream()
                .sorted(Comparator.comparingInt(Movie::getYear))
                .collect(Collectors.toList());
    }

    /** Sorting #5: 흥행수익 내림차순 정렬 */
    public List<Movie> getMoviesSortedByBoxOfficeDesc() {
        return movies.stream()
                .sorted(Comparator.comparingLong(Movie::getBoxOffice).reversed())
                .collect(Collectors.toList());
    }

    /** Sorting #6: 상영시간 오름차순 정렬 */
    public List<Movie> getMoviesSortedByDurationAsc() {
        return movies.stream()
                .sorted(Comparator.comparingInt(Movie::getDuration))
                .collect(Collectors.toList());
    }

    /** Sorting #7: 영화 장르 오름차순 정렬 */
    public List<Movie> getMoviesSortedByGenre() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getGenre))
                .collect(Collectors.toList());
    }

    /** Sorting #8: 감독 이름 오름차순 정렬 */
    public List<Movie> getMoviesSortedByDirector() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getDirector))
                .collect(Collectors.toList());
    }

    /** Sorting #9: 평점 오름차순 정렬 */
    public List<Movie> getMoviesSortedByRatingAsc() {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating))
                .collect(Collectors.toList());
    }

    /** Sorting #10: 사용자가 제공한 Comparator로 정렬 (예: custom) */
    public List<Movie> sortMovies(Comparator<Movie> comparator) {
        return movies.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    // ========================================================
    // D. Reducing (10개)
    // ========================================================

    /** Reducing #1: 전체 영화 상영시간 합계 */
    public int getTotalDuration() {
        return movies.stream()
                .mapToInt(Movie::getDuration)
                .sum();
    }

    /** Reducing #2: 전체 영화 흥행수익 합계 */
    public long getTotalBoxOffice() {
        return movies.stream()
                .mapToLong(Movie::getBoxOffice)
                .sum();
    }

    /** Reducing #3: 전체 영화의 평균 평점 계산 */
    public double getAverageRating() {
        return movies.stream()
                .mapToDouble(Movie::getRating)
                .average()
                .orElse(0);
    }

    /** Reducing #4: 최고 평점을 가진 영화 반환 (Optional) */
    public Optional<Movie> getMaxRatingMovie() {
        return movies.stream()
                .max(Comparator.comparingDouble(Movie::getRating));
    }

    /** Reducing #5: 가장 오래된 개봉연도 찾기 */
    public int getEarliestYear() {
        return movies.stream()
                .mapToInt(Movie::getYear)
                .min()
                .orElse(0);
    }

    /** Reducing #6: 전체 영화 평점 합계 */
    public double getSumOfRatings() {
        return movies.stream()
                .mapToDouble(Movie::getRating)
                .sum();
    }

    /** Reducing #7: 전체 영화 상영시간의 곱 (누적 곱 계산) */
    public long getProductOfDurations() {
        return movies.stream()
                .map(Movie::getDuration)
                .mapToLong(i -> i)
                .reduce(1L, (a, b) -> a * b);
    }

    /** Reducing #8: 최고 흥행수익을 기록한 영화 반환 (Optional) */
    public Optional<Movie> getMaxBoxOfficeMovie() {
        return movies.stream()
                .max(Comparator.comparingLong(Movie::getBoxOffice));
    }

    /** Reducing #9: 특정 장르 영화의 총 흥행수익 계산 */
    public long getTotalBoxOfficeByGenre(String genre) {
        return movies.stream()
                .filter(m -> m.getGenre().equalsIgnoreCase(genre))
                .mapToLong(Movie::getBoxOffice)
                .sum();
    }

    /** Reducing #10: 전체 영화의 평균 상영시간 계산 */
    public double getAverageDuration() {
        return movies.stream()
                .mapToInt(Movie::getDuration)
                .average()
                .orElse(0);
    }

    // ========================================================
    // E. Collecting / Grouping (10개)
    // ========================================================

    /** Grouping #1: 장르별 영화 목록 그룹화 */
    public Map<String, List<Movie>> groupMoviesByGenre() {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
    }

    /** Grouping #2: 감독별 영화 목록 그룹화 */
    public Map<String, List<Movie>> groupMoviesByDirector() {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getDirector));
    }

    /** Grouping #3: 평점을 기준으로 partitioning (예: 평점이 4.7 이상과 미만) */
    public Map<Boolean, List<Movie>> partitionMoviesByRating(double threshold) {
        return movies.stream()
                .collect(Collectors.partitioningBy(m -> m.getRating() >= threshold));
    }

    /** Grouping #4: 영화 제목들을 특정 구분자(delimiter)로 하나의 문자열로 연결 */
    public String joinMovieTitles(String delimiter) {
        return movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.joining(delimiter));
    }

    /** Grouping #5: 각 장르별 영화 개수 계산 */
    public Map<String, Long> getGenreCount() {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
    }

    /** Grouping #6: 개봉연도별 영화 목록 그룹화 */
    public Map<Integer, List<Movie>> groupMoviesByYear() {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getYear));
    }

    /** Grouping #7: 평점을 소수점 버림한 값(정수) 기준으로 그룹화 */
    public Map<Integer, List<Movie>> groupMoviesByRoundedRating() {
        return movies.stream()
                .collect(Collectors.groupingBy(m -> (int) Math.floor(m.getRating())));
    }

    /** Grouping #8: 상영시간 범주(예: 짧음: <120, 보통: 120~180, 김: >180) 기준으로 그룹화 */
    public Map<String, List<Movie>> groupMoviesByDurationCategory() {
        return movies.stream()
                .collect(Collectors.groupingBy(m -> {
                    if (m.getDuration() < 120) return "Short";
                    else if (m.getDuration() <= 180) return "Medium";
                    else return "Long";
                }));
    }

    /**
     * Grouping #9: 영화 감독별로 영화 목록을 집합(Set)으로 그룹화
     * (각 감독의 영화 목록을 List 대신 Set으로 수집하여 중복 없이 저장)
     */
    public Map<String, Set<Movie>> groupMoviesByDirectorSet() {
        return movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getDirector,
                        Collectors.toSet()
                ));
    }

    /** Grouping #10: 감독별 영화 제목 리스트 그룹화 (Map<Director, List<String>>)
     *  - 감독별로 해당 감독의 영화 제목만 모아서 리스트로 반환
     */
    public Map<String, List<String>> groupMovieTitlesByDirector() {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getDirector,
                        Collectors.mapping(Movie::getTitle, Collectors.toList())));
    }

    // 추가: 전체 영화 목록 반환 (방어적 복사)
    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }
}
