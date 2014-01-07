/**
 * 
 */
goog.provide('com.boroborome.finance');
goog.provide('com.boroborome.finance.AddDialogLogic');


com.boroborome.finance.AddDialogLogic = function(dialog)
{
	this.dialog = dialog;
};

com.boroborome.finance.AddDialogLogic.prototype.appendRecord2Table = function (record)
{
};
com.boroborome.finance.AddDialogLogic.prototype.loadFinanceData = function()
{
	$.post('/agent/finance.query',
    {
      name:'Donald Duck',
      city:'Duckburg'
    },
    function(data,status)
    {
    	if (data.charAt(0) != '\'')
    	{
    		alert(data);
    		return;
    	}
    	// var aryRecord = JSON.parse(data);
    	var aryRecord = data.evalJSON(true);
    	for (index = 0, size = aryRecord.length;index < size; ++index)
    	{
    		var record = aryRecord[index];
    		var rowData = '<tr><td>' + record.date + '</td><td>'
    			+ record.wares + '</td></tr>';
    		$('#tblFinance').append(rowData);
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
   		consumeTime:timestamp,
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
	var record = data.evalJSON(true);
	this.appendRecord2Table(record);
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

