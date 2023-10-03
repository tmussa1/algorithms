<h2><a href="https://leetcode.com/problems/maximum-number-of-balloons/">1189. Maximum Number of Balloons</a></h2><h3>Easy</h3><hr><div speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Given a string <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">text</code>, you want to use the characters of <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">text</code> to form as many instances of the word <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">"balloon"</strong> as possible.</p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">You can use each character in <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">text</code> <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">at most once</strong>. Return the maximum number of instances that can be formed.</p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">&nbsp;</p>
<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong class="example" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Example 1:</strong></p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><img alt="" src="https://assets.leetcode.com/uploads/2019/09/05/1536_ex1_upd.JPG" style="width: 132px; height: 35px;" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"></strong></p>

<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px" style="position: relative;"><strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Input:</strong> text = "nlaebolko"
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Output:</strong> 1
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong class="example" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Example 2:</strong></p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><img alt="" src="https://assets.leetcode.com/uploads/2019/09/05/1536_ex2_upd.JPG" style="width: 267px; height: 35px;" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"></strong></p>

<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px" style="position: relative;"><strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Input:</strong> text = "loonbalxballpoon"
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Output:</strong> 2
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong class="example" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Example 3:</strong></p>

<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px" style="position: relative;"><strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Input:</strong> text = "leetcode"
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Output:</strong> 0
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">&nbsp;</p>
<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Constraints:</strong></p>

<ul speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">1 &lt;= text.length &lt;= 10<sup speechify-initial-font-family="monospace" speechify-initial-font-size="9.75px">4</sup></code></li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">text</code> consists of lower case English letters only.</li>
</ul>
</div>