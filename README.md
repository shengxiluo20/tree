# tree
根据java的引用特性获取树形json,避免使用递归算法

```
原始数据:
{"id":1,"name":"树节点1","pId":0}
{"id":2,"name":"树节点2","pId":1}
{"id":3,"name":"树节点3","pId":1}
{"id":4,"name":"树节点4","pId":2}
{"id":5,"name":"树节点5","pId":2}
{"id":6,"name":"树节点6","pId":4}
{"id":7,"name":"树节点7","pId":5}
{"id":8,"name":"树节点8","pId":5}
```


```
转换的树形数据
{
	"child": [{
		"child": [{
			"child": [{
				"child": [{
					"child": [],
					"id": 6,
					"name": "树节点6"
				}],
				"id": 4,
				"name": "树节点4"
			}, {
				"child": [{
					"child": [],
					"id": 7,
					"name": "树节点7"
				}, {
					"child": [],
					"id": 8,
					"name": "树节点8"
				}],
				"id": 5,
				"name": "树节点5"
			}],
			"id": 2,
			"name": "树节点2"
		}, {
			"child": [],
			"id": 3,
			"name": "树节点3"
		}],
		"id": 1,
		"name": "树节点1"
	}],
	"id": 0,
	"name": "根节点"
}
```

执行:
在 TreeCovertUtil 中执行 main() 方法即可,相比较于递归,代码很好理解