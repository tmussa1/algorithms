<h2><a href="https://leetcode.com/problems/recyclable-and-low-fat-products/">1757. Recyclable and Low Fat Products</a></h2><h3>Easy</h3><hr><div class="sql-schema-wrapper__3VBi" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><a class="sql-schema-link__3cEg" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">SQL Schema<svg viewBox="0 0 24 24" width="1em" height="1em" class="icon__1Md2" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><path fill-rule="evenodd" d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"></path></svg></a></div><div speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Table: <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">Products</code></p>

<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px" style="position: relative;">+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| product_id  | int     |
| low_fats    | enum    |
| recyclable  | enum    |
+-------------+---------+
product_id is the primary key (column with unique values) for this table.
low_fats is an ENUM (category) of type ('Y', 'N') where 'Y' means this product is low fat and 'N' means it is not.
recyclable is an ENUM (category) of types ('Y', 'N') where 'Y' means this product is recyclable and 'N' means it is not.<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">&nbsp;</p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Write a solution to find the ids of products that are both low fat and recyclable.</p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Return the result table in <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">any order</strong>.</p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">The result format is in the following example.</p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">&nbsp;</p>
<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong class="example" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Example 1:</strong></p>

<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px" style="position: relative;"><strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Input:</strong> 
Products table:
+-------------+----------+------------+
| product_id  | low_fats | recyclable |
+-------------+----------+------------+
| 0           | Y        | N          |
| 1           | Y        | Y          |
| 2           | N        | Y          |
| 3           | Y        | Y          |
| 4           | N        | N          |
+-------------+----------+------------+
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Output:</strong> 
+-------------+
| product_id  |
+-------------+
| 1           |
| 3           |
+-------------+
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Explanation:</strong> Only products 1 and 3 are both low fat and recyclable.
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>