<h2><a href="https://leetcode.com/problems/maximum-alternating-subsequence-sum/">1911. Maximum Alternating Subsequence Sum</a></h2><h3>Medium</h3><hr><div speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">The <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">alternating sum</strong> of a <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">0-indexed</strong> array is defined as the <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">sum</strong> of the elements at <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">even</strong> indices <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">minus</strong> the <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">sum</strong> of the elements at <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">odd</strong> indices.</p>

<ul speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">For example, the alternating sum of <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">[4,2,5,3]</code> is <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">(4 + 5) - (2 + 3) = 4</code>.</li>
</ul>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Given an array <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">nums</code>, return <em speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">the <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">maximum alternating sum</strong> of any subsequence of </em><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">nums</code><em speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"> (after <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">reindexing</strong> the elements of the subsequence)</em>.</p>

<ul speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">
</ul>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">A <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">subsequence</strong> of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">[2,7,4]</code> is a subsequence of <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">[4,<u speechify-initial-font-family="monospace" speechify-initial-font-size="13px">2</u>,3,<u speechify-initial-font-family="monospace" speechify-initial-font-size="13px">7</u>,2,1,<u speechify-initial-font-family="monospace" speechify-initial-font-size="13px">4</u>]</code> (the underlined elements), while <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">[2,4,2]</code> is not.</p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">&nbsp;</p>
<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong class="example" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Example 1:</strong></p>

<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px" style="position: relative;"><strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Input:</strong> nums = [<u speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">4</u>,<u speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">2</u>,<u speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">5</u>,3]
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Output:</strong> 7
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Explanation:</strong> It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong class="example" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Example 2:</strong></p>

<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px" style="position: relative;"><strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Input:</strong> nums = [5,6,7,<u speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">8</u>]
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Output:</strong> 8
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Explanation:</strong> It is optimal to choose the subsequence [8] with alternating sum 8.
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong class="example" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Example 3:</strong></p>

<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px" style="position: relative;"><strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Input:</strong> nums = [<u speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">6</u>,2,<u speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">1</u>,2,4,<u speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">5</u>]
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Output:</strong> 10
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Explanation:</strong> It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">&nbsp;</p>
<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Constraints:</strong></p>

<ul speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">1 &lt;= nums.length &lt;= 10<sup speechify-initial-font-family="monospace" speechify-initial-font-size="9.75px">5</sup></code></li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">1 &lt;= nums[i] &lt;= 10<sup speechify-initial-font-family="monospace" speechify-initial-font-size="9.75px">5</sup></code></li>
</ul></div>