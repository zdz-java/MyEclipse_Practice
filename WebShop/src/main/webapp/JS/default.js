$(function(){
	$("#qKey").focus(function(){
		var txt_value = $(this).val();
		if(txt_value=="商品关键字"){
			$(this).val("");
		};
	});
	$("#searchButton").click(function(){
		var url = "searchMer?cateid="+$("#category").val();
		var key = $("#qKey").val();
		if (key !=null && key!="商品关键字" && key.length>0)
			url = url+"&key="+key;
		alert(url);
		location.href = url;
	});
	
});