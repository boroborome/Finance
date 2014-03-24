/**
 * 
 */
function init()
{
}

function startSend()
{
	var url = $('#url').val();
	
	var info = {
			"path":$('#path').val() + $('#fileName').val(),
			"newname":$('#newFileName').val()
	   		};
	   	
	   	// send information to the server
	   	var logic = this;
	   	var param = new Object();
//	   	param.filelist = JSON.stringify(info);
	   	param.filelist=[info];
	   	var jsonStr = JSON.stringify(param);
	   	$.post(url, param, function(data, status)
	   			{
	   		alert(data);
	   		alert(status);
	   			});
}