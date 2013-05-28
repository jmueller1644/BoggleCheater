package com.example.bogglecheater;
import java.util.*;
public class Trie {

	// inner node class representing the inner nodes of the trie
	private class Node {
		// inner Node instance variables
		public Character letter;
		public Node[] children;
		public boolean isWord;
		
		// default Node constructor
		public Node() {
			letter = null;
			children = new Node[26];
			isWord = false;
		}
		
		// parameterized Node constructor
		public Node(char l) {
			letter = new Character(l);
			children = new Node[26];
			isWord = false;
		}
	}	// class Node
	// Trie instance variables
	private Node root;
	
	// default Trie constructor
	public Trie() {
		root = new Node();
	}
	
	public void insert(String word) {
		insert(word, root);
	}
	
	private void insert(String word, Node curr) {
		if (word.compareTo("") == 0) {
			curr.isWord = true;
		} else {
			char front = word.charAt(0);
			int index = ((int)front) - 65;
			if (curr.children[index] == null) {
				curr.children[index] = new Node(front);
			}
			insert(word.substring(1), curr.children[index]);
		}
	}
	
	public boolean contains(String word) {
		Node node = validPrefix(word);
		if (node != null && node.isWord) {
			return true;
		} else {
			return false;
		}
	}
	
	public Node validPrefix(String pre) {
		Node curr = root;
		while (!pre.isEmpty()) {
			char front = pre.charAt(0);
			int index = ((int)front) - 65;
			if (curr.children[index] == null) {
				return null;
			}
			curr = curr.children[index];
			pre = pre.substring(1);
		}
		return curr;
	}
}
