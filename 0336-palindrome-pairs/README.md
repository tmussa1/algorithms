<h2><a href="https://leetcode.com/problems/palindrome-pairs/">336. Palindrome Pairs</a></h2><h3>Hard</h3><hr><div><p>You are given a <strong>0-indexed</strong> array of <strong>unique</strong> strings <code>words</code>.</p>

<p>A <strong>palindrome pair</strong> is a pair of integers <code>(i, j)</code> such that:</p>

<ul>
	<li><code>0 &lt;= i, j &lt; words.length</code>,</li>
	<li><code>i != j</code>, and</li>
	<li><code>words[i] + words[j]</code> (the concatenation of the two strings) is a <span data-keyword="palindrome-string">palindrome</span>.</li>
</ul>

<p>Return <em>an array of all the <strong>palindrome pairs</strong> of </em><code>words</code>.</p>

<p>You must write an algorithm with&nbsp;<code>O(sum of words[i].length)</code>&nbsp;runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre style="position: relative;"><strong>Input:</strong> words = ["abcd","dcba","lls","s","sssll"]
<strong>Output:</strong> [[0,1],[1,0],[3,2],[2,4]]
<strong>Explanation:</strong> The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><strong class="example">Example 2:</strong></p>

<pre style="position: relative;"><strong>Input:</strong> words = ["bat","tab","cat"]
<strong>Output:</strong> [[0,1],[1,0]]
<strong>Explanation:</strong> The palindromes are ["battab","tabbat"]
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><strong class="example">Example 3:</strong></p>

<pre style="position: relative;"><strong>Input:</strong> words = ["a",""]
<strong>Output:</strong> [[0,1],[1,0]]
<strong>Explanation:</strong> The palindromes are ["a","a"]
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 5000</code></li>
	<li><code>0 &lt;= words[i].length &lt;= 300</code></li>
	<li><code>words[i]</code> consists of lowercase English letters.</li>
</ul>
</div>