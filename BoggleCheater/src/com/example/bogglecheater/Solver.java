package com.example.bogglecheater;
import java.util.*;
public class Solver {
	
	private String[][] board;
	private boolean[][] visited;
	private Hashtable<String, Integer> solution;
	private ArrayList<Map.Entry<String, Integer>> sortedSolution;
	private Hashtable<Character, Integer> alphabet;
	private Trie dictionary;
	
	public Solver(String[][] b, Trie d) {
		board = b;
		visited = new boolean[4][4];
		clearVisited();
		solution = new Hashtable<String, Integer>();
		dictionary = d;
		
		// initialize alphabet
		alphabet = new Hashtable<Character, Integer>();
		alphabet.put('A', 1);
		alphabet.put('B', 4);
		alphabet.put('C', 4);
		alphabet.put('D', 2);
		alphabet.put('E', 1);
		alphabet.put('F', 4);
		alphabet.put('G', 3);
		alphabet.put('H', 4);
		alphabet.put('I', 1);
		alphabet.put('J', 8);
		alphabet.put('K', 5);
		alphabet.put('L', 1);
		alphabet.put('M', 3);
		alphabet.put('N', 1);
		alphabet.put('O', 1);
		alphabet.put('P', 3);
		alphabet.put('Q', 10);
		alphabet.put('R', 1);
		alphabet.put('S', 1);
		alphabet.put('T', 1);
		alphabet.put('U', 2);
		alphabet.put('V', 4);
		alphabet.put('W', 4);
		alphabet.put('X', 8);
		alphabet.put('Y', 4);
		alphabet.put('Z', 10);
	}
	
	private void clearVisited() {
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				visited[i][j] = false;
			}
		}
	}
	
	public void solve() {
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				solve(i, j, "", 0, 1);
				clearVisited();
			}
		}
		sortValues();
		System.out.println(sortedSolution);
		System.out.println(solution.size());
	}
	
	private void solve(int x, int y, String str, int score, int multiplier) {
		visited[y][x] = true;
		if (dictionary.validPrefix(str) != null) {
			str += board[y][x].charAt(0);
			
			// calculate bonuses
			int letterBonus = 1;
			if (board[y][x].length() == 3) {
				String bonus = board[y][x].substring(1);
				if (bonus.compareTo("DL") == 0) {
					letterBonus = 2;
				} else if (bonus.compareTo("TL") == 0) {
					letterBonus = 3;
				} else if (bonus.compareTo("DW") == 0) {
					multiplier *= 2;
				} else if (bonus.compareTo("TW") == 0) {
					multiplier *= 3;
				}
			}
			
			score += letterBonus * alphabet.get(board[y][x].charAt(0));
			if (dictionary.contains(str)) {
				int finalScore = score * multiplier;
				switch (str.length()) {
					case 5:
						finalScore += 5;
						break;
					case 6:
						finalScore += 10;
						break;
					case 7:
						finalScore += 15;
						break;
					case 8:
						finalScore += 20;
						break;
					default:
						if (str.length() > 8) {
							finalScore += 25;
						}
				}
				if (!solution.containsKey(str) || solution.get(str) < finalScore) {
					solution.put(str, finalScore);
				}
			}
			
			if (y < 3) {
				if (x < 3 && !visited[y + 1][x + 1]) 	solve(x + 1, y + 1, str, score, multiplier);
				if (!visited[y + 1][x]) 				solve(x, y + 1, str, score, multiplier);
				if (x > 0 && !visited[y + 1][x - 1])	solve(x - 1, y + 1, str, score, multiplier);
			}
			if (x < 3 && !visited[y][x + 1])			solve(x + 1, y, str, score, multiplier);
			if (x > 0 && !visited[y][x - 1])			solve(x - 1, y, str, score, multiplier);
			if (y > 0) {
				if (x < 3 && !visited[y - 1][x + 1])	solve(x + 1, y - 1, str, score, multiplier);
				if (!visited[y - 1][x])					solve(x, y - 1, str, score, multiplier);
				if (x > 0 && !visited[y - 1][x - 1])	solve(x - 1, y - 1, str, score, multiplier);
			}
		}
		visited[y][x] = false;
	}
	
	private void sortValues() {
		sortedSolution = new ArrayList(solution.entrySet());
		Collections.sort(sortedSolution, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
				return t2.getValue().compareTo(t1.getValue());
			}
		});
	}
}
