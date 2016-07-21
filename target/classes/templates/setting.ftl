<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="../stylesheet/bootstrap.css">
</head>
<body>
<div class="container">
	<h1>setting</h1>
	<h3>最近连接</h3>
	<ul id="activeSessions">
	</ul>
	<h3>所有连接</h3>
	<ul id="connections">
	</ul>
	
	
</div>
</body>
<script src="../javascripts/jquery-1.8.0.js"></script>
<script type="text/javascript" src="../javascripts/bootstrap.js"></script>
<script type="text/javascript" >
	$.get("/settings/activeSessions", null, function(msg){
		if(msg.value.list.length!= 0)	
		{
			var liBlock = "";
			$(msg.value.list).each(function(index,element){
				  liBlock += "<li id="+element.connectionId+">"+element.connectionName+"</li>";
			});
			$("#activeSessions").append(liBlock);
		}
	});
	$.get("/settings/connections",null,function(msg){
		if(msg.type=="success")
		{
			var liBlock = "";
			$(msg.value.list).each(function(index,element){
				 liBlock += "<li id="+element.connectionId+"><a href='prepareParam/"+element.connectionId+"'>"+element.connectionName+"</a></li>";
			});
			$("#connections").append(liBlock);
		}
	});

		$("#connections li").click(function(){
			var connectionId = {'connectionId':this.id};
			$.get("prepareParam",connectionId,function(msg){
				alert(msg.type);
			});
		});

	
</script>
</html>