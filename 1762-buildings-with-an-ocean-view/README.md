<h2><a href="https://leetcode.com/problems/buildings-with-an-ocean-view/">1762. Buildings With an Ocean View</a></h2><h3>Medium</h3><hr><div><p>There are <code>n</code> buildings in a line. You are given an integer array <code>heights</code> of size <code>n</code> that represents the heights of the buildings in the line.</p>

<p>The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a <strong>smaller</strong> height.</p>

<p>Return a list of indices <strong>(0-indexed)</strong> of buildings that have an ocean view, sorted in increasing order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre style="position: relative;"><strong>Input:</strong> heights = [4,2,3,1]
<strong>Output:</strong> [0,2,3]
<strong>Explanation:</strong> Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><strong class="example">Example 2:</strong></p>

<pre style="position: relative;"><strong>Input:</strong> heights = [4,3,2,1]
<strong>Output:</strong> [0,1,2,3]
<strong>Explanation:</strong> All the buildings have an ocean view.
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><strong class="example">Example 3:</strong></p>

<pre style="position: relative;"><strong>Input:</strong> heights = [1,3,2,4]
<strong>Output:</strong> [3]
<strong>Explanation:</strong> Only building 3 has an ocean view.
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= heights.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= heights[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div>