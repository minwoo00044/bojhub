import java.util.*;
import java.io.*;

public class Solution {
    // 비용 전처리를 위한 배열
    static int[] cost = new int[42];
    // 집들의 좌표를 저장할 클래스
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 운영 비용 전처리 (K * K + (K-1) * (K-1))
        for (int i = 1; i <= 41; i++) {
            cost[i] = (i * i) + ((i - 1) * (i - 1));
        }

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Point> houses = new ArrayList<>();
            // acc[r][c][dist] : (r,c)에서 특정 거리에 있는 집의 개수
            int[][][] acc = new int[N][N][41];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (val == 1) {
                        houses.add(new Point(i, j));
                    }
                }
            }

            // 2. 모든 좌표로부터 각 집까지의 거리 카운팅
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (Point p : houses) {
                        int dist = Math.abs(i - p.r) + Math.abs(j - p.c);
                        if (dist <= 40) {
                            acc[i][j][dist]++;
                        }
                    }
                }
            }

            // 3. 거리별 누적합 계산 (dist 이하의 모든 집 개수)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 1; k <= 40; k++) {
                        acc[i][j][k] += acc[i][j][k - 1];
                    }
                }
            }

            int answer = 0;
            // 4. 모든 좌표에서 모든 K값(서비스 범위) 시도
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // K는 1부터 최대 2*N 수준까지 (여기선 41까지)
                    for (int k = 1; k <= 41; k++) {
                        int currentCost = cost[k];
                        // 서비스 범위 K는 거리가 k-1인 곳까지 닿음
                        int houseCount = acc[i][j][k - 1];

                        // 손해를 보지 않는다면 (이익 >= 0)
                        if (houseCount * M >= currentCost) {
                            answer = Math.max(answer, houseCount);
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}