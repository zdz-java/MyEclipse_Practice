$(function(){
	
});
function deleteOrder(oid)
{
	url = "delOrder?oid="+oid;
	$(this).get(url,function(){
		alert("删除成功");
	});
};
