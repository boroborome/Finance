/**
 * 
 */
goog.provide('com.boroborome.finance');
goog.provide('com.boroborome.finance.AddDialogLogic');
goog.provide('com.boroborome.finance.utilfun');

com.boroborome.finance.AddDialogLogic = function(dialog)
{
	this.dialog = dialog;
};
com.boroborome.finance.utilfun.updateRecordRow = function(row, record)
{
	row.dataValue = record;
	
	var date = new Date();
	date.setTime(record.consumeTime * 1000);
	row.setAttribute("onclick", "com.boroborome.finance.selectrow();");
	row.innerHTML = '<td>' + date + '</td><td>' + record.waresName + '</td><td>' + record.price + '</td>'
		+'<td>' + record.amount + '</td><td>' + record.unit + '</td><td>' + record.deadline + '</td>'
		+'<td>' + record.kind + '</td><td>' + record.createTime + '</td><td>' + record.remark + '</td>';
}
com.boroborome.finance.utilfun.appendRecord2Table = function (record)
{
	var row = document.createElement("tr");
	com.boroborome.finance.utilfun.updateRecordRow(row, record)
	document.getElementById('tblFinance').appendChild(row);
};
com.boroborome.finance.utilfun.clearRecordTable = function()
{
	
}
com.boroborome.finance.utilfun.loadFinanceData = function()
{
	$.post('/agent/finance.query',
    {
      name:'Donald Duck',
      city:'Duckburg'
    },
    function(data,status)
    {
    	if (data.charAt(0) != '[')
    	{
    		alert(data);
    		return;
    	}
    	// var aryRecord = JSON.parse(data);
    	//var aryRecord = data.evalJSON(true);
    	var aryRecord = jQuery.parseJSON(data);
    	var allRecords = $('#tblFinance tr[onclick]');
    	allRecords.remove();
    	for (index = 0, size = aryRecord.length;index < size; ++index)
    	{
    		com.boroborome.finance.utilfun.appendRecord2Table(aryRecord[index]);
    	}
 
    });
    
};

com.boroborome.finance.AddDialogLogic.prototype.btnOK=function()  
{
	// collect all information
	var curAction = $('#dlgFinanceInfo').dialog('option', 'action');
	var strDate = $('#addDlgConsumeDate').val();
	var date = new Date(strDate);
	var timestamp = date.getTime();
   	var info = {
   		consumeTime:timestamp/1000,
   		waresName:$('#addDlgWareName').val(),
   		price:$('#addDlgPrice').val(),
   		unit:$('#addDlgUnit').val(),
   		deadline:$('#addDlgDeadline').val(),
   		kind:$('#addDlgKind').val(),
   		remark:$('#addDlgRemark').val()
   		};
   	var dlg = $('#dlgFinanceInfo')[0];
   	var currentRow = dlg.currentRow;
   	if (currentRow != null)
   	{
   		info.createTime = currentRow.dataValue.createTime;
   	}
   	
   	// send information to the server
   	var logic = this;
   	var param = new Object();
   	param.value = JSON.stringify(info);
   	$.post('/agent/finance.' + curAction, param, function(data, status){logic.msgReceved(data, status);});
};
com.boroborome.finance.AddDialogLogic.prototype.msgReceved=function(data, status)
{
	if (data.charAt(0) != '{')
	{
		this.updateTip(data);
		return;
	}
	
	// if the server save it success the show this record in table
//	var record = data.evalJSON(true);
	var record = jQuery.parseJSON(data);
	
	var curAction = $('#dlgFinanceInfo').dialog('option', 'action');
	if (curAction == 'add')
	{
		com.boroborome.finance.utilfun.appendRecord2Table(record);		
	}
	else
	{
		var dlg = $('#dlgFinanceInfo')[0];
	   	var currentRow = dlg.currentRow;
	   	com.boroborome.finance.utilfun.updateRecordRow(currentRow, record)
	}
    this.dialog.dialog( 'close' );
};
com.boroborome.finance.AddDialogLogic.prototype.getTips=function()
{
	return $('.validateTips');
};

com.boroborome.finance.AddDialogLogic.prototype.updateTip=function(msg)
{
	var tipCom = this.getTips();
	tipCom.text( msg ).addClass( 'ui-state-highlight' );
	var logic = this;
	setTimeout(function() {
		tipCom.removeClass( 'ui-state-highlight', 1500 );
	}, 500 );
};
com.boroborome.finance.selectrow = function()
{
	var selected = event.currentTarget.getAttribute("selected");
	selected = (selected == "true") ? "false" : "true";
	event.currentTarget.setAttribute("selected", selected);
};

com.boroborome.finance.initalIndexHtml = function()
{
	$('#btnAdd').click(function()
	{
		$('#dlgFinanceInfo').dialog('option', 'action', 'add');
		$('#dlgFinanceInfo').dialog('open');
	});
	$('#btnModify').click(function()
	{
		var trSet = $('.bordered tr[selected=true]');
		var length = trSet.length;
		//select first one
		if (length < 1)
		{
			return;
		}
		
		var currentRow = trSet[0];
		var dataValue = currentRow.dataValue;
		var dlg = $('#dlgFinanceInfo')[0];
		dlg.currentRow = currentRow;
		
		var date = new Date();
		date.setTime(dataValue.consumeTime * 1000);
		$('#addDlgConsumeDate').val(date);
		$('#addDlgWareName').val(dataValue.waresName);
		$('#addDlgPrice').val(dataValue.price);
		$('#addDlgUnit').val(dataValue.unit);
		$('#addDlgDeadline').val(dataValue.deadline);
		$('#addDlgKind').val(dataValue.kind);
		$('#addDlgRemark').val(dataValue.remark);
		$('#dlgFinanceInfo').dialog('option', 'action', 'modify');
		$('#dlgFinanceInfo').dialog('open');
	   	
	});
	$('#btnDelete').click(function(){
		var trSet = $('.bordered tr[selected=true]');
		var length = trSet.length;
		if (length <= 0)
		{
			return;
		}
		var result = confirm("OK?");
		if (result)
		{
			return;
		}

		var lstInfo = new Object();
		var mapInfo = new Object();
		for (i = 0; i < length; ++i)
		{
			lstInfo[i] = trSet[i].dataValue;
			//mapInfo[]
		}
		// send information to the server
	   	var logic = this;
	   	var param = new Object();
	   	param.value = JSON.stringify(lstInfo);
	   	//$.post('/agent/finance.delete', param, function(data, status){logic.msgReceved(data, status);});
	});
	$('#btnQuery').click(function(){
		com.boroborome.finance.utilfun.loadFinanceData();
	});
  
	var addDialog = $('#dlgFinanceInfo');
	var addDialogLogic = new com.boroborome.finance.AddDialogLogic(addDialog);
    addDialog.dialog({
		autoOpen: false,
		width:400,
		dialogClass: 'no-close',
		buttons: [{
		        	  text: 'OK',
		        	  click: function()
		        	  {
		        	  	var logic = $(this).dialog("option", "dialogLogic");
		        	  	logic.btnOK();
		        	  }
		          }],
		 dialogLogic:addDialogLogic
    });
    
    $('#addDlgConsumeDate').datepicker({dateFormat: 'yy-mm-dd'});
}

