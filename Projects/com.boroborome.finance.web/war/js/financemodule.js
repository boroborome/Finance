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

com.boroborome.finance.utilfun.appendRecord2Table = function (record)
{
	var rowData = '<tr><td>' + record.date + '</td><td>' + record.wares + '</td></tr>';
	$('#tblFinance').append(rowData);
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
    	for (index = 0, size = aryRecord.length;index < size; ++index)
    	{
    		com.boroborome.finance.utilfun.appendRecord2Table(aryRecord[index]);
    	}
 
    });
    
};

com.boroborome.finance.AddDialogLogic.prototype.btnOK=function()  
{
	// collect all information
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
   	
   	// send information to the server
   	var logic = this;
   	var param = new Object();
   	param.value = JSON.stringify(info);
   	$.post('/agent/finance.add', param, function(data, status){logic.msgReceved(data, status);});
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
	com.boroborome.finance.utilfun.appendRecord2Table(record);
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
com.boroborome.finance.initalIndexHtml = function()
{
	$('#btnAdd').click(function()
	{
		$('#dlgFinanceInfo').dialog('open');
	});
	$('#btnModify').click(function()
	{
  
	});
	$('#btnDelete').click(function(){
  
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

