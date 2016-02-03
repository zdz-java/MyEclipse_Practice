$(function(){
	alert("jQuery is used");
	
});
function changeNum(id,amount){
	var url = "changeNum?mid="+id+"&amount="+amount;
	alert("调用修改的方法4");
	alert(url);
//	$(this).get("changeNum",{
//		"mid" : id,
//		"amount" : amount
//	},function(){
//		alert("修改成功");
//	});
	
	$(this).get(url,function(){
		alert("修改成功");
	});
	alert("退出js");
//	$(this).load(url);
};